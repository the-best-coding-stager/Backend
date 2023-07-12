charset utf8;
USE springmvcDB;

CREATE TABLE IF NOT EXISTS likes (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    word_id INTEGER,
    user_id varchar(255)
)DEFAULT CHARSET=utf8;

DELETE FROM likes;