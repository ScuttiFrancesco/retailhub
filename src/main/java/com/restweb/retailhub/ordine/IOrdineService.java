package com.restweb.retailhub.ordine;

import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IOrdineService {

    OrdineDtoDaDB inserisci(OrdineDtoDaClient o);

    boolean aggiorna(OrdineDtoDaClient o);

    boolean elimina(long id);

    OrdineDtoDaDB getOrdineById(long id);

    List<OrdineDtoDaDB> getListaOrdini();

    List<OrdineDtoDaDB> getListaOrdiniByCliente(long id);

    List<OrdineDtoDaDB> getListaOrdiniByNegozio(long id);

    List<OrdineDtoDaDB> getListaOrdiniByData(LocalDate data);

    List<OrdineDtoDaDB> getListaOrdiniByStatoOrdine(StatoOrdine statoOrdine);

    List<OrdineDtoDaDB> getListaOrdiniByPagamentoOrdine(PagamentoOrdine pagamentoOrdine);
}
