--�ƿ����������� ī�װ� �̸� �߰��ؾ���

--1. �ָ��Ҹ��� ������Ʈ(8��) = �޼��� 100%�̻� -----------------------------------------------------------------------
SELECT  p.project_no"������Ʈ ��ȣ"
        ,category_name "ī�װ� �̸�"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , sum_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        , support_cnt"�Ŀ��� ��"
        , project_image "������Ʈ �̹���"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no

-- �޼��� 100% �̻�
WHERE (c.sum_price / p.target_price) >1.00
    AND sysdate < p.end_date --������ '����' �ʿ���� �̹� ��݉�⋚����
    AND ROWNUM <=8
ORDER BY p.end_date ASC;




--2.�α�������Ʈ(12��) =���ƿ� ��-----------------------------------------------------------------------------------
SELECT  p.project_no"������Ʈ ��ȣ"
        ,category_name "ī�װ� �̸�"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , sum_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        , support_cnt"�Ŀ��� ��"
        , project_image "������Ʈ �̹���"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no

        
WHERE c.project_status IN ('����')
        --������+������ �������� = ������
    -- ���� �Ȱ� (������)1��5�� <(����)1��6��   ||         (1��6��) < ����(1��5��) (x)
    AND sysdate > P.start_date
    
     -- ������ �� ������ (o) 0 > -1(����) = ����(1/1)- ������(1/2)  || (x) 0 > 4(���) = ����(1/5) -������(1/1)  
    AND 0>= (sysdate -p.end_date ) --0�̸� ��¥����
    
    AND ROWNUM <=12

ORDER BY c.project_like_cnt DESC;





--4.�����ӹ�! ������Ʈ(16��) = ������ + �� ����------------------------------------------------------------------------------
SELECT  p.project_no"������Ʈ ��ȣ"
        ,category_name "ī�װ� �̸�"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , sum_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        , support_cnt"�Ŀ��� ��"
        , project_image "������Ʈ �̹���"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no
        
WHERE c.project_status IN ('����')
        -- ������ =���۵�+������ ��������
    -- ���� �Ȱ� (������)1��5�� <(����)1��6��   ||         (1��6��) < ����(1��5��) (x)
    AND sysdate > P.start_date
     -- ������ �� ������ (o) 0 > -1(����) = ����(1/1)- ������(1/2)  || (x) 0 > 4(���) = ����(1/5) -������(1/1)  
    AND -10 >= (sysdate -p.end_date ) --10����       -10=����(1/10) -������(1/20)(���� 10����) 
                                      --            -3 =����(1/17) - ������(1/20) (����3����)
    
    
ORDER BY p.end_date ASC;



--5.�������� ������Ʈ(16��)  0k--------------------------------------------------------------------------------------------
SELECT  p.project_no"������Ʈ ��ȣ"
        ,category_name "ī�װ� �̸�"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , sum_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        , support_cnt"�Ŀ��� ��"
        , project_image "������Ʈ �̹���"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no

        
    --���� ���� = ���۾ȵȰ� + ���εȰ�
WHERE c.project_status = '����' 
    --  ���۾ȵȰ�    ����(1/1) < ������(1/20)
    AND  sysdate  < p.start_date 
    AND ROWNUM <=16
    
ORDER BY p.start_date DESC;



--6.�ű�������Ʈ(ok)----------------------------------------------------------------------------------------------------

SELECT  p.project_no"������Ʈ ��ȣ"
        ,category_name "ī�װ� �̸�"
        , user_name "������Ʈ �ۼ��� �̸�"
        , long_title "������Ʈ ����"
        , target_price "��ǥ�ݾ�"
        , sum_price "���αݾ�" --��ǥ�ݾ�/���αݾ�
        , end_date "������" --sysdate���� enddate����
        , support_cnt"�Ŀ��� ��"
        , project_image "������Ʈ �̹���"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no

WHERE c.project_status IN ('����')
        --������+������ �������� = ������
    -- ���� �Ȱ� (������)1��5�� <(����)1��6��   ||         (1��6��) < ����(1��5��) (x)
    AND sysdate > P.start_date
    
     -- ������ �� ������ (o) 0 > -1(����) = ����(1/1)- ������(1/2)  || (x) 0 > 4(���) = ����(1/5) -������(1/1)  
    AND 0>= (sysdate -p.end_date ) --0�̸� ��¥����
    
    
    --������Ʈ �������� 2���̳�  5������ = ����(1/10) - ������(1/5) >    || 25������ = (1/30)���� - (1/5)������
    AND  14>= (sysdate - p.start_date) --14������
    
    
ORDER BY p.start_date DESC; --��������(�ֽ����� ����)  




