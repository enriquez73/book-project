package it.enricopea.bookstore.book.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateBookRequest(
        @NotBlank
        String title,
        @NotBlank
        String isbn,
        @NotNull
        @Positive
        BigDecimal price,
        LocalDate publicationDate
) {
}
