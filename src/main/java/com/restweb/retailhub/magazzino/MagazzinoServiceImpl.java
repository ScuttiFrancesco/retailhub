package com.restweb.retailhub.magazzino;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restweb.retailhub.exception.DataConflictException;

@Service
public class MagazzinoServiceImpl implements IMagazzinoService {

	private IMagazzinoRepository mr;
	private ModelMapper mm;

	@Autowired
	public MagazzinoServiceImpl(IMagazzinoRepository mr, ModelMapper mm) {
		this.mr = mr;
		this.mm = mm;
	}

	@Override
	public MagazzinoDto inserisci(MagazzinoDto m) {

		m.trimCampi();
//		secondo te cosi le eccezioni bastano o va fatto qualcosa di piu complesso?
		List<Magazzino> lista = mr.findAll();

		if (lista.stream().anyMatch(mag -> mag.getIndirizzo().equalsIgnoreCase(m.getIndirizzo()) && mag.getSede().equalsIgnoreCase(m.getSede()))) {
			throw new DataConflictException("Magazzino già presente in DB");
		}

		long id = mr.recuperaUltimoId() + 1;
		mr.setAutoIncrement(id);

		mr.save(mm.map(m, Magazzino.class));

		return mm.map(mr.findById(id), MagazzinoDto.class);
	}

	@Override
	public boolean aggiorna(MagazzinoDto m) {

		m.trimCampi();

		mr.findById(m.getId()).orElseThrow(
				() -> new EntityNotFoundException(String.format("magazzino con id %d non presente in DB", m.getId())));

		List<Magazzino> lista = mr.findAll();
		lista.remove(mr.findById(m.getId()).get());

		if (lista.stream().anyMatch(mag -> mag.getIndirizzo().equalsIgnoreCase(m.getIndirizzo()) && mag.getSede().equalsIgnoreCase(m.getSede()))) {
			throw new DataConflictException("Magazzino già presente in DB");
		}

		mr.save(mm.map(m, Magazzino.class));

		return mr.findById(m.getId()).get().equals(mm.map(m, Magazzino.class));
	}

	@Override
	public boolean elimina(long id) {

		mr.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Magazzino con id %d non presente in DB", id)));

		mr.deleteById(id);

		return mr.findById(id).isEmpty();
	}

	@Override
	public MagazzinoDto getMagazzinoById(long id) {

		Magazzino p = mr.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Magazzino con id %d non presente in DB", id)));

		return mm.map(p, MagazzinoDto.class);
	}

	@Override
	public List<MagazzinoDto> getListaMagazzini() {

		List<MagazzinoDto> listaDto = new ArrayList<MagazzinoDto>();
		List<Magazzino> lista = mr.findAll();

		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun magazzino presente in DB");
		}

		lista.forEach(p -> listaDto.add(mm.map(p, MagazzinoDto.class)));

		return listaDto;
	}

}
