package com.restweb.retailhub.operatore;

import java.sql.Date;
import java.util.List;

import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.ordine.Ordine;

public class Operatore {
	
	private long id;
	private Date dataAssunzione;
	private int livello;
	private List<Ordine> ordini;
	private Negozio negozio;

}
