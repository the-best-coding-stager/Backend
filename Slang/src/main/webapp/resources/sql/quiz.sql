charset utf8;
USE springmvcDB;

CREATE TABLE IF NOT EXISTS quiz(
    id INTEGER NOT NULL,
    quiz_question VARCHAR(255),
    quiz_answer VARCHAR(255)
)DEFAULT CHARSET=utf8;

DELETE FROM quiz;