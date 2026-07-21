CREATE TABLE book
(
    id               UUID           NOT NULL,
    title            VARCHAR(255)   NOT NULL,
    isbn             VARCHAR(255)   NOT NULL,
    price            NUMERIC(10, 2) NOT NULL,
    publication_date DATE,

    CONSTRAINT pk_book PRIMARY KEY (id),
    CONSTRAINT uk_book_isbn UNIQUE (isbn)
);