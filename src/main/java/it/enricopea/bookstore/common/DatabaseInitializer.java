package it.enricopea.bookstore.common;

import it.enricopea.bookstore.book.entity.Book;
import it.enricopea.bookstore.book.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DatabaseInitializer {

    @Bean
    CommandLineRunner init(BookRepository bookRepository) {
        List<Book> books = List.of(
            new Book( "Effective Java", "978-0134685991", new BigDecimal("39.99"), LocalDate.of(2017, Month.OCTOBER, 1)),
            new Book( "Spring in Action", "978-1617294945", new BigDecimal("49.99"), LocalDate.of(2018, Month.NOVEMBER, 1)),
            new Book( "Clean Code", "978-0132350884", new BigDecimal("34.99"), LocalDate.of(2008, Month.AUGUST, 1))
        );
        String[] results = new String[books.size()];
var i=0;
        for (Book book : books) {
            if(bookRepository.existsByIsbn(book.getIsbn())) {
                continue;
            }
           results[i]=bookRepository.save(book).toString();
           i++;
        }
        return args -> {
            System.out.println("Database initialized with the following books:");
            for (String result : results) {
                if(result!=null)
                System.out.println(result);
            }
        };
    }
}
