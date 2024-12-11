package com.restweb.retailhub.magazzino;

import java.util.List;

public interface IMagazzinoService {

	MagazzinoDto inserisci(MagazzinoDto m);
	
	boolean aggiorna (MagazzinoDto m);
	
	boolean elimina (long id);
	
	MagazzinoDto getMagazzinoById(long id);
	
	List<MagazzinoDto> getListaMagazzini();
	
	
	
	
}
