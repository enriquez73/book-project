CREATE TABLE category
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT pk_category PRIMARY KEY (id),
    CONSTRAINT uc_category_name UNIQUE (name)
);

ALTER TABLE book
    ADD COLUMN category_id UUID;

ALTER TABLE book
    ADD CONSTRAINT fk_book_on_category
        FOREIGN KEY (category_id)
            REFERENCES category(id);