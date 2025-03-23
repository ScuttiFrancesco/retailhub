package com.restweb.retailhub.cliente;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restweb.retailhub.persona.PersonaDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClienteDto extends PersonaDto {

	private long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Rome")
	private LocalDate dataRegistrazione;

	public void trimCampi() {
		if (getNome() != null) {
			setNome(getNome().trim());
		}
		if (getCognome() != null) {
			setCognome(getCognome().trim());
		}
		if (getEmail() != null) {
			setEmail(getEmail().trim());
		}
		if (getTelefono() != null) {
			setTelefono(getTelefono().trim());
		}
	}



}
