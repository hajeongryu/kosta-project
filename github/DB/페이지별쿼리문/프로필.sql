--프로필
SELECT user_image "유저 이미지"
FROM users; --유저이미지

SELECT * FROM orders o
JOIN users u ON u.user_no=o.user_no 
WHERE u.user_no=1; --후원현황 수 세기

SELECT * FROM interest i
JOIN users u ON u.user_no=i.user_no 
WHERE u.user_no=1; --관심 프로젝트 수 세기

SELECT * FROM orders o
JOIN users u ON u.user_no=o.user_no 
WHERE u.user_no=1; --만든 프로젝트 수 세기 

--후원내역
SELECT COUNT (payment_no) FROM orders o
JOIN users u ON u.user_no=o.user_no; --후원현황 수 세기 'N건의 후원 내역이 있습니다.'

--후원현황(진행중,펀딩성공,결제완료,펀딩실패)
--무료배송 표시해줘야 함(프론트)
SELECT o.payment_no "결제번호"
    ,o.project_no "프로젝트 번호"
    ,p.project_image "프로젝트 이미지"
    ,p.long_title "프로젝트 제목"
    ,p.project_url "프로젝트 페이지 주소"
    ,p.end_date "종료일"
    ,r.reward_name "선물이름"
    ,o.payment_result "결제상태"
    ,r.deliver_date "예상전달일"
    ,o.total_price "총 결제금액"
    ,o.user_no "결제자"
FROM orders o
JOIN project p ON o.project_no=p.project_no
JOIN reward r ON r.reward_no=o.reward_no
WHERE o.user_no=1;

--관심 프로젝트(좋아한) CASE1. 펀딩성공
SELECT p.project_image "프로젝트 이미지"
        ,p.editor_pick "에디터 추천"
        ,p.long_title "프로젝트 제목"
        ,p.category_no "카테고리 번호"
        ,u.user_name "프로젝트 작성자 이름"
        ,p.project_brief "프로젝트 요약"
        ,p.target_price "목표금액"
        ,c.sum_price "모인금액"
        ,c.support_cnt "후원자 수"
        ,p.end_date "종료일"--sysdate에서 enddate빼기
FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no
    JOIN users u
    ON p.user_no = u.user_no
WHERE c.sum_price>=p.target_price and p.end_date>sysdate
AND p.user_no=1;

--관심 프로젝트(좋아한) CASE2. 펀딩중
SELECT p.project_image "프로젝트 이미지"
        ,p.editor_pick "에디터 추천"
        ,p.long_title "프로젝트 제목"
        ,p.category_no "카테고리 번호"
        ,u.user_name "프로젝트 작성자 이름"
        ,p.project_brief "프로젝트 요약"
        ,p.target_price "목표금액"
        ,c.sum_price "모인금액"
        ,c.support_cnt "후원자 수"
        ,p.end_date "종료일"--sysdate에서 enddate빼기
FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no
    JOIN users u
    ON p.user_no = u.user_no
WHERE c.sum_price<p.target_price and p.end_date<sysdate
AND p.user_no=1;

--관심 프로젝트(알림신청)
SELECT project_image "프로젝트 이미지"
        ,category_no "카테고리 번호"
        ,user_name "프로젝트 작성자 이름"
        ,long_title "프로젝트 제목"
        ,project_brief "프로젝트 요약"
FROM project p
    JOIN interest i
    ON p.project_no=i.project_no
    JOIN users u
    ON p.user_no = u.user_no
WHERE i.interest_alarm='A';

--내가 만든 프로젝트
SELECT COUNT (p.project_no)
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='심사중'; --'심사중' 프로젝트 수 세기
    
SELECT project_image "프로젝트 이미지"
    ,long_title "프로젝트 제목"
    ,project_brief "프로젝트 요약"
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='심사중';

SELECT COUNT (p.project_no)
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='승인'; --'승인' 프로젝트 수 세기
    
SELECT project_image "프로젝트 이미지"
    ,long_title "프로젝트 제목"
    ,project_brief "프로젝트 요약"
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='승인';
    
    SELECT COUNT (p.project_no)
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='반려'; --'반려' 프로젝트 수 세기
    
SELECT project_image "프로젝트 이미지"
    ,long_title "프로젝트 제목"
    ,project_brief "프로젝트 요약"
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='반려';
    
    SELECT COUNT (p.project_no)
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='중지'; --'중지' 프로젝트 수 세기
    
SELECT project_image "프로젝트 이미지"
    ,long_title "프로젝트 제목"
    ,project_brief "프로젝트 요약"
    FROM project p
    JOIN project_change c
    ON p.project_no=c.project_no 
    WHERE c.project_status='중지';

--팔로잉/팔로우(후원한 창작자 삭제)
--1. 팔로잉 = 내가 팔로우한 사람들
SELECT u.user_name "내 이름"
    ,fu.user_image "팔로잉 이미지"
    ,fu.user_url "팔로잉 URL"
    ,f.follow "팔로잉"
    ,fu.user_name "팔로잉 이름"
    ,fu.user_introduction "소개"
FROM follow f
JOIN users u
    ON u.user_no=f.user_no
JOIN users fu
    ON fu.user_no=f.follow
WHERE u.user_no=3;

--2. 팔로워 = 나를 팔로우한 사람들
SELECT u.user_name "내 이름"
    ,fu.user_image "팔로워 이미지"
    ,fu.user_url "팔로워 이름 URL"
    ,f.user_no "팔로워"
    ,fu.user_name "팔로워 이름"
    ,fu.user_introduction "소개"
FROM follow f
JOIN users u
    ON u.user_no=f.follow
JOIN users fu
    ON fu.user_no=f.user_no
WHERE u.user_no=3;

--메시지,알림 쿼리(2차에서 구문 작성 및 구현 필요)
