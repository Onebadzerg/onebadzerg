package com.example.lms_backend.repository;

import com.example.lms_backend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    // The findById method is already provided by JpaRepository,
    // but if you want a custom version, it must return Optional<Book>
    Optional<Book> findById(String bookIsbn);
}
