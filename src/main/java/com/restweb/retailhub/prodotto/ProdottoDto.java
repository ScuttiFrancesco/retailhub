package com.restweb.retailhub.prodotto;

import com.restweb.retailhub.enums.TipoProdotto;
import com.restweb.retailhub.magazzino.Magazzino;
import lombok.Data;
import java.sql.Date;

@Data
public class ProdottoDto {

	private long id;
	private String nome;
	private String marca;
	private String lotto;
	private Date dataScadenza;
	private double prezzo;
	private TipoProdotto tipo;
	private int quantita;
	private Magazzino magazzino;

}
