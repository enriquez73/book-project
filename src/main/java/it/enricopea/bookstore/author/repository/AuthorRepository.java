package it.enricopea.bookstore.author.repository;

import it.enricopea.bookstore.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID>
{
}
