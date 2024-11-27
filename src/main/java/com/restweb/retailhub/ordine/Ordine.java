package com.restweb.retailhub.ordine;

import java.util.List;

import com.restweb.retailhub.cliente.Cliente;
import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.operatore.Operatore;
import com.restweb.retailhub.prodotto.Prodotto;

public class Ordine {

	private long id;
	private double totale;
	private StatoOrdine statoOrdine;
	private PagamentoOrdine pagamentoOrdine;
	private Cliente cliente;
	private Operatore operatore;
	private Negozio negozio;
	private List<Prodotto> prodotti;
}
