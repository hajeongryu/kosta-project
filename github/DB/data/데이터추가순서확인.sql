--data_users.xlsx ����Ʈ
SELECT * FROM users;

--data_card.xlsx����Ʈ
SELECT * FROM card;

--data_address.xlsx����Ʈ
SELECT * FROM address;

--data_project.xlsx����Ʈ, Ʈ���� �־ change�ڵ� ����, ������ ���� ����Ʈ
SELECT * FROM project;
SELECT * FROM project_change;
delete from project_change;

--data_project_change.xlsx����Ʈ
SELECT * FROM project_change;

--reject
INSERT INTO reject values(3, '�������');
SELECT * FROM reject;

--data_community.xlsx ����Ʈ
SELECT * FROM community;

--data_comments.xlsx ����Ʈ
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

--data_reward.xlsx ����Ʈ
SELECT * FROM reward;

UPDATE project SET end_date='21/12/20' WHERE project_no='4';
--data_orders.xlsx ����Ʈ
select * from orders;