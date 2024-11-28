package com.restweb.retailhub.cliente;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.restweb.retailhub.persona.PersonaDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClienteDto extends PersonaDto {

	private long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataRegistrazione;

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
