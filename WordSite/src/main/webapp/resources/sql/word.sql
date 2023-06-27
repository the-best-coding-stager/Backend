charset utf8;
USE springmvcDB;

CREATE TABLE IF NOT EXISTS word(
    w_wordId VARCHAR(20) NOT NULL,
    w_name VARCHAR(50),
    w_title VARCHAR(255),
    w_description TEXT,
    w_writer VARCHAR(20),
    w_releaseDate VARCHAR(20),
    PRIMARY KEY (w_wordId)
)DEFAULT CHARSET=utf8;

DELETE FROM word;

INSERT INTO INTO word (w_wordId, w_name, w_title, w_description) VALUES('1', '킹받다', '킹받네 정말!', '화가 날 때 쓰는 표현.');