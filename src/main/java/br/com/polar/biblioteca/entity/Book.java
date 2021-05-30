package br.com.polar.biblioteca.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Api(description = "Livros da Biblioteca")
public class Book {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Código único do livro", example = "1")
	private Long id;
	@ApiModelProperty(value = "Nome do livro", example = "Harry Potter")
	private String name;
	@ApiModelProperty(value = "Editora do livro", example = "Bloomsbury Publishing")
	private String publishingCompany;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
