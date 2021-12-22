--아우터조인으로 카테고리 이름 추가해야함

--1. 주목할만한 프로젝트(8개) = 달성률 100%이상 -----------------------------------------------------------------------
SELECT  p.project_no"프로젝트 번호"
        ,category_name "카테고리 이름"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , sum_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        , support_cnt"후원자 수"
        , project_image "프로젝트 이미지"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no

-- 달성률 100% 이상
WHERE (c.sum_price / p.target_price) >1.00
    AND sysdate < p.end_date --진행중 '승인' 필요없음 이미 모금됬기떄문에
    AND ROWNUM <=8
ORDER BY p.end_date ASC;




--2.인기프로젝트(12개) =좋아요 수-----------------------------------------------------------------------------------
SELECT  p.project_no"프로젝트 번호"
        ,category_name "카테고리 이름"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , sum_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        , support_cnt"후원자 수"
        , project_image "프로젝트 이미지"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no

        
WHERE c.project_status IN ('승인')
        --시작중+마감일 안지난거 = 진행중
    -- 시작 된거 (시작일)1월5일 <(오늘)1월6일   ||         (1월6일) < 현재(1월5일) (x)
    AND sysdate > P.start_date
    
     -- 마감일 안 지난거 (o) 0 > -1(음수) = 오늘(1/1)- 마감일(1/2)  || (x) 0 > 4(양수) = 오늘(1/5) -마감일(1/1)  
    AND 0>= (sysdate -p.end_date ) --0이면 날짜같음
    
    AND ROWNUM <=12

ORDER BY c.project_like_cnt DESC;





--4.마감임박! 프로젝트(16개) = 진행중 + 곧 마감------------------------------------------------------------------------------
SELECT  p.project_no"프로젝트 번호"
        ,category_name "카테고리 이름"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , sum_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        , support_cnt"후원자 수"
        , project_image "프로젝트 이미지"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no
        
WHERE c.project_status IN ('승인')
        -- 진행중 =시작됨+마감일 안지난거
    -- 시작 된거 (시작일)1월5일 <(오늘)1월6일   ||         (1월6일) < 현재(1월5일) (x)
    AND sysdate > P.start_date
     -- 마감일 안 지난거 (o) 0 > -1(음수) = 오늘(1/1)- 마감일(1/2)  || (x) 0 > 4(양수) = 오늘(1/5) -마감일(1/1)  
    AND -10 >= (sysdate -p.end_date ) --10일전       -10=오늘(1/10) -종료일(1/20)(종료 10일전) 
                                      --            -3 =오늘(1/17) - 종료일(1/20) (종료3일전)
    
    
ORDER BY p.end_date ASC;



--5.공개예정 프로젝트(16개)  0k--------------------------------------------------------------------------------------------
SELECT  p.project_no"프로젝트 번호"
        ,category_name "카테고리 이름"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , sum_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        , support_cnt"후원자 수"
        , project_image "프로젝트 이미지"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no

        
    --공개 예정 = 시작안된거 + 승인된거
WHERE c.project_status = '승인' 
    --  시작안된거    오늘(1/1) < 시작일(1/20)
    AND  sysdate  < p.start_date 
    AND ROWNUM <=16
    
ORDER BY p.start_date DESC;



--6.신규프로젝트(ok)----------------------------------------------------------------------------------------------------

SELECT  p.project_no"프로젝트 번호"
        ,category_name "카테고리 이름"
        , user_name "프로젝트 작성자 이름"
        , long_title "프로젝트 제목"
        , target_price "목표금액"
        , sum_price "모인금액" --목표금액/모인금액
        , end_date "종료일" --sysdate에서 enddate빼기
        , support_cnt"후원자 수"
        , project_image "프로젝트 이미지"
FROM project p
    JOIN project_change c
        ON p.project_no =c.project_no
    JOIN users u
        ON p.user_no = u.user_no
    JOIN category cate
        ON p.category_no = cate.category_no

WHERE c.project_status IN ('승인')
        --시작중+마감일 안지난거 = 진행중
    -- 시작 된거 (시작일)1월5일 <(오늘)1월6일   ||         (1월6일) < 현재(1월5일) (x)
    AND sysdate > P.start_date
    
     -- 마감일 안 지난거 (o) 0 > -1(음수) = 오늘(1/1)- 마감일(1/2)  || (x) 0 > 4(양수) = 오늘(1/5) -마감일(1/1)  
    AND 0>= (sysdate -p.end_date ) --0이면 날짜같음
    
    
    --프로젝트 시작한지 2주이내  5일지남 = 오늘(1/10) - 시작일(1/5) >    || 25일지남 = (1/30)오늘 - (1/5)시작일
    AND  14>= (sysdate - p.start_date) --14일지남
    
    
ORDER BY p.start_date DESC; --내림차순(최신일이 맨위)  




