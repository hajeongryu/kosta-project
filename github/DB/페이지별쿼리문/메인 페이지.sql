--1. �ָ��Ҹ��� ������Ʈ(8��)
SELECT project_image "������Ʈ �̹���"
        ,category_no "ī�װ� ��ȣ"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , get_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --�������� �ʴ� ��쵵 �ִµ� �ڵ� ��Ȱ�뼺�� ���� �׳� �־��
        ON p.project_no = orders.project_no

-- �޼��� 100% �̻� + �����ӹ� �ΰ͵�
WHERE (c.get_price / p.target_price) >1.00
    AND p.end_date<sysdate  --1��2��   < 1��3��
    AND ROWNUM <=8
ORDER BY p.end_date ASC;




--2.�α�������Ʈ(12��) 
SELECT project_image "������Ʈ �̹���"
        ,category_no "ī�װ� ��ȣ"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , get_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --�������� �ʴ� ��쵵 �ִµ� �ڵ� ��Ȱ�뼺�� ���� �׳� �־��
        ON p.project_no = orders.project_no
        
    --�������̸鼭 �α������
WHERE c.project_status = '����' and 0>(p.end_date- sysdate)
    AND ROWNUM <=12

ORDER BY c.project_like_cnt DESC;




--3.�ֱ� �� ������Ʈ (�̱���)


--4.�����ӹ�! ������Ʈ(16��)
SELECT project_image "������Ʈ �̹���"
        ,category_no "ī�װ� ��ȣ"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , get_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --�������� �ʴ� ��쵵 �ִµ� �ڵ� ��Ȱ�뼺�� ���� �׳� �־��
        ON p.project_no = orders.project_no
        
    --�������̸鼭, �����ӹ�
WHERE c.project_status = '����' and 0>(p.end_date- sysdate)
    AND ROWNUM <=16
    AND p.end_date<sysdate  --1��2��   < 1��3��
ORDER BY p.end_date ASC;



--5.�������� ������Ʈ(16��)
SELECT project_image "������Ʈ �̹���"
        ,category_no "ī�װ� ��ȣ"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , get_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --�������� �ʴ� ��쵵 �ִµ� �ڵ� ��Ȱ�뼺�� ���� �׳� �־��
        ON p.project_no = orders.project_no
        
    --���� ����
WHERE c.project_status = '����' AND p.end_date > sysdate
    AND ROWNUM <=16
    
ORDER BY p.start_date DESC;



--6.�ű�������Ʈ

SELECT project_image "������Ʈ �̹���"
        ,category_no "ī�װ� ��ȣ"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , get_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --�������� �ʴ� ��쵵 �ִµ� �ڵ� ��Ȱ�뼺�� ���� �׳� �־��
        ON p.project_no = orders.project_no

WHERE c.project_status = '���ε�' --�ϴ��� �������� ������Ʈ���� ������ ����
ORDER BY p.start_date DESC; --��������(�ֽ����� ����)      
