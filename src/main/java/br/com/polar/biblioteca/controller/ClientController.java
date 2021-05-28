package br.com.polar.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.polar.biblioteca.entity.Client;
import br.com.polar.biblioteca.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	/* @GetMapping
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
	} */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable (value = "id")Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
	}
	@GetMapping
	public ResponseEntity<List<Client>> findByName(@RequestParam String name) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findByName(name));
	}
	
	@PostMapping
	public ResponseEntity<Client> create(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(client));
	}
	
	@PutMapping
	public ResponseEntity<Client> update(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.update(client));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Client> delete(@PathVariable (value = "id")Long id) {
		clientService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
