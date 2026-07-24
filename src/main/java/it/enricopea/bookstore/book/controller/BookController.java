package it.enricopea.bookstore.book.controller;

import it.enricopea.bookstore.book.dto.request.CreateBookRequest;
import it.enricopea.bookstore.book.dto.request.UpdateBookRequest;
import it.enricopea.bookstore.book.dto.response.BookResponse;
import it.enricopea.bookstore.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> findAll() {

        return bookService.findAll();

    }

    @GetMapping("/search")
    public List<BookResponse> search(@RequestParam String title){
        return bookService.search(title);
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateBookRequest request){
        return bookService.update(id, request);
    }

    @PostMapping
    public BookResponse create(@Valid @RequestBody CreateBookRequest request){
        return bookService.create(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
