package com.restweb.retailhub.persona;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Data
public class PersonaDto {

	private String nome;
	private String cognome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
	private Date ddn;
	private String email;
	private String telefono;

}
