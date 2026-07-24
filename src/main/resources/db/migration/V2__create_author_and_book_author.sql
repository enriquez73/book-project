CREATE TABLE author
(
    id         UUID         NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE book_author
(
    book_id   UUID NOT NULL,
    author_id UUID NOT NULL,

    CONSTRAINT pk_book_author
        PRIMARY KEY (book_id, author_id),

    CONSTRAINT fk_book_author_book
        FOREIGN KEY (book_id)
            REFERENCES book(id),

    CONSTRAINT fk_book_author_author
        FOREIGN KEY (author_id)
            REFERENCES author(id)
);