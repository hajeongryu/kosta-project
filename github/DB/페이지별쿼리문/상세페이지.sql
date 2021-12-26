--프로젝트 카테고리 이름,프로젝트 제목,창작자이름,모인금액
SELECT c.category_name 카테고리이름
    ,p.long_title 프로젝트이름
    ,p.project_image 프로젝트이미지
    ,u.user_name 창작자이름
    ,pc.sum_price 모인금액
    ,(sysdate-p.end_date) 남은시간
    ,p.target_price 목표금액
    ,(p.end_date+7) 결제일
    ,p.project_content 프로젝트내용
FROM project p JOIN category c ON p.category_no=c.category_no
                JOIN users u ON p.user_no=u.user_no
                JOIN project_change pc ON p.project_no=pc.project_no;
/*WHERE project_no = ?;*/


--선물
SELECT reward_price 선물금액
    ,reward_name 선물이름
    ,reward_num 선물한정수량
    ,reward_sales_cnt 결제수량
    ,item_name 아이템이름
FROM reward;


--커뮤니티 전체
SELECT * FROM community WHERE project_no =1;

SELECT user_name 작성자이름
    , c.post_no 게시글번호
    , post_content 게시글내용
    , post_date 작성일자
FROM community c JOIN users u ON c.user_no=u.user_no
                 JOIN comments cm ON c.post_no=cm.post_no
WHERE project_no = 1;

--커뮤니티 작성
INSERT INTO community(post_no, project_no, post_content, post_date, user_no)
VALUES(post_seq.NEXTVAL,'?','?',SYSDATE,'?');


SELECT * FROM community;


--댓글
SELECT user_name 작성자이름
    , comment_no 댓글번호
    , comment_content 댓글내용
    , comment_date 작성일자
FROM comments c JOIN users u ON c.user_no=u.user_no;

INSERT INTO comments(comment_no, post_no, comment_content, comment_date, user_no)
VALUES(comment_seq.NEXTVAL,'?','?',SYSDATE,'?');