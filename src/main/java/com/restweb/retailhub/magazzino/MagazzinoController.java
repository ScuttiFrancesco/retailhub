package com.restweb.retailhub.magazzino;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/magazzino")
public class MagazzinoController {

    private final IMagazzinoService ms;

    public MagazzinoController(IMagazzinoService ms) {
        this.ms = ms;
    }

    @PostMapping("/magazziniere/inserisci")
    public MagazzinoDto inserisci(@RequestBody MagazzinoDto m){

        return ms.inserisci(m);
    }

    @PutMapping("/magazziniere/aggiorna/{id}")
    public MagazzinoDto aggiorna(@RequestBody MagazzinoDto m, @PathVariable("id") long id){

        m.setId(id);
        boolean aggiornato = ms.aggiorna(m);
        if (aggiornato) {
            return null;
        } else {
            return m ;
        }
    }

    @DeleteMapping("/magazziniere/elimina/{id}")
    public String elimina(@PathVariable("id") long id){

        boolean eliminato = ms.elimina(id);
        if (eliminato){
            return "Magazzino eliminato con successo";
        } else {
            return "Eliminazione fallita";
        }
    }

    @GetMapping("/getMagazzino/{id}")
    public MagazzinoDto getClienteById(@PathVariable("id") long id) {

        return ms.getMagazzinoById(id);
    }

    @GetMapping("/getListaMagazzini")
    public Iterable<MagazzinoDto> getListaMagazzini() {

        return ms.getListaMagazzini();
    }
}
