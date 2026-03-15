package com.capg.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capg.book.model.Book;
import com.capg.book.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {

		Optional<Book> book = bookService.getBookById(id);

		if (book.isPresent()) {
			return ResponseEntity.ok(book.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id,
			@RequestBody Book book) {

		Book updatedBook = bookService.updateBook(id, book);

		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {

		bookService.deleteBook(id);

		return ResponseEntity.noContent().build();
	}
}