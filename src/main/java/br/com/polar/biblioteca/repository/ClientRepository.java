package br.com.polar.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.polar.biblioteca.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
