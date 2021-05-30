package br.com.polar.biblioteca.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.polar.biblioteca.entity.Book;
import br.com.polar.biblioteca.repository.BookRepository;
import br.com.polar.biblioteca.service.BookService;

@Service
public class BookServiceImp implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book findById(Long id) {
		Optional<Book> obj = bookRepository.findById(id);
		return obj.get();
	}
	public List<Book> findByName(String name) {
		return bookRepository.findByName(name);
	}
	public Book create(Book book) {
		return bookRepository.save(book);
	}
	public Book update(Book book) {
		return bookRepository.save(book);
	}
	public void delete(Long id) {
		Book book = new Book();
		book.setId(id);
		bookRepository.delete(book);
	}
}
