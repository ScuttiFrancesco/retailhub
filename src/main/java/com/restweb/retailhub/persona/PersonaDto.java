package com.restweb.retailhub.persona;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaDto {

	private String nome;
	private String cognome;
	@NotNull(message = "Campo data di nascita obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
	private LocalDate ddn;
	private String email;
	private String telefono;

}
