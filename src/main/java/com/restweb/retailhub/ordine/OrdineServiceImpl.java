package com.restweb.retailhub.ordine;

import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.exception.DataConflictException;
import com.restweb.retailhub.prodotto.IProdottoRepository;
import com.restweb.retailhub.prodotto.Prodotto;
import com.restweb.retailhub.prodotto.ProdottoDto;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineServiceImpl implements IOrdineService {

    private final IOrdineRepository or;
    private final ModelMapper mm;
    private final IProdottoRepository pr;

    @Autowired
    public OrdineServiceImpl(IOrdineRepository or, ModelMapper mm, IProdottoRepository pr) {
        this.or = or;
        this.mm = mm;
        this.pr = pr;
    }

    @Override
    public OrdineDtoDaDB inserisci(OrdineDtoDaClient o) {

        List<Ordine> lista = or.findAll();

        if (lista.stream().anyMatch(ord -> ord.getDataOrdine() != null && ord.getDataOrdine().equals(o.getDataOrdine())
                && ord.getCliente().getId() == o.getCliente().getId()
                && ord.getNegozio().getId() == o.getNegozio().getId())) {
            throw new DataConflictException("Ordine già presente in DB");
        }
        if (o.getProdotti() != null) {
            o.getProdotti().forEach(p -> {
                
                pr.modificaQuantita(p.getNome(), p.getMarca(), -p.getQuantita());

            });
        }

        long id = or.recuperaUltimoId() + 1;
        or.setAutoIncrement(id);

        o.calcolaTotale();
        Ordine ord = mm.map(o, Ordine.class);
        //ord.getProdotti().forEach(p -> p.setVecchiaQuantita(p.getQuantita()));

        or.save(ord);

        return mm.map(or.findById(id), OrdineDtoDaDB.class);

    }

    @Override
    public boolean aggiorna(OrdineDtoDaClient o) {

        or.findById(o.getId()).orElseThrow(
                () -> new EntityNotFoundException(String.format("Ordine con id %d non presente in DB", o.getId())));

        List<Ordine> lista = or.findAll();
        lista.remove(or.findById(o.getId()).get());

        if (lista.stream().anyMatch(ord -> ord.getDataOrdine().equals(o.getDataOrdine())
                && ord.getCliente().getId() == o.getCliente().getId()
                && ord.getNegozio().getId() == o.getNegozio().getId())) {
            throw new DataConflictException("Ordine già presente in DB");
        }

        List<Prodotto> prodotti = pr.findAllByOrdine_id(o.getId());
        for (ProdottoDto prod : o.getProdotti()) {
            for (Prodotto prodotto : prodotti) {
                if (prod.getId() == prodotto.getId()) {
                    pr.modificaQuantita(prod.getNome(), prod.getMarca(), -prod.getQuantita());
                }
            }

        }

        o.calcolaTotale();
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
    public List<OrdineDtoDaDB> getListaOrdiniByCliente(long id) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByCliente_id(id);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getListaOrdiniByNegozio(long id) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByNegozio_id(id);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getListaOrdiniByData(LocalDate data) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByDataOrdine(data);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getListaOrdiniByStatoOrdine(StatoOrdine statoOrdine) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByStatoOrdine(statoOrdine);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }

    @Override
    public List<OrdineDtoDaDB> getListaOrdiniByPagamentoOrdine(PagamentoOrdine pagamentoOrdine) {

        List<OrdineDtoDaDB> listaDto = new ArrayList<OrdineDtoDaDB>();
        List<Ordine> lista = or.findAllByPagamentoOrdine(pagamentoOrdine);

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun ordine presente in DB");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, OrdineDtoDaDB.class)));

        return listaDto;
    }
}
