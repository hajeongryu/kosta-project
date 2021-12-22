--좋아요/알림설정한 목록
SELECT p.project_no "프로젝트 번호"
        ,p.project_image "프로젝트 이미지"
        ,p.editor_pick "에디터 추천"
        ,p.long_title "프로젝트 제목"
        ,c.category_name "카테고리"
        ,u.user_name "프로젝트 작성자 이름"
        ,p.project_brief "프로젝트 요약"
        ,p.target_price "목표금액"
        ,pc.sum_price "모인금액"
        ,pc.support_cnt "후원자 수"
        ,(sysdate-p.end_date) "종료일"
FROM project p
    JOIN project_change pc ON p.project_no=pc.project_no
    JOIN users u ON p.user_no = u.user_no
    JOIN category c ON p.category_no=c.category_no
WHERE p.user_no=1;

--좋아요/알림 추가하기
INSERT INTO interest VALUES(1,4,'I');

--좋아요/알림 삭제하기
DELETE FROM interest WHERE project_no=1 and user_no=4;

--좋아요 눌렀는지 확인
SELECT * FROM interest WHERE project_no=4 and user_no=1;