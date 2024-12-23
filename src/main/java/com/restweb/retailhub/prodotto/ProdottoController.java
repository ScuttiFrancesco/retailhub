package com.restweb.retailhub.prodotto;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prodotto")
public class ProdottoController {

    private final IProdottoService ps;

    public ProdottoController(IProdottoService ps) {
        this.ps = ps;
    }

    @PostMapping("/magazziniere/inserisci")
    public ProdottoDto inserisci(@RequestBody ProdottoDto p){

        return ps.inserisci(p);
    }

    @PutMapping("/magazziniere/aggiorna/{id}")
    public ProdottoDto aggiorna(@RequestBody ProdottoDto p, @PathVariable("id") long id){

        p.setId(id);
        boolean aggiornato = ps.aggiorna(p);
        if (aggiornato) {
            return null;
        } else {
            return p ;
        }
    }

    @DeleteMapping("/magazziniere/elimina/{id}")
    public String elimina(@PathVariable("id") long id){

        boolean elimnato = ps.elimina(id);
        if (elimnato){
            return "Prodotto eliminato con successo";
        } else {
            return "Eliminazione fallita";
        }
    }

    @GetMapping("/getProdotto/{id}")
    public ProdottoDto getProdottoById(@PathVariable("id") long id) {

        return ps.getProdottoById(id);
    }

    @GetMapping("/getListaProdotti")
    public Iterable<ProdottoDto> getListaProdotti() {

        return ps.getListaProdotti();
    }

    @GetMapping("/getListaProdottiByOrdine/{id}")
    public Iterable<ProdottoDto> getListaProdottiByOrdine(@PathVariable("id") long id) {

        return ps.getListaProdottiByOrdine(id);
    }

    @GetMapping("/getListaProdottiByNegozio/{id}")
    public Iterable<ProdottoDto> getListaProdottiByNegozio(@PathVariable("id") long id) {

        return ps.getListaProdottiByNegozio(id);
    }
}
