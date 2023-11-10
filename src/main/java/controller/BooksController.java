package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Book;
import service.BookService;
import service.BookServiceImpl;

@CrossOrigin(origins = "http:localhost:8080")
@RestController
public class BooksController {
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooksList() {
		List<Book> books = bookService.fetchBooks().getBody();
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	
	@GetMapping("/book")
	public Book getBookById(@RequestParam Long id) {
		return bookService.fetchBookById(id);
	}
	
	@PostMapping("/book/new")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	@PutMapping("/book")
	public ResponseEntity<String> upateBook(@RequestBody Book book, @RequestParam long id) {
		if(bookService.updateBook(book, id).hasBody()) {
			return new ResponseEntity<>("Book Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Update Failed", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/book")
	public ResponseEntity<String> deleteBook(@RequestParam long id) {
		return bookService.deleteBook(id);
	}
	
	
}
