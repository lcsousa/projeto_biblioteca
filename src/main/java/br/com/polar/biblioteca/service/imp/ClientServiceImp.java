package br.com.polar.biblioteca.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.polar.biblioteca.entity.Client;
import br.com.polar.biblioteca.repository.ClientRepository;
import br.com.polar.biblioteca.service.ClientService;

@Service
public class ClientServiceImp implements ClientService{

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.get();
	}
	
	public List<Client> findByName(String name) {
		return clientRepository.findByName(name);
	}
	
	public Client create(Client client) {
		return clientRepository.save(client);
	}
	public Client update(Client client) {
		return clientRepository.save(client);
	}
	public void delete(Long id) {
		Client client = new Client();
		client.setId(id);
		clientRepository.delete(client);
	}
}
