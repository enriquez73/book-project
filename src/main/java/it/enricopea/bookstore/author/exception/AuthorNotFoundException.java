package it.enricopea.bookstore.author.exception;

import java.util.Collection;
import java.util.UUID;

public class AuthorNotFoundException extends RuntimeException
{
    public AuthorNotFoundException(Collection<UUID> ids) {
        super("Authors not found: " + ids);
    }
}
