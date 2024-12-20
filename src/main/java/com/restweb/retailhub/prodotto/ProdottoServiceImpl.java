package com.restweb.retailhub.prodotto;

import com.restweb.retailhub.exception.DataConflictException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdottoServiceImpl implements IProdottoService{

    private final IProdottoRepository pr;
    private final ModelMapper mm;

    @Autowired
    private ProdottoServiceImpl(IProdottoRepository pr, ModelMapper mm) {
        this.pr = pr;
        this.mm = mm;
    }

    @Override
    public ProdottoDto inserisci(ProdottoDto p) {

        p.trimCampi();
        List<Prodotto> lista = pr.findAll();

        if (lista.stream().anyMatch(pro -> pro.getNome().equalsIgnoreCase(p.getNome()) && pro.getMarca().equalsIgnoreCase(p.getMarca()) && pro.getMagazzino().getId()==p.getMagazzino().getId())) {
            throw new DataConflictException("Prodotto già presente nel magazzino selezionato");
        }

        long id = pr.recuperaUltimoId() + 1;
        pr.setAutoincrement(id);

        pr.save(mm.map(p,Prodotto.class));

        return mm.map(pr.findById(id), ProdottoDto.class);
    }

    @Override
    public boolean aggiorna(ProdottoDto p) {

        p.trimCampi();

        pr.findById(p.getId()).orElseThrow(
                () -> new EntityNotFoundException(String.format("Prodotto con id %d non presente nel magazzino selezionato", p.getId())));

        List<Prodotto> lista = pr.findAll();
        lista.remove(pr.findById(p.getId()).get());

        if (lista.stream().anyMatch(pro -> pro.getNome().equalsIgnoreCase(p.getNome()) && pro.getMarca().equalsIgnoreCase(p.getMarca()) && pro.getMagazzino().getId()==p.getMagazzino().getId())) {
            throw new DataConflictException("Prodotto già presente nel magazzino selezionato");
        }

        pr.save(mm.map(p, Prodotto.class));

        return pr.findById(p.getId()).get().equals(mm.map(p,Prodotto.class));
    }

    @Override
    public boolean elimina(long id) {

        pr.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("prodotto con id %d non presente nel magazzino selezionato", id)));

        pr.deleteById(id);

        return pr.findById(id).isEmpty();
}
    @Override
    public ProdottoDto getProdottoById(long id) {

        Prodotto p = pr.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Prodotto con id %d non presente nel magazzino selezionato", id)));

        return mm.map(p, ProdottoDto.class);
    }

    @Override
    public List<ProdottoDto> getListaProdotti() {

        List<ProdottoDto> listaDto = new ArrayList<ProdottoDto>();
        List<Prodotto> lista = pr.findAll();

        if (lista.isEmpty()) {
            throw new EntityNotFoundException("Nessun prodotto presente in magazzino");
        }

        lista.forEach(p -> listaDto.add(mm.map(p, ProdottoDto.class)));

        return listaDto;
    }
}
