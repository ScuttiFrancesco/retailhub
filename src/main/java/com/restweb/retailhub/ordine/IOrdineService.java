package com.restweb.retailhub.ordine;

import java.util.List;

public interface IOrdineService {

    OrdineDtoDaDB inserisci(OrdineDtoDaClient o);

    boolean aggiorna(OrdineDtoDaClient o);

    boolean elimina(long id);

    OrdineDtoDaDB getOrdineById(long id);

    List<OrdineDtoDaDB> getListaOrdini();
}
