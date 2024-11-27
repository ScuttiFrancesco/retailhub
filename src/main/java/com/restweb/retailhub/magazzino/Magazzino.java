package com.restweb.retailhub.magazzino;

import java.util.List;

import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.operatore.Operatore;
import com.restweb.retailhub.prodotto.Prodotto;

public class Magazzino {

	private long id;
	private String sede;
	private String indirizzo;
	private String telefono;
	private Negozio negozio;
	private List<Prodotto> prodotti;
	private List<Operatore> operatori;
	
}
