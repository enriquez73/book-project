package it.enricopea.bookstore.book.repository;

import it.enricopea.bookstore.book.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);

    @EntityGraph(attributePaths = "authors")
    @Override
    List<Book> findAll();
}
