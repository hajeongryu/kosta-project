--�Ŀ��ϱ� ��ǰ
SELECT c.category_name ī�װ��̸�
    ,p.long_title ������Ʈ�̸�
    ,p.project_image ������Ʈ�̹���
    ,u.user_name â�����̸�
    ,pc.sum_price ���αݾ�
    ,(sysdate-p.end_date) �����ð�
    ,p.target_price ��ǥ�ݾ�
    ,(p.end_date+7) ������
FROM project p JOIN category c ON p.category_no=c.category_no
                JOIN users u ON p.user_no=u.user_no
                JOIN project_change pc ON p.project_no=pc.project_no;

--�Ŀ��ϱ� ��������
SELECT reward_price �����ݾ�
    ,reward_name �����̸�
    ,reward_num ������������
    ,reward_sales_cnt ��������
    ,item_name �������̸�
FROM reward;

--�Ŀ��� ����
SELECT user_phone ����ó, user_id �̸���
,(SELECT * FROM address WHERE user_no = ? AND default_address = '1')
,(SELECT * FROM CARD WHERE user_no = ? AND default_card = '1')
FROM users;

--�����Ŀ��ݾ�
SELECT (total_price + extra_price)
FROM order;

--UPDATE �Ŀ���,���αݾ� 
UPDATE project_change SET support_cnt='?';
UPDATE project_change SET sum_price='?';


--�Ŀ��ϱ�(����)
INSERT INTO orders 
VALUES (user_no,extra_price, total_price, address_no, card_no, reward_no, project_no);