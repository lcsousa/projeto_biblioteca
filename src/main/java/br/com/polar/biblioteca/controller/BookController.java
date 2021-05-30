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

import br.com.polar.biblioteca.entity.Book;
import br.com.polar.biblioteca.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/books")
@Api(value = "controle de livros", description = "Controle dos serviços de livros")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Buscar livro por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista recuperada com sucesso"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "O acesso ao recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public ResponseEntity<Book> findById(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
	}

	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Buscar livro por nome")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista recuperada com sucesso"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "O acesso ao recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public ResponseEntity<List<Book>> findByName(@RequestParam String name) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.findByName(name));
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Criar livro")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Lista recuperada com sucesso"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "O acesso ao recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public ResponseEntity<Book> create(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(book));
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Atualizar livro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista recuperada com sucesso"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "O acesso ao recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public ResponseEntity<Book> update(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.update(book));
	}

	@DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Deletar livro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista recuperada com sucesso"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "O acesso ao recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public ResponseEntity<Book> delete(@PathVariable(value = "id") Long id) {
		bookService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
