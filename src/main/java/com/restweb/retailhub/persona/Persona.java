package com.restweb.retailhub.persona;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@Data
@MappedSuperclass
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cognome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
	private LocalDate ddn;
	private String email;
	private String telefono;

}
