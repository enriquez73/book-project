package it.enricopea.bookstore.author.dto.response;

import java.util.UUID;

public record AuthorResponse(
        UUID id,
        String firstName,
        String lastName
) {
}
