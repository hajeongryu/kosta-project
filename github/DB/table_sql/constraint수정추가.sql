ALTER TABLE users MODIFY user_role VARCHAR2(20);
ALTER TABLE users MODIFY user_role DEFAULT '일반유저';
ALTER TABLE users MODIFY user_privacy DEFAULT 1;
ALTER TABLE users MODIFY message_alarm_check DEFAULT 1;
ALTER TABLE users MODIFY updates_alarm_check DEFAULT 1;
ALTER TABLE users MODIFY follow_alarm_check DEFAULT 1;
ALTER TABLE users MODIFY marketing_alarm_check DEFAULT 1;

--상세주소 없는경우도 있어서
ALTER TABLE address MODIFY receiver_address_detailed NULL;
--텀블벅에 필수가 아니라서...
ALTER TABLE address MODIFY receiver_phone NULL;

--최소값 수정
ALTER TABLE project DROP CONSTRAINT proj_tar_price_ck;
ALTER TABLE project ADD CONSTRAINT proj_tar_price_ck CHECK(target_price>=500000);

--project_change 자동 생성 트리거
CREATE OR REPLACE TRIGGER PROJECT_CHANGE_AI_TRG
        AFTER INSERT ON PROJECT
        FOR EACH ROW 
BEGIN 
    INSERT INTO project_change(project_no) VALUES(:new.project_no);
END;
/

--배송안하는 경우도 있어서 삭제
ALTER TABLE reward MODIFY deliver_date NULL;

--자료형크기 수정
ALTER TABLE orders MODIFY payment_result VARCHAR2(20);

--컬럼명 수정
ALTER TABLE PROJECT_CHANGE RENAME COLUMN GET_PRICE TO SUM_PRICE;

--default 값 추가
ALTER TABLE users MODIFY user_image DEFAULT "files/user_image/default_image.png";
