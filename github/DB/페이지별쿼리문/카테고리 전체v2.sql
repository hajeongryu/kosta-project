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
<<<<<<< HEAD
    JOIN category cate
        ON p.category_no = cate.category_no

    --JOIN orders  --�������� �ʴ� ��쵵 �ִµ� �ڵ� ��Ȱ�뼺�� ���� �׳� �־��
      --  ON p.project_no = orders.project_no;
=======
    JOIN orders  --�������� �ʴ� ��쵵 �ִµ� �ڵ� ��Ȱ�뼺�� ���� �׳� �־��
        ON p.project_no = orders.project_no;
>>>>>>> d7f1066ab4a0a1db6cdabd0e93c2c385ad22331a
        
        
        
--START

--<1.ī�װ�>================================--
--@������Ʈ �� "categoty" = "all" / "board-games-and-trpg (1)" ���..    / null

    -- all �̳� null �Ͻ�
--WHERE p.category_no >=0

        --ī�װ� �ѹ� ������
--WHERE p.category_no = '1' --�ش� ī�װ� ��ȣ





--<2.������Ʈ �����Ȳ>=======================--
--@������Ʈ��  "ongoing" = onGoing(������ ������Ʈ) /confirm(����� ������Ʈ) /prelaunching(�������� ������Ʈ) / null


    -- 2-1.onGoing(������ ������Ʈ)--
--AND c.project_status = '����' 

    --���� �Ȱ�/    ����(1/6) > ������(1/5)  ||   ����(1/1)  < ������(1/6) (x)
--AND sysdate > P.start_date 
    --������ �� ������/    0 > -1 = ����(1/1)- ������(1/2) <����>   || (x) 0 > 19  = ����(1/20)  -  ������(1/1) 
--AND 0>= (sysdate -p.end_date ) 
    


    -- 2-2.confirm(����� ������Ʈ) (������ + ��ݾ� �ʰ�)-- 
    --������ ������   (o) 0< 9 =����(1/10)- ������(1/1)      || (x)  0 < -5 =����(1/5) - ������(1/10)  
--AND 0< (sysdate - p.end_date)
--AND c.sum_price > p.target_price;


    -- 2-3.prelaunching(�������� ������Ʈ)---
--AND c.project_status = '����' 
--AND sysdate  < p.start_date;  -- ����(1/5) < ������(1/20)  






--3.<������ ��õ>==========================--
--@������Ʈ�� editorpick = '1' / null


    --3-1.������ ��õ ������Ʈ(1)--
--AND p.editor_pick = '1';





--4.<�޼���>==============================--
--@������Ʈ�� achieveRate=    (1) 75%����   (2)75~100%    (3)100% �̻�  / null

    --4-1.  75% ���� �޼���
--AND (c.sum_price / p.target_price) <0.75

    --4-2.  75~100% �޼���
--AND (c.sum_price / p.target_price) BETWEEN 0.75 AND 1.00


    --4-3.  100%�̻� �޼���
--AND (c.sum_price / p.target_price) >1.00







--5.<����>================================--
--@������Ʈ�� sort = popular(�α��)	publishedAt(�ֽż�)	pledges(�Ŀ���)	amount(�ݾ׼�) ended(���� �ӹڼ�)


   --1.popular(�α��) ���ƿ��
--ORDER BY c.project_like_cnt DESC

    --2.pledges(�Ŀ���)
--ORDER BY c.support_cnt DESC

    --3.amount(�ݾ׼�)
--ORDER BY c.sum_price DESC

    --4.publishedAt(�ֽż�)
--AND c.project_status = '����' 
--ORDER BY p.start_date DESC --��������(�ֽ����� ����)

    --5.ended(���� �ӹڼ�)
--AND p.end_date<sysdate  --1��2��   < 1��3��
--ORDER BY p.end_date ASC

;
--END

SELECT p.project_no , start_date, end_date,project_status ,user_name, sum_price
FROM project p
JOIN project_change c
    ON  p.project_no = c.project_no
JOIN users u
    ON  u.user_no = p.user_no;
