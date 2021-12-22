-- REWARD 테이블 생성
CREATE TABLE REWARD(
    project_no          NUMBER(8), 
    reward_no           NUMBER(8), 
    reward_price        NUMBER(8)        NOT NULL, 
    reward_name         VARCHAR2(200), 
    deliver_date        NUMBER(4)        NOT NULL, 
    reward_num          NUMBER(4), 
    reward_sales_cnt    NUMBER(8)        DEFAULT 0 NOT NULL, 
    item_name           VARCHAR2(300), 
    deliver_select      CHAR(1)          NOT NULL, 
    CONSTRAINT reward_pk PRIMARY KEY (project_no, reward_no),
    CONSTRAINT reward_proj_no_fk FOREIGN KEY (project_no)REFERENCES PROJECT (project_no),
    CONSTRAINT reward_price_ck CHECK (reward_price>=1000),
    CONSTRAINT reward_deliver_date_ck CHECK (deliver_date BETWEEN 1 AND 1825),
    CONSTRAINT reward_num_ck CHECK (reward_num BETWEEN 1 AND 1000),
    CONSTRAINT reward_delive_select_ck CHECK (deliver_select IN (1,0))
);

--REWARD_SEQ 생성
CREATE SEQUENCE REWARD_SEQ
START WITH 1
INCREMENT BY 1;

--REWARD_SEQ가 reward_no에 저장 트리거
CREATE OR REPLACE TRIGGER REWARD_AI_TRG
BEFORE INSERT ON REWARD 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT REWARD_SEQ.NEXTVAL
    INTO :NEW.reward_no
    FROM DUAL;
END;