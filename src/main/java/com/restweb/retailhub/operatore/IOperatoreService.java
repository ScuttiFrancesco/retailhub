package com.restweb.retailhub.operatore;

import java.util.List;

public interface IOperatoreService {
	
	OperatoreDto inserisci(OperatoreDto o);

	boolean aggiorna(OperatoreDto o);
	
	boolean elimina(long id);
	
	OperatoreDto getOperatoreById(long id);
	
	List<OperatoreDto> getListaOperatori();

}
