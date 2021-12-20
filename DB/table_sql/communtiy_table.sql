-- COMMUNITY 테이블 생성
CREATE TABLE COMMUNITY(
    post_no         NUMBER(8)        CONSTRAINT community_post_no_pk PRIMARY KEY, 
    project_no      NUMBER(8)        NOT NULL,
    post_content    VARCHAR2(100)    NOT NULL,
    post_date       DATE             DEFAULT SYSDATE NOT NULL,  
    user_no         NUMBER(8)        NOT NULL, 
    CONSTRAINT community_proj_no_fk FOREIGN KEY (project_no) REFERENCES PROJECT (project_no),
    CONSTRAINT community_user_no_fk FOREIGN KEY (user_no) REFERENCES USERS (user_no)
);

--COMMUNITY_SEQ 생성
CREATE SEQUENCE COMMUNITY_SEQ
START WITH 1
INCREMENT BY 1;

--COMMUNITY_SEQ가 post_no에 저장 trigger
CREATE OR REPLACE TRIGGER COMMUNITY_AI_TRG
BEFORE INSERT ON COMMUNITY 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT COMMUNITY_SEQ.NEXTVAL
    INTO :NEW.post_no
    FROM DUAL;
END;