package it.enricopea.bookstore.book.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UpdateBookRequest(

        @Size(min = 1, message = "Title cannot be empty")
        String title,

        @DecimalMin(
                value = "0.0",
                inclusive = true,
                message = "Price cannot be negative"
        )
        BigDecimal price

) {}
