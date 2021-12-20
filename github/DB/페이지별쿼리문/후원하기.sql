--후원하기 상품
SELECT c.category_name 카테고리이름
    ,p.long_title 프로젝트이름
    ,p.project_image 프로젝트이미지
    ,u.user_name 창작자이름
    ,pc.get_price 모인금액
    ,(sysdate-p.end_date) 남은시간
    ,p.target_price 목표금액
    ,(p.end_date+7) 결제일
FROM project p JOIN category c ON p.category_no=c.category_no
                JOIN users u ON p.user_no=u.user_no
                JOIN project_change pc ON p.project_no=pc.project_no;

--후원하기 선물정보
SELECT reward_price 선물금액
    ,reward_name 선물이름
    ,reward_num 선물한정수량
    ,reward_sales_cnt 결제수량
    ,item_name 아이템이름
FROM reward;

--후원자 정보
SELECT user_phone 연락처, user_id 이메일
,(SELECT * FROM address WHERE user_no = ? AND default_address = '1')
,(SELECT * FROM CARD WHERE user_no = ? AND default_card = '1')
FROM users;

--최종후원금액

--UPDATE 후원자,모인금액
UPDATE 