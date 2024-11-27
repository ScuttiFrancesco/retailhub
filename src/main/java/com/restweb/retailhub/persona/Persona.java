package com.restweb.retailhub.persona;

import java.sql.Date;

public class Persona {

	private String nome;
	private String cognome;
	private Date ddn;
	private String email;
	private String telefono;

	public Persona(String nome, String cognome, Date ddn, String email, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.ddn = ddn;
		this.email = email;
		this.telefono = telefono;
	}

	public Persona() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
