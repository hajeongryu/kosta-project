--���ƿ�/�˸������� ���
SELECT p.project_no "������Ʈ ��ȣ"
        ,p.project_image "������Ʈ �̹���"
        ,p.editor_pick "������ ��õ"
        ,p.long_title "������Ʈ ����"
        ,c.category_name "ī�װ�"
        ,u.user_name "������Ʈ �ۼ��� �̸�"
        ,p.project_brief "������Ʈ ���"
        ,p.target_price "��ǥ�ݾ�"
        ,pc.sum_price "���αݾ�"
        ,pc.support_cnt "�Ŀ��� ��"
        ,(sysdate-p.end_date) "������"
FROM project p
    JOIN project_change pc ON p.project_no=pc.project_no
    JOIN users u ON p.user_no = u.user_no
    JOIN category c ON p.category_no=c.category_no
WHERE p.user_no=1;

--���ƿ�/�˸� �߰��ϱ�
INSERT INTO interest VALUES(1,4,'I');

--���ƿ�/�˸� �����ϱ�
DELETE FROM interest WHERE project_no=1 and user_no=4;

--���ƿ� �������� Ȯ��
SELECT * FROM interest WHERE project_no=4 and user_no=1;