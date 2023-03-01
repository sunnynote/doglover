-- USER (password : 1234)
INSERT INTO user (email, password, nickname) VALUES
    ('test1@gmail.com', '{bcrypt}$2a$10$zgV0LjFjVYb3ew.l3pq6a.lXeAhq0CfDgciAgslJmshLlrRsuVaAS', 'test1'),
    ('test2@gmail.com', '{bcrypt}$2a$10$zgV0LjFjVYb3ew.l3pq6a.lXeAhq0CfDgciAgslJmshLlrRsuVaAS', 'test2'),
    ('test3@gmail.com', '{bcrypt}$2a$10$zgV0LjFjVYb3ew.l3pq6a.lXeAhq0CfDgciAgslJmshLlrRsuVaAS', 'test3'),
    ('test4@gmail.com', '{bcrypt}$2a$10$zgV0LjFjVYb3ew.l3pq6a.lXeAhq0CfDgciAgslJmshLlrRsuVaAS', 'test4'),
    ('test5@gmail.com', '{bcrypt}$2a$10$zgV0LjFjVYb3ew.l3pq6a.lXeAhq0CfDgciAgslJmshLlrRsuVaAS', 'test5');

-- BOARDMAP
INSERT INTO boardmap (title, user_no) VALUES
    ('참지않는 말티즈 게시판', 1),
    ('귀여운 푸들 게시판', 3),
    ('스트릿 출신 믹스 게시판', 3),
    ('푸른 고등어 게시판', 2),
    ('노랑 치즈 게시판', 2);

-- BOARD
INSERT INTO board (title, content, boardmap_no) VALUES
    ('말티즈는 긔엽긔', '말티즈는 참지않긔', 1),
    ('말티즈를 키우고 싶어요', '언젠가는..', 1),
    ('함께 사는 치즈입니다', '치즈 고양이는 귀여워', 5),
    ('믹스를 키워본 적이 있습니다', '보고싶은 믹스', 3),
    ('푸들도 참지 않아요', '푸들푸들해', 2),
    ('반려 고등어를 보세요!', '사진입니다.', 4),
    ('오늘 푸들 사진 입니다', '사진!', 2);

-- REPLY
INSERT INTO reply (content, board_no, user_no) VALUES
    ('동의합니다', 1, 2),
    ('동의합니다2', 1, 3),
    ('동의합니다3', 1, 4),
    ('동의합니다4', 1, 2),
    ('동의합니다5', 1, 3),
    ('저도 치즈를 좋아합니다', 3, 5),
    ('아주 귀여운 믹스', 3, 1),
    ('행복한 말티즈입니다', 1, 4),
    ('치즈처럼 노랑색이네요', 3, 1),
    ('저도 푸들을 좋아해요', 7, 2),
    ('귀여운 믹스네요', 4, 5);