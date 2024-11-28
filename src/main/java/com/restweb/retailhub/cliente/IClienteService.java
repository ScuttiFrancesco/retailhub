package com.restweb.retailhub.cliente;

import java.util.List;

public interface IClienteService {
	
	ClienteDto inserisci(ClienteDto c);

	boolean aggiorna(ClienteDto c);
	
	boolean elimina(long id);
	
	ClienteDto getClienteById(long id);
	
	List<ClienteDto> getListaClienti();
}
