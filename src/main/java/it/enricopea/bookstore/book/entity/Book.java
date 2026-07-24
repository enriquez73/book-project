package it.enricopea.bookstore.book.entity;

import it.enricopea.bookstore.author.entity.Author;
import it.enricopea.bookstore.category.entity.Category;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

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

    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

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

    public Set<Author> getAuthors() {
        return authors;
    }

    public Category getCategory() {
        return category;
    }

    public void changeCategory(Category category) {
        this.category = category;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        // author.getBooks().add(this); // Ensure bidirectional relationship is maintained

    }

    public void deleteAuthor(Author author) {
        authors.remove(author);
        // author.getBooks().remove(this); // Ensure bidirectional relationship is maintained

    }
}
