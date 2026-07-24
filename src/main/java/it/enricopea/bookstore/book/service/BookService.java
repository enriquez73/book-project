package it.enricopea.bookstore.book.service;

import it.enricopea.bookstore.author.entity.Author;
import it.enricopea.bookstore.author.exception.AuthorNotFoundException;
import it.enricopea.bookstore.author.repository.AuthorRepository;
import it.enricopea.bookstore.book.dto.request.CreateBookRequest;
import it.enricopea.bookstore.book.dto.request.UpdateBookRequest;
import it.enricopea.bookstore.book.dto.response.BookResponse;
import it.enricopea.bookstore.book.entity.Book;
import it.enricopea.bookstore.book.exception.BookNotFoundException;
import it.enricopea.bookstore.book.exception.DuplicateIsbnException;
import it.enricopea.bookstore.book.repository.BookRepository;
import it.enricopea.bookstore.book.mapper.BookMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
    }

    @Transactional(readOnly = true)
    public List<BookResponse> findAll() {
        return bookMapper.toResponseList(bookRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<BookResponse> search(String title) {
        return bookMapper.toResponseList(bookRepository.findByTitleContainingIgnoreCase(title));
    }

    @Transactional
    public BookResponse update(UUID id, UpdateBookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        if (request.title() != null) {
            book.changeTitle(request.title());
        }

        return bookMapper.toResponse(book);
//        return new BookResponse(
//                book.getId(),
//                book.getTitle(),
//                book.getIsbn(),
//                book.getPrice(),
//                book.getPublicationDate() != null ? book.getPublicationDate().toString() : null
//        );
    }

    @Transactional
    public BookResponse create(CreateBookRequest request) {
        if (bookRepository.existsByIsbn(request.isbn())) {
            throw new DuplicateIsbnException(request.isbn());
        }
        var authors = authorRepository.findAllById(request.authorIds());

        var foundAuthorIds = authors.stream()
                .map(Author::getId)
                .collect(Collectors.toSet());

        var missingAuthorIds = request.authorIds().stream()
                .filter(id -> !foundAuthorIds.contains(id))
                .toList();

        if (!missingAuthorIds.isEmpty()) {
            throw new AuthorNotFoundException(missingAuthorIds);
        }

        var book = new Book(
                request.title(),
                request.isbn(),
                request.price(),
                request.publicationDate()
        );
        authors.forEach(book::addAuthor);

        var savedBook = bookRepository.save(book);
        return bookMapper.toResponse(savedBook);
    }

    @Transactional
    public void delete(UUID id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(book);
    }
}
