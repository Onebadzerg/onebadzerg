package com.example.lms_backend.service;

import com.example.lms_backend.model.Book;
import com.example.lms_backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Retrieve all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Retrieve a book by its ISBN
    public Book getBookByIsbn(String bookIsbn) {
        Optional<Book> optionalBook = bookRepository.findById(bookIsbn);
        return optionalBook.orElse(null);
    }

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Update an existing book by its ISBN
    public Book updateBook(String bookIsbn, Book bookDetails) {
        return bookRepository.findById(bookIsbn).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            // If your entity has more fields, update them here
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with ISBN: " + bookIsbn));
    }

    // Delete a book by its ISBN
    public void deleteBook(String bookIsbn) {
        bookRepository.deleteById(bookIsbn);
    }
}
