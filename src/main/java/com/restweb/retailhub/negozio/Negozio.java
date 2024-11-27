package com.restweb.retailhub.negozio;

import java.util.List;

import com.restweb.retailhub.magazzino.Magazzino;
import com.restweb.retailhub.operatore.Operatore;
import com.restweb.retailhub.ordine.Ordine;

public class Negozio {

	private long id;
	private String sede;
	private String indirizzo;
	private String telefono;
	private List<Operatore> operatori;
	private Magazzino magazzino;
	private List<Ordine> ordini;

	public Negozio(long id, String sede, String indirizzo, String telefono, List<Operatore> operatori,
			Magazzino magazzino, List<Ordine> ordini) {
		this.id = id;
		this.sede = sede;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.operatori = operatori;
		this.magazzino = magazzino;
		this.ordini = ordini;
	}

	public Negozio() {
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

	public List<Operatore> getOperatori() {
		return operatori;
	}

	public void setOperatori(List<Operatore> operatori) {
		this.operatori = operatori;
	}

	public Magazzino getMagazzino() {
		return magazzino;
	}

	public void setMagazzino(Magazzino magazzino) {
		this.magazzino = magazzino;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
}
