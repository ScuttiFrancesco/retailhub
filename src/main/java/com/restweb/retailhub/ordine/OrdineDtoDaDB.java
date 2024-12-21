package com.restweb.retailhub.ordine;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restweb.retailhub.cliente.ClienteDto;
import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.negozio.NegozioDto;
import com.restweb.retailhub.operatore.OperatoreDto;
import lombok.Data;

@Data
public class OrdineDtoDaDB {

	private long id;
	private double totale;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
	private LocalDate dataOrdine;
	private StatoOrdine statoOrdine;
	private PagamentoOrdine pagamentoOrdine;
	private ClienteDto cliente;
	private OperatoreDto operatore;
	private NegozioDto negozio;
	

}
