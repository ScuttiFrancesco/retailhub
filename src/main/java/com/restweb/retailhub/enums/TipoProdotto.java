package com.restweb.retailhub.enums;

public enum TipoProdotto {

	// Categorie generali
	ALIMENTARI, BEVANDE, ELETTRONICA, ABBIGLIAMENTO, SCARPE, ACCESSORI, MOBILI, COSMETICI, GIOCATTOLI, LIBRI, MUSICA,
	FILM, FARMACI, SPORT, AUTO, MOTO, BICI, GADGET, UTENSILI, ELETTRODOMESTICI,

	// Specifici per settori
	INFORMATICA, // PC, stampanti, periferiche
	TELEFONIA, // Smartphone, accessori
	LUSSO, // Gioielli, orologi
	ARREDAMENTO, // Sedie, tavoli
	CARTOLERIA, // Penne, quaderni
	FAI_DA_TE, // Utensili, materiali per bricolage
	PESCHERIA, // Pesce fresco
	MACELLERIA, // Carne
	PANETTERIA, // Pane e prodotti da forno

	// Categorie virtuali
	SOFTWARE, SERVIZI, ABBONAMENTI, GIFT_CARD,

	// Per generi alimentari
	BIOLOGICO, VEGANO, GLUTEN_FREE, SURGELATI, FRESCHI,

	// Per settori specifici
	MATERIALI_EDILI, STRUMENTI_MUSICALI, ATTREZZATURE_MEDICHE, LIBRI_SCOLASTICI, VIDEOGIOCHI;
}
