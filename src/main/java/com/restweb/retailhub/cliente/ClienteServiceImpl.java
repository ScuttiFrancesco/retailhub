package com.restweb.retailhub.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restweb.retailhub.exception.DataConflictException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl implements IClienteService {

	private final IClienteRepository cr;
	private final ModelMapper mm;

	@Autowired
	public ClienteServiceImpl(IClienteRepository cr, ModelMapper mm) {
		this.cr = cr;
		this.mm = mm;
	}

	@Override
	public ClienteDto inserisci(ClienteDto c) {

		c.trimCampi();

		List<Cliente> lista = cr.findAll();

		if (lista.stream().anyMatch(cli -> cli.getNome().equalsIgnoreCase(c.getNome())
				&& cli.getCognome().equalsIgnoreCase(c.getCognome()) && cli.getDdn().equals(c.getDdn()))) {
			throw new DataConflictException("Cliente già presente in DB");
		}

		if (lista.stream().anyMatch(cli -> cli.getEmail().equals(c.getEmail()))) {
			throw new DataConflictException("Email già presente in DB");
		}

		if (lista.stream().anyMatch(cli -> cli.getTelefono().equals(c.getTelefono()))) {
			throw new DataConflictException("Telefono già presente in DB");
		}

		long id = cr.recuperaUltimoId() + 1;
		cr.setAutoIncrement(id);

		cr.save(mm.map(c, Cliente.class));

		return mm.map(cr.findById(id), ClienteDto.class);
	}

	@Override
	public boolean aggiorna(ClienteDto c) {

		c.trimCampi();
		c.setDataRegistrazione(
				c.getDataRegistrazione() == null ? LocalDate.now() : c.getDataRegistrazione());

		cr.findById(c.getId()).orElseThrow(
				() -> new EntityNotFoundException(String.format("Cliente con id %d non presente in DB", c.getId())));

		List<Cliente> lista = cr.findAll();
		Cliente cliente = lista.stream().filter(cli -> cli.getId() == c.getId()).findFirst().orElse(null);
		lista.remove(cliente);

		if (lista.stream().anyMatch(cli -> cli.getNome().equalsIgnoreCase(c.getNome())
				&& cli.getCognome().equalsIgnoreCase(c.getCognome()) && cli.getDdn().equals(c.getDdn()))) {
			throw new DataConflictException("Cliente già presente in DB");
		}

		if (lista.stream().anyMatch(cli -> cli.getEmail().equals(c.getEmail()))) {
			throw new DataConflictException("Email già presente in DB");
		}

		if (lista.stream().anyMatch(cli -> cli.getTelefono().equals(c.getTelefono()))) {
			throw new DataConflictException("Telefono già presente in DB");
		}

		cr.save(mm.map(c, Cliente.class));

		return cr.findById(c.getId()).get().equals(mm.map(c, Cliente.class));
	}

	@Override
	public boolean elimina(long id) {

		cr.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Cliente con id %d non presente in DB", id)));

		cr.deleteById(id);

		return cr.findById(id).isEmpty();
	}

	@Override
	public ClienteDto getClienteById(long id) {

		Cliente c = cr.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Cliente con id %d non presente in DB", id)));

		return mm.map(c, ClienteDto.class);
	}

	@Override
	public List<ClienteDto> getListaClienti() {

		List<ClienteDto> listaDto = new ArrayList<ClienteDto>();
		List<Cliente> lista = cr.findAll();

		if (lista.isEmpty()) {
			throw new EntityNotFoundException(String.format("Nessun cliente presente in DB"));
		}

		lista.forEach(c -> listaDto.add(mm.map(c, ClienteDto.class)));

		return listaDto;
	}

}
