--���ƿ�/�˸������� ���
SELECT i.project_no "������Ʈ ��ȣ"
        ,i.interest_alarm "���ƿ�/�˸�"
        ,p.project_image "������Ʈ �̹���"
        ,p.editor_pick "������ ��õ"
        ,p.long_title "������Ʈ ����"
        ,c.category_name "ī�װ�"
        ,u.user_name "������Ʈ �ۼ��� �̸�"
        ,p.project_brief "������Ʈ ���"
        ,p.target_price "��ǥ�ݾ�"
        ,pc.sum_price "���αݾ�"
        ,pc.support_cnt "�Ŀ��� ��"
        ,p.end_date "������"
FROM interest i
    JOIN project p ON i.project_no = p.project_no
    JOIN project_change pc ON i.project_no=pc.project_no
    JOIN users u ON p.user_no = u.user_no
    JOIN category c ON p.category_no=c.category_no
WHERE i.user_no=1;

--���ƿ�/�˸� �߰��ϱ�
INSERT INTO interest(project_no, user_no, interest_alarm) VALUES(1,4,'I');

--���ƿ�/�˸� �����ϱ�
DELETE FROM interest WHERE project_no=1 and user_no=4;

--���ƿ� �������� Ȯ��
SELECT * FROM interest WHERE project_no=4 and user_no=1;