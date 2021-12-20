--data_users.xlsx 임포트
SELECT * FROM users;

--data_card.xlsx임포트
SELECT * FROM card;

--data_address.xlsx임포트
SELECT * FROM address;

--data_project.xlsx임포트, 트리거 있어서 change자동 생성, 삭제후 새로 임포트
SELECT * FROM project;
SELECT * FROM project_change;
delete from project_change;

--data_project_change.xlsx임포트
SELECT * FROM project_change;

--reject
INSERT INTO reject values(3, '설명부족');
SELECT * FROM reject;

--data_community.xlsx 임포트
SELECT * FROM community;

--data_comments.xlsx 임포트
SELECT * FROM comments;

--follow
INSERT INTO follow VALUES (1, 3);
INSERT INTO follow VALUES (2, 3);
INSERT INTO follow VALUES (4, 3);
SELECT * FROM follow;

--interest
INSERT INTO interest VALUES (4, 1, 'I');
INSERT INTO interest VALUES (4, 2, 'I');
INSERT INTO interest VALUES (5, 1, 'A');
SELECT * FROM interest;

--data_reward.xlsx 임포트
SELECT * FROM reward;

UPDATE project SET end_date='21/12/20' WHERE project_no='4';
--data_orders.xlsx 임포트
select * from orders;