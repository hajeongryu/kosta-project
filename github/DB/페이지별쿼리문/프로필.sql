--������
SELECT user_image "���� �̹���"
FROM users; --�����̹���

SELECT * FROM orders o
JOIN users u ON u.user_no=o.user_no 
WHERE u.user_no=1; --�Ŀ���Ȳ �� ����

SELECT * FROM interest i
JOIN users u ON u.user_no=i.user_no 
WHERE u.user_no=1; --���� ������Ʈ �� ����

SELECT * FROM orders o
JOIN users u ON u.user_no=o.user_no 
WHERE u.user_no=1; --���� ������Ʈ �� ���� 

--�Ŀ�����
SELECT COUNT (payment_no) FROM orders o
JOIN users u ON u.user_no=o.user_no; --�Ŀ���Ȳ �� ���� 'N���� �Ŀ� ������ �ֽ��ϴ�.'

--�Ŀ���Ȳ(������,�ݵ�����,�����Ϸ�,�ݵ�����)
--������ ǥ������� ��(����Ʈ)
SELECT o.payment_no "������ȣ"
    ,o.project_no "������Ʈ ��ȣ"
    ,p.project_image "������Ʈ �̹���"
    ,p.long_title "������Ʈ ����"
    ,p.project_url "������Ʈ ������ �ּ�"
    ,p.end_date "������"
    ,r.reward_name "�����̸�"
    ,o.payment_result "��������"
    ,r.deliver_date "����������"
    ,o.total_price "�� �����ݾ�"
    ,o.user_no "������"
FROM orders o
JOIN project p ON o.project_no=p.project_no
JOIN reward r ON r.reward_no=o.reward_no
WHERE o.user_no=1;

--���� ������Ʈ(������) CASE1. �ݵ�����
SELECT p.project_image "������Ʈ �̹���"
        ,p.editor_pick "������ ��õ"
        ,p.long_title "������Ʈ ����"
        ,p.category_no "ī�װ� ��ȣ"
        ,u.user_name "������Ʈ �ۼ��� �̸�"
        ,p.project_brief "������Ʈ ���"
        ,p.target_price "��ǥ�ݾ�"
        ,c.sum_price "���αݾ�"
        ,c.support_cnt "�Ŀ��� ��"
        ,p.end_date "������"--sysdate���� enddate����
FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no
    JOIN users u
    ON p.user_no = u.user_no
WHERE c.sum_price>=p.target_price and p.end_date>sysdate
AND p.user_no=1;

--���� ������Ʈ(������) CASE2. �ݵ���
SELECT p.project_image "������Ʈ �̹���"
        ,p.editor_pick "������ ��õ"
        ,p.long_title "������Ʈ ����"
        ,p.category_no "ī�װ� ��ȣ"
        ,u.user_name "������Ʈ �ۼ��� �̸�"
        ,p.project_brief "������Ʈ ���"
        ,p.target_price "��ǥ�ݾ�"
        ,c.sum_price "���αݾ�"
        ,c.support_cnt "�Ŀ��� ��"
        ,p.end_date "������"--sysdate���� enddate����
FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no
    JOIN users u
    ON p.user_no = u.user_no
WHERE c.sum_price<p.target_price and p.end_date<sysdate
AND p.user_no=1;

--���� ������Ʈ(�˸���û)
SELECT project_image "������Ʈ �̹���"
        ,category_no "ī�װ� ��ȣ"
        ,user_name "������Ʈ �ۼ��� �̸�"
        ,long_title "������Ʈ ����"
        ,project_brief "������Ʈ ���"
FROM project p
    JOIN interest i
    ON p.project_no=i.project_no
    JOIN users u
    ON p.user_no = u.user_no
WHERE i.interest_alarm='A';

--���� ���� ������Ʈ
SELECT COUNT (p.project_no)
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='�ɻ���'; --'�ɻ���' ������Ʈ �� ����
    
SELECT project_image "������Ʈ �̹���"
    ,long_title "������Ʈ ����"
    ,project_brief "������Ʈ ���"
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='�ɻ���';

SELECT COUNT (p.project_no)
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='����'; --'����' ������Ʈ �� ����
    
SELECT project_image "������Ʈ �̹���"
    ,long_title "������Ʈ ����"
    ,project_brief "������Ʈ ���"
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='����';
    
    SELECT COUNT (p.project_no)
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='�ݷ�'; --'�ݷ�' ������Ʈ �� ����
    
SELECT project_image "������Ʈ �̹���"
    ,long_title "������Ʈ ����"
    ,project_brief "������Ʈ ���"
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='�ݷ�';
    
    SELECT COUNT (p.project_no)
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='����'; --'����' ������Ʈ �� ����
    
SELECT project_image "������Ʈ �̹���"
    ,long_title "������Ʈ ����"
    ,project_brief "������Ʈ ���"
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='����';

--�ȷ���/�ȷο�(�Ŀ��� â���� ����)
--1. �ȷ��� = ���� �ȷο��� �����
SELECT u.user_name "�� �̸�"
    ,fu.user_image "�ȷ��� �̹���"
    ,fu.user_url "�ȷ��� URL"
    ,f.follow "�ȷ���"
    ,fu.user_name "�ȷ��� �̸�"
    ,fu.user_introduction "�Ұ�"
FROM follow f
JOIN users u
    ON u.user_no=f.user_no
JOIN users fu
    ON fu.user_no=f.follow
WHERE u.user_no=3;

--2. �ȷο� = ���� �ȷο��� �����
SELECT u.user_name "�� �̸�"
    ,fu.user_image "�ȷο� �̹���"
    ,fu.user_url "�ȷο� �̸� URL"
    ,f.user_no "�ȷο�"
    ,fu.user_name "�ȷο� �̸�"
    ,fu.user_introduction "�Ұ�"
FROM follow f
JOIN users u
    ON u.user_no=f.follow
JOIN users fu
    ON fu.user_no=f.user_no
WHERE u.user_no=3;

--�޽���,�˸� ����(2������ ���� �ۼ� �� ���� �ʿ�)
