package com.restweb.retailhub.ordine;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {

    private final IOrdineService os;

    public OrdineController(IOrdineService os) {
        this.os = os;
    }

    @PostMapping("/admin/inserisci")
    public OrdineDtoDaDB inserisci(@RequestBody OrdineDtoDaClient ordineDto){

        return os.inserisci(ordineDto);
    }

    @PutMapping("/admin/aggiorna/{id}")
    public OrdineDtoDaDB aggiorna(@RequestBody OrdineDtoDaClient ordineDto, @PathVariable("id") long id){

        ordineDto.setId(id);
        boolean aggiornato = os.aggiorna(ordineDto);
        if (aggiornato) {
            return null;
        } else {
            return os.getOrdineById(id) ;
        }
    }

    @DeleteMapping("/admin/elimina/{id}")
    public String elimina(@PathVariable("id") long id){

        boolean elimnato = os.elimina(id);
        if (elimnato){
            return "Ordine eliminato con successo";
        } else {
            return "Eliminazione fallita";
        }
    }

    @GetMapping("/getOrdine/{id}")
    public OrdineDtoDaDB getOrdineById(@PathVariable("id") long id) {

        return os.getOrdineById(id);
    }

    @GetMapping("/getListaOrdini")
    public Iterable<OrdineDtoDaDB> getListaOrdini() {

        return os.getListaOrdini();
    }
}
