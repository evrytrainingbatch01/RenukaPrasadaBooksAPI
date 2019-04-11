package com.evry.SpringBoot.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evry.SpringBoot.Service.BookService;
import com.evry.SpringBoot.entity.Book;



@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	
	
	// expose "/Books" and return list of books
	@GetMapping("/getBooks")
	public List<Book> findAll() {
		return bookService.findAll();
	}

	// add mapping for GET /books/{bookId}
	
	@GetMapping("/getBooks/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		
		Book theBook = bookService.findById(bookId);
		
		if (theBook == null) {
			throw new RuntimeException("Book id not found - " + bookId);
		}
		
		return theBook;
	}
	
	// add mapping for POST /books - add new books
	
	@PostMapping("/addBooks")
	public Book addBook(@RequestBody Book theBook) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theBook.setId(0);
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	// add mapping for PUT /books - update existing book
	
	@PutMapping("/updateBooks")
	public Book updateBook(@RequestBody Book theBook) {
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	// add mapping for DELETE /books/{BookId} - delete book
	
	@DeleteMapping("/deleteBooks/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		
		Book tempBook = bookService.findById(bookId);
		
		// throw exception if null
		
		if (tempBook == null) {
			throw new RuntimeException("Book id not found - " + bookId);
		}
		
		bookService.deleteById(bookId);
		
		return "Deleted book id - " + bookId;
	}
	
}










