package com.restweb.retailhub.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

	private IClienteService cs;

	@Autowired
	public ClienteController(IClienteService cs) {
		this.cs = cs;
	}

	@GetMapping("getCliente/{id}")
	public ClienteDto getClienteById(@PathVariable("id") long id) {

		return cs.getClienteById(id);
	}
	
	@GetMapping("getListaClienti")
	public Iterable<ClienteDto> getListaClienti() {
		
		return cs.getListaClienti();
	}

}
