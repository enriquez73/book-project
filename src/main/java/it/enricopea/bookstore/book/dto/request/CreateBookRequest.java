package it.enricopea.bookstore.book.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record CreateBookRequest(
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank(message = "ISBN is required")
        String isbn,
        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", inclusive = true,
                message = "Price cannot be negative")
        BigDecimal price,

        @PastOrPresent(message = "Publication date cannot be in the future")
        LocalDate publicationDate,
        @NotEmpty(message = "At least one author is required")
        Set<UUID> authorIds
) {
}
