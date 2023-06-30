charset utf8;
USE springmvcDB;

CREATE TABLE IF NOT EXISTS users(
    id VARCHAR(255) NOT NULL,
    nickname VARCHAR(255),
    password VARCHAR(255)
)DEFAULT CHARSET=utf8;

DELETE FROM users;

INSERT INTO users VALUES('Admin', '운영자', 'Admin1234');