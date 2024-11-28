package com.restweb.retailhub.persona;

import java.sql.Date;
import lombok.Data;

@Data
public class PersonaDto {

	private String nome;
	private String cognome;
	private Date ddn;
	private String email;
	private String telefono;

}
