<ȸ������>

���̵� �ߺ����� Ȯ��
SELECT * FROM users WHERE user_id = ?;

ȸ���߰�
INSERT INTO users VALUES (~~~); --������̸�URL �����̹���~�˸����� default ������ ������ ����
--����� user_no�� ������ �ڵ��߱�, �Է�x
------------------------------------------------------------------------------------
<������> - �α��� �� ���ǿ��� ȸ����ȣ ����

�����ʻ���
SELECT user_image FROM users WHERE user_no=?; --��ȸ
UPDATE users SET user_image=? WHERE user_no=?; --����

�̸�
SELECT user_name FROM users WHERE user_no=?; --��ȸ
UPDATE users SET user_name=? WHERE user_no=?; --����

������̸�URL
SELECT user_url FROM users WHERE user_no=?; --(��ȸ �� �ߺ�Ȯ��)
UPDATE users SET user_url=? WHERE user_no=?; --����

�Ұ�
SELECT user_introduction FROM users WHERE user_no=?; --��ȸ
UPDATE users SET user_introduction=? WHERE user_no=?; --����

������Ʈ(�ϳ��� �����ϵ��� - �Һ���� ������ ���)
SELECT user_website FROM users WHERE user_no=?; --��ȸ
UPDATE users SET user_website=? WHERE user_no=?; --����

�̸���
SELECT user_id FROM users WHERE user_no=?; --��ȸ
����Ұ�

��й�ȣ
SELECT user_pwd FROM users WHERE user_no=?; --��ȸ
UPDATE users SET user_pwd=? WHERE user_no=?; --����

����ó
SELECT user_phone FROM users WHERE user_no=?; --��ȸ
UPDATE users SET user_phone=? WHERE user_no=?; --����

ȸ��Ż��
UPDATE users SET user_status=? WHERE user_no=?; --����

��������
SELECT * FROM card WHERE user_no=?; --��ȸ
INSERT INTO card VALUES (~~~~~~~); --ī�� �߰� card_no�� ���� �������� �ڵ��߱�
����Ұ�
DELETE * FROM card WHERE card_no=?; --ī�����

�����
SELECT * FROM address WHERE user_no=? --��ȸ
INSERT INTO address VALUES (~~~); --������߰� address_no�� ���� �������� �ڵ��߱�
UPDATE address SET (~~~~) WHERE address_no=?; --����
DELETE * FROM address WHERE address_no=?; --����





