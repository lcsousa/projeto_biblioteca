package br.com.polar.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.polar.biblioteca.entity.Client;
import br.com.polar.biblioteca.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
	}
}
