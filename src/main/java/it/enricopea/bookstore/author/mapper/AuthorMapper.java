package it.enricopea.bookstore.author.mapper;

import it.enricopea.bookstore.author.dto.response.AuthorResponse;
import it.enricopea.bookstore.author.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponse toResponse(Author author);
}
