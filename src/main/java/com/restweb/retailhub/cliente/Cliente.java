package com.restweb.retailhub.cliente;

import java.sql.Date;
import java.util.List;
import com.restweb.retailhub.ordine.Ordine;
import com.restweb.retailhub.persona.Persona;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Persona {

	private long id;
	private Date dataRegistrazione;
	private List<Ordine> ordini;


}
