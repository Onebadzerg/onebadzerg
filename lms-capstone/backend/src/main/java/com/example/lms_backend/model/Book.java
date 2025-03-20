package com.example.lms_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_isbn")
    private String bookIsbn; // Primary key in the database

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_author")
    private String author;

    // Constructors, getters, and setters

    public Book() {}

    public Book(String bookIsbn, String title, String author) {
        this.bookIsbn = bookIsbn;
        this.title = title;
        this.author = author;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
