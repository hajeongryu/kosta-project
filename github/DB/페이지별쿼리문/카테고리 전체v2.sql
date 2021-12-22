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
<<<<<<< HEAD
    JOIN category cate
        ON p.category_no = cate.category_no

    --JOIN orders  --쓰이지는 않는 경우도 있는데 코드 재활용성을 위해 그냥 넣어둠
      --  ON p.project_no = orders.project_no;
=======
    JOIN orders  --쓰이지는 않는 경우도 있는데 코드 재활용성을 위해 그냥 넣어둠
        ON p.project_no = orders.project_no;
>>>>>>> d7f1066ab4a0a1db6cdabd0e93c2c385ad22331a
        
        
        
--START

--<1.카테고리>================================--
--@리퀘스트 값 "categoty" = "all" / "board-games-and-trpg (1)" 등등..    / null

    -- all 이나 null 일시
--WHERE p.category_no >=0

        --카테고리 넘버 지정시
--WHERE p.category_no = '1' --해당 카테고리 번호





--<2.프로젝트 진행상황>=======================--
--@리퀘스트값  "ongoing" = onGoing(진행중 프로젝트) /confirm(성사된 프로젝트) /prelaunching(공개예정 프로젝트) / null


    -- 2-1.onGoing(진행중 프로젝트)--
--AND c.project_status = '승인' 

    --시작 된거/    오늘(1/6) > 시작일(1/5)  ||   오늘(1/1)  < 시작일(1/6) (x)
--AND sysdate > P.start_date 
    --마감일 안 지난거/    0 > -1 = 오늘(1/1)- 마감일(1/2) <음수>   || (x) 0 > 19  = 오늘(1/20)  -  마감일(1/1) 
--AND 0>= (sysdate -p.end_date ) 
    


    -- 2-2.confirm(성사된 프로젝트) (마감됨 + 모금액 초과)-- 
    --마감일 지난거   (o) 0< 9 =오늘(1/10)- 마감일(1/1)      || (x)  0 < -5 =오늘(1/5) - 마감일(1/10)  
--AND 0< (sysdate - p.end_date)
--AND c.sum_price > p.target_price;


    -- 2-3.prelaunching(공개예정 프로젝트)---
--AND c.project_status = '승인' 
--AND sysdate  < p.start_date;  -- 오늘(1/5) < 시작일(1/20)  






--3.<에디터 추천>==========================--
--@리퀘스트값 editorpick = '1' / null


    --3-1.에디터 추천 프로젝트(1)--
--AND p.editor_pick = '1';





--4.<달성률>==============================--
--@리퀘스트값 achieveRate=    (1) 75%이하   (2)75~100%    (3)100% 이상  / null

    --4-1.  75% 이하 달성률
--AND (c.sum_price / p.target_price) <0.75

    --4-2.  75~100% 달성률
--AND (c.sum_price / p.target_price) BETWEEN 0.75 AND 1.00


    --4-3.  100%이상 달성률
--AND (c.sum_price / p.target_price) >1.00







--5.<정렬>================================--
--@리퀘스트값 sort = popular(인기순)	publishedAt(최신순)	pledges(후원순)	amount(금액순) ended(마감 임박순)


   --1.popular(인기순) 좋아요순
--ORDER BY c.project_like_cnt DESC

    --2.pledges(후원순)
--ORDER BY c.support_cnt DESC

    --3.amount(금액순)
--ORDER BY c.sum_price DESC

    --4.publishedAt(최신순)
--AND c.project_status = '승인' 
--ORDER BY p.start_date DESC --내림차순(최신일이 맨위)

    --5.ended(마감 임박순)
--AND p.end_date<sysdate  --1월2일   < 1월3일
--ORDER BY p.end_date ASC

;
--END

SELECT p.project_no , start_date, end_date,project_status ,user_name, sum_price
FROM project p
JOIN project_change c
    ON  p.project_no = c.project_no
JOIN users u
    ON  u.user_no = p.user_no;
