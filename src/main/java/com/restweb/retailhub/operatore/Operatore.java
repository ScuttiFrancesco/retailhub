package com.restweb.retailhub.operatore;

import java.sql.Date;
import java.util.List;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.ordine.Ordine;
import com.restweb.retailhub.persona.Persona;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Operatore extends Persona {

	private long id;
	private Date dataAssunzione;
	private int livello;
	private List<Ordine> ordini;
	private Negozio negozio;

}
