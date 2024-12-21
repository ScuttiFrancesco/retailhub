package com.restweb.retailhub.ordine;

import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.exception.DataConflictException;
import com.restweb.retailhub.magazzino.Magazzino;
import com.restweb.retailhub.magazzino.MagazzinoDto;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineServiceImpl implements IOrdineService{

    private IOrdineRepository or;
    private ModelMapper mm;

    @Autowired
    public OrdineServiceImpl(IOrdineRepository or, ModelMapper mm) {
        this.or = or;
        this.mm = mm;
    }

    @Override
    public OrdineDtoDaDB inserisci(OrdineDtoDaClient o) {

        List<Ordine> lista = or.findAll();

        if (lista.stream().anyMatch(ord -> ord.getDataOrdine().equals(o.getDataOrdine())
                && ord.getCliente().getId()==o.getCliente().getId() && ord.getNegozio().getId()==o.getNegozio().getId())) {
            throw new DataConflictException("Ordine già presente in DB");
        }

        long id = or.recuperaUltimoId() + 1;
        or.setAutoIncrement(id);

        or.save(mm.map(o, Ordine.class));

        return mm.map(or.findById(id), OrdineDtoDaDB.class);


    }

    @Override
    public boolean aggiorna(OrdineDtoDaClient o) {

        or.findById(o.getId()).orElseThrow(
                () -> new EntityNotFoundException(String.format("Ordine con id %d non presente in DB", o.getId())));

        List<Ordine> lista = or.findAll();
        lista.remove(or.findById(o.getId()).get());

        if (lista.stream().anyMatch(ord -> ord.getDataOrdine().equals(o.getDataOrdine())
                && ord.getCliente().getId()==o.getCliente().getId() && ord.getNegozio().getId()==o.getNegozio().getId())) {
            throw new DataConflictException("Ordine già presente in DB");
        }

        or.save(mm.map(o, Ordine.class));

        return or.findById(o.getId()).get().equals(mm.map(o, Ordine.class));
    }

    @Override
    public boolean elimina(long id) {

        or.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Ordine con id %d non presente in DB", id)));

        or.deleteById(id);

        return or.findById(id).isEmpty();
    }

    @Override
    public OrdineDtoDaDB getOrdineById(long id) {

        Ordine p = or.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Ordine con id %d non presente in DB", id)));

        return mm.map(p, OrdineDtoDaDB.class);
    }

    @Override
    public List<OrdineDtoDaDB> getListaOrdini() {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAll();

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getOrdiniByCliente(long id) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByCliente_id(id);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getOrdiniByNegozio(long id) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByNegozio_id(id);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getOrdiniByData(Date data) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByDataOrdine(data);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getOrdiniByStatoOrdine(StatoOrdine statoOrdine) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByStatoOrdine(statoOrdine);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getOrdiniByPagamentoOrdine(PagamentoOrdine pagamentoOrdine) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByPagamentoOrdine(pagamentoOrdine);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }
}
