-- PROJECT 테이블
CREATE TABLE PROJECT(
    project_no         NUMBER(8)        CONSTRAINT proj_no_pk PRIMARY KEY, 
    user_no            NUMBER(8)        NOT NULL,
    category_no        NUMBER(8)        NOT NULL,  
    long_title         VARCHAR2(200)    NOT NULL, 
    project_brief      VARCHAR2(200)    NOT NULL, 
    editor_pick        CHAR(1)          DEFAULT 0 NOT NULL, 
    project_image      VARCHAR2(100)    NOT NULL, 
    target_price       NUMBER(8)        NOT NULL, 
    start_date         DATE             NOT NULL, 
    end_date           DATE             NOT NULL, 
    short_title        VARCHAR2(100)    NOT NULL, 
    project_content    VARCHAR2(100)    NOT NULL, 
    project_url        VARCHAR2(100)    UNIQUE NOT NULL,
    CONSTRAINT proj_user_no_fk FOREIGN KEY (user_no) REFERENCES USERS (user_no),
    CONSTRAINT proj_cate_no_fk FOREIGN KEY (category_no) REFERENCES CATEGORY (category_no),
    CONSTRAINT proj_edit_pick_ck CHECK(editor_pick IN (1, 0)),
    CONSTRAINT proj_tar_price_ck CHECK(target_price>=500000),
    CONSTRAINT proj_end_dt_ck CHECK(end_date>start_date)
);

--PROJECT_SEQ 생성
CREATE SEQUENCE PROJECT_SEQ
START WITH 1
INCREMENT BY 1;

--PROJECT_SEQ가 project_no에 저장 trigger
CREATE OR REPLACE TRIGGER PROJECT_AI_TRG
BEFORE INSERT ON PROJECT 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT PROJECT_SEQ.NEXTVAL
    INTO :NEW.project_no
    FROM DUAL;
END;