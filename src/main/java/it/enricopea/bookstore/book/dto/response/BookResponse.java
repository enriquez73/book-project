package it.enricopea.bookstore.book.dto.response;

import it.enricopea.bookstore.author.dto.response.AuthorResponse;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public record BookResponse(
        UUID id,
        String title,
        String isbn,
        BigDecimal price,
        String publicationDate,
        Set<AuthorResponse> authors
) {
}
