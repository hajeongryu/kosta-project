SELECT project_image "������Ʈ �̹���"
        , long_title "������Ʈ ����"
        ,category_no "ī�װ� ��ȣ"
        , user_name "������Ʈ �ۼ��� �̸�"
        , project_brief "������Ʈ ���"
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
        
        
        
--START

--<1.ī�װ�>================================--
--@������Ʈ �� "categoty" = "all" / "board-games-and-trpg (1)" ���..    / null

    -- all �̳� null �Ͻ�
--WHERE p.category_no >=0

        --ī�װ� �ѹ� ������
--WHERE p.category_no = '1' --�ش� ī�װ� ��ȣ





--<2.������Ʈ �����Ȳ>=======================--
--@������Ʈ��  "ongoing" = onGoing(������ ������Ʈ) /confirm(����� ������Ʈ) /prelaunching(�������� ������Ʈ) / null


    --1.onGoing(������ ������Ʈ)--
--AND c.project_status = '����' and 0>(p.end_date- sysdate);

    --2.confirm(����� ������Ʈ)--
--AND  orders.payment_result = 1; 

    --3.prelaunching(�������� ������Ʈ)---
--AND c.project_status = '����' AND p.end_date > sysdate;






--3.<������ ��õ>==========================--
--@������Ʈ�� editorpick = '1' / null


    --1.������ ��õ ������Ʈ(1)--
--AND p.editor_pick = '1';





--4.<�޼���>==============================--
--@������Ʈ�� achieveRate=    (1) 75%����   (2)75~100%    (3)100% �̻�  / null

    --1.  75% ���� �޼���
--AND (c.get_price / p.target_price) <0.75

    --2.  75~100% �޼���
--AND (c.get_price / p.target_price) BETWEEN 0.75 AND 1.00


    --3.  100%�̻� �޼���
--AND (c.get_price / p.target_price) >1.00







--5.<����>================================--
--@������Ʈ�� editorpick = '1'  /null


   --1.�α��
--ORDER BY c.project_like_cnt DESC
    --2.�Ŀ���
--ORDER BY c.support_cnt DESC
    --3.�ݾ׼�
--ORDER BY c.get_price DESC

    --4.�ֽż�
--  AND c.project_status = '���ε�' --�ϴ��� �������� ������Ʈ���� ������ ����
--ORDER BY p.start_date DESC --��������(�ֽ����� ����)

    --5.�����ӹڼ�
--AND p.end_date<sysdate  --1��2��   < 1��3��
--ORDER BY p.end_date ASC


;
--END
