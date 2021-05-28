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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clients")
@Api ( value = "onlinestore" , description = "Controle dos serviços de cliente" )
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	/* @GetMapping
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
	} */
	@GetMapping(value = "/{id}",produces="application/json")
	@ApiOperation ( value = "Buscar cliente por ID" )
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "Lista recuperada com sucesso" ) ,
	        @ApiResponse ( code = 401 , message = "Você não está autorizado a visualizar o recurso" ) ,
	        @ApiResponse ( code = 403 , message = "O acesso ao recurso que você estava tentando acessar é proibido" ) ,
	        @ApiResponse ( code = 404 , message = "O recurso que você estava tentando acessar não foi encontrado" )
	}
	)
	public ResponseEntity<Client> findById(@PathVariable (value = "id")Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
	}
	@GetMapping(produces="application/json")
	@ApiOperation ( value = "Buscar cliente por nome" )
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "Lista recuperada com sucesso" ) ,
	        @ApiResponse ( code = 401 , message = "Você não está autorizado a visualizar o recurso" ) ,
	        @ApiResponse ( code = 403 , message = "O acesso ao recurso que você estava tentando acessar é proibido" ) ,
	        @ApiResponse ( code = 404 , message = "O recurso que você estava tentando acessar não foi encontrado" )
	}
	)
	public ResponseEntity<List<Client>> findByName(@RequestParam String name) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findByName(name));
	}
	
	@PostMapping(produces="application/json", consumes="application/json")
	@ApiOperation ( value = "Criar cliente" )
	@ApiResponses ( value = {
	        @ApiResponse ( code = 201 , message = "Lista recuperada com sucesso" ) ,
	        @ApiResponse ( code = 401 , message = "Você não está autorizado a visualizar o recurso" ) ,
	        @ApiResponse ( code = 403 , message = "O acesso ao recurso que você estava tentando acessar é proibido" ) ,
	        @ApiResponse ( code = 404 , message = "O recurso que você estava tentando acessar não foi encontrado" )
	}
	)
	public ResponseEntity<Client> create(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(client));
	}
	
	@PutMapping(produces="application/json", consumes="application/json")
	@ApiOperation ( value = "Atualizar cliente" )
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "Lista recuperada com sucesso" ) ,
	        @ApiResponse ( code = 401 , message = "Você não está autorizado a visualizar o recurso" ) ,
	        @ApiResponse ( code = 403 , message = "O acesso ao recurso que você estava tentando acessar é proibido" ) ,
	        @ApiResponse ( code = 404 , message = "O recurso que você estava tentando acessar não foi encontrado" )
	}
	)
	public ResponseEntity<Client> update(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.update(client));
	}
	
	@DeleteMapping(value = "/{id}",produces="application/json", consumes="application/json")
	@ApiOperation ( value = "Deletar cliente" )
	@ApiResponses ( value = {
	        @ApiResponse ( code = 200 , message = "Lista recuperada com sucesso" ) ,
	        @ApiResponse ( code = 401 , message = "Você não está autorizado a visualizar o recurso" ) ,
	        @ApiResponse ( code = 403 , message = "O acesso ao recurso que você estava tentando acessar é proibido" ) ,
	        @ApiResponse ( code = 404 , message = "O recurso que você estava tentando acessar não foi encontrado" )
	}
	)
	public ResponseEntity<Client> delete(@PathVariable (value = "id")Long id) {
		clientService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
