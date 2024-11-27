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

	public Ordine(long id, double totale, StatoOrdine statoOrdine, PagamentoOrdine pagamentoOrdine, Cliente cliente,
			Operatore operatore, Negozio negozio, List<Prodotto> prodotti) {
		this.id = id;
		this.totale = totale;
		this.statoOrdine = statoOrdine;
		this.pagamentoOrdine = pagamentoOrdine;
		this.cliente = cliente;
		this.operatore = operatore;
		this.negozio = negozio;
		this.prodotti = prodotti;
	}

	public Ordine() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public StatoOrdine getStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(StatoOrdine statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public PagamentoOrdine getPagamentoOrdine() {
		return pagamentoOrdine;
	}

	public void setPagamentoOrdine(PagamentoOrdine pagamentoOrdine) {
		this.pagamentoOrdine = pagamentoOrdine;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Operatore getOperatore() {
		return operatore;
	}

	public void setOperatore(Operatore operatore) {
		this.operatore = operatore;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
}
