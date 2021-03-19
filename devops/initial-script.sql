CREATE TABLE IF NOT EXISTS users
(
    user_id  BIGINT      NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) not null,
    PRIMARY KEY (user_id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 0;

CREATE TABLE IF NOT EXISTS books
(
    book_id     BIGINT      NOT NULL AUTO_INCREMENT,
    user_id     BIGINT      NOT NULL,
    book_name   VARCHAR(20) NOT NULL,
    book_author VARCHAR(20) NOT NULL,
    book_genre  VARCHAR(20) NOT NULL,
    created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (book_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 0;