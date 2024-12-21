package com.restweb.retailhub.negozio;

import com.restweb.retailhub.exception.DataConflictException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NegozioServiceImpl implements INegozioService{

	private INegozioRepository nr;
	private ModelMapper mm;

	@Autowired
	public NegozioServiceImpl(INegozioRepository nr, ModelMapper mm) {
		this.nr = nr;
		this.mm = mm;
	}

	@Override
	public NegozioDto inserisci(NegozioDto n) {

		n.trimCampi();
//
		List<Negozio> lista = nr.findAll();

		if (lista.stream().anyMatch(neg -> neg.getIndirizzo().equalsIgnoreCase(n.getIndirizzo()) && neg.getSede().equalsIgnoreCase(n.getSede()))) {
			throw new DataConflictException("Negozio già presente in DB");
		}

		long id = nr.recuperaUltimoId() + 1;
		nr.setAutoIncrement(id);

		nr.save(mm.map(n, Negozio.class));

		return mm.map(nr.findById(id), NegozioDto.class);
	}

	@Override
	public boolean aggiorna(NegozioDto n) {

		n.trimCampi();

		nr.findById(n.getId()).orElseThrow(
				() -> new EntityNotFoundException(String.format("Negozio con id %d non presente in DB", n.getId())));

		List<Negozio> lista = nr.findAll();
		lista.remove(nr.findById(n.getId()).get());

		if (lista.stream().anyMatch(neg -> neg.getIndirizzo().equalsIgnoreCase(n.getIndirizzo()) && neg.getSede().equalsIgnoreCase(n.getSede()))) {
			throw new DataConflictException("Negozio già presente in DB");
		}

		nr.save(mm.map(n, Negozio.class));

		return nr.findById(n.getId()).get().equals(mm.map(n, Negozio.class));
	}

	@Override
	public boolean elimina(long id) {

		nr.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Negozio con id %d non presente in DB", id)));

		nr.deleteById(id);

		return nr.findById(id).isEmpty();
	}

	@Override
	public NegozioDto getNegozioById(long id) {

		Negozio n = nr.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Negozio con id %d non presente in DB", id)));

		return mm.map(n, NegozioDto.class);
	}

	@Override
	public List<NegozioDto> getListaNegozi() {

		List<NegozioDto> listaDto = new ArrayList<NegozioDto>();
		List<Negozio> lista = nr.findAll();

		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun negozio presente in DB");
		}

		lista.forEach(n -> listaDto.add(mm.map(n, NegozioDto.class)));

		return listaDto;
	}

}
