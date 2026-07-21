package it.enricopea.bookstore.book.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record BookResponse(
    UUID id,
    String title,
    String isbn,
    BigDecimal price,
    String publicationDate

){
}
