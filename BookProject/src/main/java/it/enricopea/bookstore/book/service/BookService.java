package it.enricopea.bookstore.book.service;

import it.enricopea.bookstore.book.dto.request.CreateBookRequest;
import it.enricopea.bookstore.book.dto.request.UpdateBookRequest;
import it.enricopea.bookstore.book.dto.response.BookResponse;
import it.enricopea.bookstore.book.entity.Book;
import it.enricopea.bookstore.book.exception.DuplicateIsbnException;
import it.enricopea.bookstore.book.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> findAll(){
        return bookRepository.findAll().stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getTitle(),
                        book.getIsbn(),
                        book.getPrice(),
                        book.getPublicationDate() != null ? book.getPublicationDate().toString() : null
                ))
                .toList();
    }

    public List<BookResponse> search(String title){
        return bookRepository.findByTitleContainingIgnoreCase(title).stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getTitle(),
                        book.getIsbn(),
                        book.getPrice(),
                        book.getPublicationDate() != null ? book.getPublicationDate().toString() : null
                ))
                .toList();
    }

    @Transactional
    public BookResponse updateBook(UUID id, UpdateBookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (request.title() != null) {
            book.changeTitle(request.title());
        }

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPrice(),
                book.getPublicationDate() != null ? book.getPublicationDate().toString() : null
        );
    }

    @Transactional
    public BookResponse create(CreateBookRequest request){
        if(bookRepository.existsByIsbn(request.isbn())){
            throw new DuplicateIsbnException(request.isbn());
        }

        var book = new Book(
                request.title(),
                request.isbn(),
                request.price(),
                request.publicationDate() != null ? request.publicationDate() : null
        );

        var savedBook = bookRepository.save(book);
        return new BookResponse(
                savedBook.getId(),
                savedBook.getTitle(),
                savedBook.getIsbn(),
                savedBook.getPrice(),
                savedBook.getPublicationDate() != null ? savedBook.getPublicationDate().toString() : null
        );
    }
}
