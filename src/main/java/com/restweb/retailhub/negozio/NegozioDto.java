package com.restweb.retailhub.negozio;

import java.util.List;
import com.restweb.retailhub.magazzino.Magazzino;
import com.restweb.retailhub.operatore.Operatore;
import com.restweb.retailhub.ordine.Ordine;
import lombok.Data;

@Data
public class NegozioDto {

	private long id;
	private String sede;
	private String indirizzo;
	private String telefono;
	private List<Operatore> operatori;
	private Magazzino magazzino;
	private List<Ordine> ordini;

}