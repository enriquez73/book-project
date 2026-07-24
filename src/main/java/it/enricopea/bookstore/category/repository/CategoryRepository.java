package it.enricopea.bookstore.category.repository;

import it.enricopea.bookstore.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
