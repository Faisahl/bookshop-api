package service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import entity.Book;

public interface BookService {
	ResponseEntity<List<Book>> fetchBooks();
	Book fetchBookById(Long id);
	ResponseEntity<String> saveBook(Book book);
	ResponseEntity<Book> updateBook(Book book, long id);
	ResponseEntity<String> deleteBook(long id);
}
