--1. 주목할만한 프로젝트(8개)
SELECT project_image "프로젝트 이미지"
        ,category_no "카테고리 번호"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , get_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --쓰이지는 않는 경우도 있는데 코드 재활용성을 위해 그냥 넣어둠
        ON p.project_no = orders.project_no

-- 달성률 100% 이상 + 마감임박 인것들
WHERE (c.get_price / p.target_price) >1.00
    AND p.end_date<sysdate  --1월2일   < 1월3일
    AND ROWNUM <=8
ORDER BY p.end_date ASC;




--2.인기프로젝트(12개) 
SELECT project_image "프로젝트 이미지"
        ,category_no "카테고리 번호"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , get_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --쓰이지는 않는 경우도 있는데 코드 재활용성을 위해 그냥 넣어둠
        ON p.project_no = orders.project_no
        
    --진행중이면서 인기순으로
WHERE c.project_status = '승인' and 0>(p.end_date- sysdate)
    AND ROWNUM <=12

ORDER BY c.project_like_cnt DESC;




--3.최근 본 프로젝트 (미구현)


--4.마감임박! 프로젝트(16개)
SELECT project_image "프로젝트 이미지"
        ,category_no "카테고리 번호"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , get_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --쓰이지는 않는 경우도 있는데 코드 재활용성을 위해 그냥 넣어둠
        ON p.project_no = orders.project_no
        
    --진행중이면서, 마감임박
WHERE c.project_status = '승인' and 0>(p.end_date- sysdate)
    AND ROWNUM <=16
    AND p.end_date<sysdate  --1월2일   < 1월3일
ORDER BY p.end_date ASC;



--5.공개예정 프로젝트(16개)
SELECT project_image "프로젝트 이미지"
        ,category_no "카테고리 번호"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , get_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --쓰이지는 않는 경우도 있는데 코드 재활용성을 위해 그냥 넣어둠
        ON p.project_no = orders.project_no
        
    --공개 예정
WHERE c.project_status = '승인' AND p.end_date > sysdate
    AND ROWNUM <=16
    
ORDER BY p.start_date DESC;



--6.신규프로젝트

SELECT project_image "프로젝트 이미지"
        ,category_no "카테고리 번호"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , get_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN orders  --쓰이지는 않는 경우도 있는데 코드 재활용성을 위해 그냥 넣어둠
        ON p.project_no = orders.project_no

WHERE c.project_status = '승인됨' --일단은 진행중인 프로젝트들이 젤먼저 보임
ORDER BY p.start_date DESC; --내림차순(최신일이 맨위)      
