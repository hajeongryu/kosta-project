SELECT project_image "프로젝트 이미지"
        , long_title "프로젝트 제목"
        ,category_no "카테고리 번호"
        , user_name "프로젝트 작성자 이름"
        , project_brief "프로젝트 요약"
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
        
        
        
--START

--<1.카테고리>================================--
--@리퀘스트 값 "categoty" = "all" / "board-games-and-trpg (1)" 등등..    / null

    -- all 이나 null 일시
--WHERE p.category_no >=0

        --카테고리 넘버 지정시
--WHERE p.category_no = '1' --해당 카테고리 번호





--<2.프로젝트 진행상황>=======================--
--@리퀘스트값  "ongoing" = onGoing(진행중 프로젝트) /confirm(성사된 프로젝트) /prelaunching(공개예정 프로젝트) / null


    --1.onGoing(진행중 프로젝트)--
--AND c.project_status = '승인' and 0>(p.end_date- sysdate);

    --2.confirm(성사된 프로젝트)--
--AND  orders.payment_result = 1; 

    --3.prelaunching(공개예정 프로젝트)---
--AND c.project_status = '승인' AND p.end_date > sysdate;






--3.<에디터 추천>==========================--
--@리퀘스트값 editorpick = '1' / null


    --1.에디터 추천 프로젝트(1)--
--AND p.editor_pick = '1';





--4.<달성률>==============================--
--@리퀘스트값 achieveRate=    (1) 75%이하   (2)75~100%    (3)100% 이상  / null

    --1.  75% 이하 달성률
--AND (c.get_price / p.target_price) <0.75

    --2.  75~100% 달성률
--AND (c.get_price / p.target_price) BETWEEN 0.75 AND 1.00


    --3.  100%이상 달성률
--AND (c.get_price / p.target_price) >1.00







--5.<정렬>================================--
--@리퀘스트값 editorpick = '1'  /null


   --1.인기순
--ORDER BY c.project_like_cnt DESC
    --2.후원순
--ORDER BY c.support_cnt DESC
    --3.금액순
--ORDER BY c.get_price DESC

    --4.최신순
--  AND c.project_status = '승인됨' --일단은 진행중인 프로젝트들이 젤먼저 보임
--ORDER BY p.start_date DESC --내림차순(최신일이 맨위)

    --5.마감임박순
--AND p.end_date<sysdate  --1월2일   < 1월3일
--ORDER BY p.end_date ASC


;
--END
