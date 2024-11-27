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

	public Magazzino(long id, String sede, String indirizzo, String telefono, Negozio negozio, List<Prodotto> prodotti,
			List<Operatore> operatori) {
		this.id = id;
		this.sede = sede;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.negozio = negozio;
		this.prodotti = prodotti;
		this.operatori = operatori;
	}

	public Magazzino() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public List<Operatore> getOperatori() {
		return operatori;
	}

	public void setOperatori(List<Operatore> operatori) {
		this.operatori = operatori;
	}

}
