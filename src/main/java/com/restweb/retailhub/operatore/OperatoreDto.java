package com.restweb.retailhub.operatore;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restweb.retailhub.negozio.NegozioDto;
import com.restweb.retailhub.persona.PersonaDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OperatoreDto extends PersonaDto {

	
	private long id;
	@NotNull(message = "Campo data assunzione obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
	private LocalDate dataAssunzione;
	private int livello;
	private NegozioDto negozio;
	
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
