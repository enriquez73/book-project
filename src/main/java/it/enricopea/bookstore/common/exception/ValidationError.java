package it.enricopea.bookstore.common.exception;

public record ValidationError(
        String field,
        String message
) {
}
