package com.restweb.retailhub.ordine;

import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/getListaOrdiniByCliente/{id}")
    public Iterable<OrdineDtoDaDB> getListaOrdiniByCliente(@PathVariable("id") long id) {

        return os.getListaOrdiniByCliente(id);
    }

    @GetMapping("/getListaOrdiniByNegozio/{id}")
    public Iterable<OrdineDtoDaDB> getListaOrdiniByNegozio(@PathVariable("id") long id) {

        return os.getListaOrdiniByNegozio(id);
    }

    @GetMapping("/getListaOrdiniByData/{data}")
    public Iterable<OrdineDtoDaDB> getListaOrdiniByData(@PathVariable("data") LocalDate data) {

        return os.getListaOrdiniByData(data);
    }

    @GetMapping("/getListaOrdiniByStatoOrdine/{statoOrdine}")
    public Iterable<OrdineDtoDaDB> getListaOrdiniByStatoOrdine(@PathVariable("statoOrdine") String statoOrdine) {

        return os.getListaOrdiniByStatoOrdine(StatoOrdine.valueOf(statoOrdine));
    }

    @GetMapping("/getListaOrdiniByPagamentoOrdine/{pagamentoOrdine}")
    public Iterable<OrdineDtoDaDB> getListaOrdiniByPagamentoOrdine(@PathVariable("pagamentoOrdine") PagamentoOrdine pagamento) {

        return os.getListaOrdiniByPagamentoOrdine(pagamento);
    }
}
