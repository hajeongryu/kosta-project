
--프로젝트고정값
INSERT INTO project(project_no, user_no, category_no, long_title, project_brief, editor_pick, project_image, target_price, start_date, end_date, shrot_title, project_content, project_url)                
            VALUES (project_seq.NEXTVAL, '?', '?');
--프로젝트가변값
INSERT INTO project_change(project_no, support_cnt, project_status,sum_price,project_like_cnt)
        VALUES('?');