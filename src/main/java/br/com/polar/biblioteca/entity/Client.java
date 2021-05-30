package br.com.polar.biblioteca.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Api (description = "Clientes da biblioteca" )
public class Client {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Código único do cliente",example = "1")
	private Long id;
	@ApiModelProperty(value = "Nome do cliente", example = "maria jose")
	private String name;
	@ApiModelProperty(value = "Data de nascimento do cliente",example = "2020-02-02")
	private LocalDate birthDate;
	@ApiModelProperty(value = "Cadastro único da pessoa",example = "55522233344")
	private String cpf;
	@ApiModelProperty(value = "Telefone do cliente",example = "75-99999-9999")
	private String tell;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	
	
	

	
}
