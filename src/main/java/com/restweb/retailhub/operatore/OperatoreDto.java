package com.restweb.retailhub.operatore;

import java.sql.Date;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.persona.PersonaDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OperatoreDto extends PersonaDto {

	
	private long id;
	@NotNull
	private Date dataAssunzione;
	private int livello;
	private Negozio negozio;

}
