package br.com.polar.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.polar.biblioteca.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
		public List<Book> findByName(String name);
}
