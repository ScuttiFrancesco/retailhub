package com.restweb.retailhub.ordine;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restweb.retailhub.cliente.Cliente;
import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.operatore.Operatore;
import lombok.Data;

@Data
public class OrdineDtoDaDB {

	private long id;
	private double totale;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
	private Date dataOrdine;
	private StatoOrdine statoOrdine;
	private PagamentoOrdine pagamentoOrdine;
	private Cliente cliente;
	private Operatore operatore;
	private Negozio negozio;
	

}
