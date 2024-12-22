package com.restweb.retailhub.negozio;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/negozio")
public class NegozioController {

    private final INegozioService ns;

    public NegozioController(INegozioService ns) {
        this.ns = ns;
    }

    @PostMapping("/admin/inserisci")
    public NegozioDto inserisci(@RequestBody NegozioDto n){

        return ns.inserisci(n);
    }

    @PutMapping("/admin/aggiorna/{id}")
    public NegozioDto aggiorna(@RequestBody NegozioDto n, @PathVariable("id") long id){

        n.setId(id);
        boolean aggiornato = ns.aggiorna(n);
        if (aggiornato) {
            return null;
        } else {
            return n ;
        }
    }

    @DeleteMapping("/admin/elimina/{id}")
    public String elimina(@PathVariable("id") long id){

        boolean eliminato = ns.elimina(id);
        if (eliminato){
            return "Negozio eliminato con successo";
        } else {
            return "Eliminazione fallita";
        }
    }

    @GetMapping("/getNegozio/{id}")
    public NegozioDto getNegozioById(@PathVariable("id") long id) {

        return ns.getNegozioById(id);
    }

    @GetMapping("/getListaNegozi")
    public Iterable<NegozioDto> getListaNegozi() {

        return ns.getListaNegozi();
    }
}
