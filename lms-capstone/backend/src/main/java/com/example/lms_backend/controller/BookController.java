package com.example.lms_backend.controller;

import com.example.lms_backend.model.Book;
import com.example.lms_backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books") // Base URL for Book API
public class BookController {

    @Autowired
    private BookService bookService;

    // GET /api/books - Retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET /api/books/{book_isbn} - Retrieve a book by its ISBN
    @GetMapping("/{book_isbn}")
    public Book getBookByIsbn(@PathVariable("book_isbn") String bookIsbn) {
        return bookService.getBookByIsbn(bookIsbn);
    }

    // POST /api/books - Add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // PUT /api/books/{book_isbn} - Update an existing book
    @PutMapping("/{book_isbn}")
    public Book updateBook(@PathVariable("book_isbn") String bookIsbn, @RequestBody Book bookDetails) {
        return bookService.updateBook(bookIsbn, bookDetails);
    }

    // DELETE /api/books/{book_isbn} - Delete a book by its ISBN
    @DeleteMapping("/{book_isbn}")
    public String deleteBook(@PathVariable("book_isbn") String bookIsbn) {
        bookService.deleteBook(bookIsbn);
        return "Book with ISBN " + bookIsbn + " has been deleted!";
    }
}
