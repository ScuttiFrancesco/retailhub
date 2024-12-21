package com.restweb.retailhub.ordine;

import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;

import java.sql.Date;
import java.util.List;

public interface IOrdineService {

    OrdineDtoDaDB inserisci(OrdineDtoDaClient o);

    boolean aggiorna(OrdineDtoDaClient o);

    boolean elimina(long id);

    OrdineDtoDaDB getOrdineById(long id);

    List<OrdineDtoDaDB> getListaOrdini();

    List<OrdineDtoDaDB> getOrdiniByCliente(long id);

    List<OrdineDtoDaDB> getOrdiniByNegozio(long id);

    List<OrdineDtoDaDB> getOrdiniByData(Date data);

    List<OrdineDtoDaDB> getOrdiniByStatoOrdine(StatoOrdine statoOrdine);

    List<OrdineDtoDaDB> getOrdiniByPagamentoOrdine(PagamentoOrdine pagamentoOrdine);
}
