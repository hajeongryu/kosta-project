--������Ʈ ī�װ� �̸�,������Ʈ ����,â�����̸�,���αݾ�
SELECT c.category_name ī�װ��̸�
    ,p.long_title ������Ʈ�̸�
    ,p.project_image ������Ʈ�̹���
    ,u.user_name â�����̸�
    ,pc.get_price ���αݾ�
    ,(sysdate-p.end_date) �����ð�
    ,p.target_price ��ǥ�ݾ�
    ,(p.end_date+7) ������
    ,p.project_content ������Ʈ����
FROM project p JOIN category c ON p.category_no=c.category_no
                JOIN users u ON p.user_no=u.user_no
                JOIN project_change pc ON p.project_no=pc.project_no;
/*WHERE project_no = ?;*/


--����
SELECT reward_price �����ݾ�
    ,reward_name �����̸�
    ,reward_num ������������
    ,reward_sales_cnt ��������
    ,item_name �������̸�
FROM reward;

--Ŀ�´�Ƽ
SELECT user_name �ۼ����̸�
    , post_content �Խñ۳���
    , post_date �ۼ�����
FROM community c JOIN users u ON c.user_no=u.user_no;

INSERT INTO community(post_no, project_no, post_content, post_date, user_no)
VALUES(post_seq.NEXTVAL,'?','?',SYSDATE,'?');

--���
SELECT user_name �ۼ����̸�
    , comments_content ��۳���
    , comments_date �ۼ�����
FROM comments c JOIN users u ON c.user_no=u.user_no;

INSERT INTO comments(comment_no, post_no, comment_content, comment_date, user_no)
VALUES(comment_seq.NEXTVAL,'?','?',SYSDATE,'?');