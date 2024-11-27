package com.restweb.retailhub.cliente;

import java.sql.Date;
import java.util.List;

import com.restweb.retailhub.ordine.Ordine;

public class Cliente {
	
	private long id;
	private Date dataRegistrazione;
	private List<Ordine> ordini;

}
