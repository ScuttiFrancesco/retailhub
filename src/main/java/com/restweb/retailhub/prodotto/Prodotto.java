package com.restweb.retailhub.prodotto;

import com.restweb.retailhub.enums.TipoProdotto;
import com.restweb.retailhub.magazzino.Magazzino;
import com.restweb.retailhub.ordine.Ordine;

import java.sql.Date;
import java.util.List;

public class Prodotto {

	private long id;
	private String nome;
	private String marca;
	private String lotto;
	private Date dataScadenza;
	private double prezzo;
	private TipoProdotto tipo;
	private int quantita;
	private Magazzino magazzino;
	private List<Ordine> ordini;

	public Prodotto(long id, String nome, String marca, String lotto, Date dataScadenza, double prezzo,
			TipoProdotto tipo, int quantita, Magazzino magazzino, List<Ordine> ordini) {
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.lotto = lotto;
		this.dataScadenza = dataScadenza;
		this.prezzo = prezzo;
		this.tipo = tipo;
		this.quantita = quantita;
		this.magazzino = magazzino;
		this.ordini = ordini;
	}

	public Prodotto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getLotto() {
		return lotto;
	}

	public void setLotto(String lotto) {
		this.lotto = lotto;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public TipoProdotto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProdotto tipo) {
		this.tipo = tipo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
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
