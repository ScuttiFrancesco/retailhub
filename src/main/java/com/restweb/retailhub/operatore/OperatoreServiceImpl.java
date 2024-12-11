package com.restweb.retailhub.operatore;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restweb.retailhub.exception.DataConflictException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OperatoreServiceImpl implements IOperatoreService {

	private final IOperatoreRepository or;
	private final ModelMapper mm;

	@Autowired
	public OperatoreServiceImpl(IOperatoreRepository or, ModelMapper mm) {
		this.or = or;
		this.mm = mm;
	}

	@Override
	public OperatoreDto inserisci(OperatoreDto o) {

		o.trimCampi();

		List<Operatore> lista = or.findAll();

		if (lista.stream().anyMatch(op -> op.getNome().equalsIgnoreCase(o.getNome())
				&& op.getCognome().equalsIgnoreCase(o.getCognome()) && op.getDdn().equals(o.getDdn()))) {
			throw new DataConflictException("Operatore già presente in DB");
		}

		if (lista.stream().anyMatch(op -> op.getEmail().equals(o.getEmail()))) {
			throw new DataConflictException("Email già presente in DB");
		}

		if (lista.stream().anyMatch(op -> op.getTelefono().equals(o.getTelefono()))) {
			throw new DataConflictException("Telefono già presente in DB");
		}

		long id = or.recuperaUltimoId() + 1;
		or.setAutoIncrement(id);

		or.save(mm.map(o, Operatore.class));

		return mm.map(or.findById(id), OperatoreDto.class);
	}

	@Override
	public boolean aggiorna(OperatoreDto o) {

		o.trimCampi();

		or.findById(o.getId()).orElseThrow(
				() -> new EntityNotFoundException(String.format("Operatore con id %d non presente in DB", o.getId())));

		List<Operatore> lista = or.findAll();
		Operatore operatore = lista.stream().filter(op -> op.getId() == o.getId()).findFirst().orElse(null);
		lista.remove(operatore);

		if (lista.stream().anyMatch(op -> op.getNome().equalsIgnoreCase(o.getNome())
				&& op.getCognome().equalsIgnoreCase(o.getCognome()) && op.getDdn().equals(o.getDdn()))) {
			throw new DataConflictException("Operatore già presente in DB");
		}

		if (lista.stream().anyMatch(op -> op.getEmail().equals(o.getEmail()))) {
			throw new DataConflictException("Email già presente in DB");
		}

		if (lista.stream().anyMatch(op -> op.getTelefono().equals(o.getTelefono()))) {
			throw new DataConflictException("Telefono già presente in DB");
		}

		or.save(mm.map(o, Operatore.class));

		return or.findById(o.getId()).get().equals(mm.map(o, Operatore.class));
	}

	@Override
	public boolean elimina(long id) {

		or.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Operatore con id %d non presente in DB", id)));

		or.deleteById(id);

		return or.findById(id).isEmpty();
	}

	@Override
	public OperatoreDto getOperatoreById(long id) {

		Operatore o = or.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Operatore con id %d non presente in DB", id)));

		return mm.map(o, OperatoreDto.class);
	}

	@Override
	public List<OperatoreDto> getListaOperatori() {

		List<OperatoreDto> listaDto = new ArrayList<OperatoreDto>();
		List<Operatore> lista = or.findAll();

		if (lista.isEmpty()) {
			throw new EntityNotFoundException(String.format("Nessun operatore presente in DB"));
		}

		lista.forEach(o -> listaDto.add(mm.map(o, OperatoreDto.class)));

		return listaDto;
	}

}
