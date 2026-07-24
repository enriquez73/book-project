package it.enricopea.bookstore.book.mapper;

import it.enricopea.bookstore.author.mapper.AuthorMapper;
import it.enricopea.bookstore.book.dto.response.BookResponse;
import it.enricopea.bookstore.book.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = AuthorMapper.class
)
public interface BookMapper {
    BookResponse toResponse(Book book);
    List<BookResponse> toResponseList(List<Book> books);
}
