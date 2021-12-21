ALTER TABLE users MODIFY user_role VARCHAR2(20);
ALTER TABLE users MODIFY user_role DEFAULT '�Ϲ�����';
ALTER TABLE users MODIFY user_privacy DEFAULT 1;
ALTER TABLE users MODIFY message_alarm_check DEFAULT 1;
ALTER TABLE users MODIFY updates_alarm_check DEFAULT 1;
ALTER TABLE users MODIFY follow_alarm_check DEFAULT 1;
ALTER TABLE users MODIFY marketing_alarm_check DEFAULT 1;

--���ּ� ���°�쵵 �־
ALTER TABLE address MODIFY receiver_address_detailed NULL;
--�Һ���� �ʼ��� �ƴ϶�...
ALTER TABLE address MODIFY receiver_phone NULL;

--�ּҰ� ����
ALTER TABLE project DROP CONSTRAINT proj_tar_price_ck;
ALTER TABLE project ADD CONSTRAINT proj_tar_price_ck CHECK(target_price>=500000);

--project_change �ڵ� ���� Ʈ����
CREATE OR REPLACE TRIGGER PROJECT_CHANGE_AI_TRG
        AFTER INSERT ON PROJECT
        FOR EACH ROW 
BEGIN 
    INSERT INTO project_change(project_no) VALUES(:new.project_no);
END;
/

--��۾��ϴ� ��쵵 �־ ����
ALTER TABLE reward MODIFY deliver_date NULL;

--�ڷ���ũ�� ����
ALTER TABLE orders MODIFY payment_result VARCHAR2(20);

--�÷��� ����
ALTER TABLE PROJECT_CHANGE RENAME COLUMN GET_PRICE TO SUM_PRICE;

--default �� �߰�
ALTER TABLE users MODIFY user_image DEFAULT "files/user_image/default_image.png";
