package it.enricopea.bookstore.book.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    private LocalDate publicationDate;

    protected Book() {
        // Default constructor for JPA
    }

    public Book(String title, String isbn, BigDecimal price, LocalDate publicationDate) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.publicationDate = publicationDate;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void changeTitle(String title) {
        this.title = title;
    }
}
