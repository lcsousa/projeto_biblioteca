package br.com.polar.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.polar.biblioteca.entity.Client;

@Service
public interface ClientService {

	
	public Client findById(Long id);
	
	public List<Client> findByName(String name);
	
	public Client create(Client client);
	
	public Client update(Client client);
	
	public void delete(Long id);
}
