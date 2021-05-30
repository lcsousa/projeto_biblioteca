package br.com.polar.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.polar.biblioteca.entity.Book;

@Service
public interface BookService {
	
	public Book findById(Long id);
	
	public List<Book> findByName(String name);
	
	public Book create(Book book);
	
	public Book update(Book book);
	
	public void delete(Long id);
}
