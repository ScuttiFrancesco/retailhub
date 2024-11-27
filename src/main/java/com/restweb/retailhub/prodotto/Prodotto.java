package com.restweb.retailhub.prodotto;

import com.restweb.retailhub.enums.TipoProdotto;
import com.restweb.retailhub.magazzino.Magazzino;
import com.restweb.retailhub.ordine.Ordine;

import java.util.List;

public class Prodotto {
	
	private long id;
	private String nome;
	private String marca;
	private double prezzo;
	private TipoProdotto tipo;
	private int quantita;
	private Magazzino magazzino;
	private List<Ordine> ordini;
	
}
