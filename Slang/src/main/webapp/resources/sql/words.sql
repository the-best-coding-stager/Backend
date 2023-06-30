charset utf8;
USE springmvcDB;

CREATE TABLE IF NOT EXISTS words(
    id INTEGER NOT NULL,
    name VARCHAR(255),
    title VARCHAR(255),
    description TEXT,
    writer_id VARCHAR(255)
)DEFAULT CHARSET=utf8;

DELETE FROM words;

INSERT INTO words VALUES('0', '중꺾마', '중요한 건 꺾이지 않는 마음', '리그 오브 레전드 2022 월드 챔피언십에 참가한 프로게임단 DRX 소속 프로게이머 김혁규(Deft) 선수의 인터뷰를 담은 영상의 제목에서 유래된 유행어로, 2022 카타르 월드컵 16강에 진출했던 대한민국 축구대표팀 선수들이 해당 문구가 새겨진 태극기를 들면서 더욱 화제가 되었다.', 'Admin');