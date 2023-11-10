package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Book;
//import entity.Book.BookBuilder;
import lombok.NonNull;
import repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public ResponseEntity<List<Book>> fetchBooks() {
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(books::add);
		return new ResponseEntity<>(books, HttpStatus.OK);
		
	}
	
	@Override
	public Book fetchBookById(Long id) {
		Book b = null;
		if(bookRepository.findById(id).isPresent()) {
			b = bookRepository.findById(id).get();
		} else {
			System.out.println("nopee");
		}
		return b;
	}

	@Override
	public ResponseEntity<String> saveBook(Book book) {
		if(bookRepository.save(book).equals(book)) {
			bookRepository.save(book);
			return new ResponseEntity<>("Book Added", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error while adding", HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public ResponseEntity<Book> updateBook(Book newBook, long id) {
		Book bookDb = null;
		if(bookRepository.findById(id) != null) {
			bookDb = bookRepository.findById(id).get();
			
			bookDb.setAuthor(newBook.getAuthor());
			bookDb.setCountry(newBook.getCountry());
			bookDb.setImageLink(newBook.getImageLink());
			bookDb.setLanguage(newBook.getLanguage());
			bookDb.setLink(newBook.getLink());
			bookDb.setPages(newBook.getPages());
			bookDb.setTitle(newBook.getTitle());
			bookDb.setYear(newBook.getYear());	
			bookDb.setPrice(newBook.getPrice());
		}
		return new ResponseEntity<>(bookRepository.save(bookDb), HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<String> deleteBook(long id) {
		try {
			bookRepository.deleteById(id);
			return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
		} catch(Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		
	}
	

}
