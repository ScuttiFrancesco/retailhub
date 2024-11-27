package com.restweb.retailhub.cliente;

import java.sql.Date;
import java.util.List;

import com.restweb.retailhub.ordine.Ordine;
import com.restweb.retailhub.persona.Persona;

public class Cliente extends Persona {

	private long id;
	private Date dataRegistrazione;
	private List<Ordine> ordini;

	public Cliente(String nome, String cognome, Date ddn, String email, String telefono, long id,
			Date dataRegistrazione, List<Ordine> ordini) {
		super(nome, cognome, ddn, email, telefono);
		this.id = id;
		this.dataRegistrazione = dataRegistrazione;
		this.ordini = ordini;
	}

	public Cliente() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

}
