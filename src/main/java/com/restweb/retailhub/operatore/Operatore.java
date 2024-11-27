package com.restweb.retailhub.operatore;

import java.sql.Date;
import java.util.List;

import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.ordine.Ordine;
import com.restweb.retailhub.persona.Persona;

public class Operatore extends Persona {

	private long id;
	private Date dataAssunzione;
	private int livello;
	private List<Ordine> ordini;
	private Negozio negozio;

	public Operatore(String nome, String cognome, Date ddn, String email, String telefono, long id, Date dataAssunzione,
			int livello, List<Ordine> ordini, Negozio negozio) {
		super(nome, cognome, ddn, email, telefono);
		this.id = id;
		this.dataAssunzione = dataAssunzione;
		this.livello = livello;
		this.ordini = ordini;
		this.negozio = negozio;
	}

	public Operatore() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

}
