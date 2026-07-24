package it.enricopea.bookstore.book.exception;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException
{
    public BookNotFoundException(UUID id) {
        super("Book with ID " + id.toString() + " not found");
    }
}
