package com.restweb.retailhub.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cliente")
public class ClienteController {

	private final IClienteService cs;

	@Autowired
	public ClienteController(IClienteService cs) {

		this.cs = cs;
	}

	@PostMapping("/admin/inserisci")
	public ClienteDto inserisci(@RequestBody ClienteDto clienteDto){

		return cs.inserisci(clienteDto);
	}

	@PutMapping("/admin/aggiorna/{id}")
	public ClienteDto aggiorna(@RequestBody ClienteDto clienteDto, @PathVariable("id") long id){

		clienteDto.setId(id);
		boolean aggiornato = cs.aggiorna(clienteDto);
		if (aggiornato) {
			return null;
		} else {
			return clienteDto ;
		}
	}

	@DeleteMapping("/admin/elimina/{id}")
	public String elimina(@PathVariable("id") long id){

		boolean elimnato = cs.elimina(id);
		if (elimnato){
			return "Cliente eliminato con successo";
		} else {
			return "Eliminazione fallita";
		}
	}

	@GetMapping("/getCliente/{id}")
	public ClienteDto getClienteById(@PathVariable("id") long id) {

		return cs.getClienteById(id);
	}
	
	@GetMapping("/getListaClienti")
	public Iterable<ClienteDto> getListaClienti() {
		
		return cs.getListaClienti();
	}

}
