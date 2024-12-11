package com.restweb.retailhub.magazzino;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.restweb.retailhub.exception.DataConflictException;

@Service
public class MagazzinoServiceImpl implements IMagazzinoService {

	private IMagazzinoRepository mr;
	private ModelMapper mm;

	public MagazzinoServiceImpl(IMagazzinoRepository mr, ModelMapper mm) {
		super();
		this.mr = mr;
		this.mm = mm;
	}

	@Override
	public MagazzinoDto inserisci(MagazzinoDto m) {

//		secondo te cosi le eccezioni bastano o va fatto qualcosa di piu complesso?
		List<Magazzino> lista = mr.findAll();

		if (lista.stream().anyMatch(mag -> mag.getIndirizzo().equalsIgnoreCase(m.getIndirizzo()))) {
			throw new DataConflictException("Magazzino già presente in DB");
		}
		if (lista.stream().anyMatch(mag -> mag.getSede().equalsIgnoreCase(m.getSede()))) {
			throw new DataConflictException("Magazzino già presente in DB");
		}
		if (lista.stream().anyMatch(mag -> mag.getTelefono().equalsIgnoreCase(m.getTelefono()))) {
			throw new DataConflictException("Magazzino già presente in DB");
		}

		long id = mr.recuperaUltimoId();
		mr.setAutoIncrement(id);

		mr.save(mm.map(m, Magazzino.class));

		return mm.map(mr.findById(id), MagazzinoDto.class);
	}

	@Override
	public boolean aggiorna(MagazzinoDto m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean elimina(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MagazzinoDto getMagazzinoById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MagazzinoDto> getListaMagazzini() {
		// TODO Auto-generated method stub
		return null;
	}

}
