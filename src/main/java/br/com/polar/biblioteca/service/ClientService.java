package br.com.polar.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.polar.biblioteca.entity.Client;
import br.com.polar.biblioteca.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll(){
		return clientRepository.findAll();
	}

	
}
