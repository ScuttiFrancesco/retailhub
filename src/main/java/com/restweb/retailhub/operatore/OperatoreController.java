package com.restweb.retailhub.operatore;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operatore")
public class OperatoreController {

    private final IOperatoreService os;

    public OperatoreController(IOperatoreService os) {
        this.os = os;
    }

    @PostMapping("/admin/inserisci")
    public OperatoreDto inserisci(@RequestBody OperatoreDto o){

        return os.inserisci(o);
    }

    @PutMapping("/admin/aggiorna/{id}")
    public OperatoreDto aggiorna(@RequestBody OperatoreDto o, @PathVariable("id") long id){

        o.setId(id);
        boolean aggiornato = os.aggiorna(o);
        if (aggiornato) {
            return null;
        } else {
            return o ;
        }
    }

    @DeleteMapping("/admin/elimina/{id}")
    public String elimina(@PathVariable("id") long id){

        boolean elimnato = os.elimina(id);
        if (elimnato){
            return "Operatore eliminato con successo";
        } else {
            return "Eliminazione fallita";
        }
    }

    @GetMapping("/getOperatore/{id}")
    public OperatoreDto getOperatoreById(@PathVariable("id") long id) {

        return os.getOperatoreById(id);
    }

    @GetMapping("/getListaOperatori")
    public Iterable<OperatoreDto> getListaOperatori() {

        return os.getListaOperatori();
    }
}
