-- COMMENTS 테이블 생성
CREATE TABLE COMMENTS(
    comment_no      NUMBER(8)        CONSTRAINT comment_no_pk PRIMARY KEY, 
    post_no         NUMBER(8)        NOT NULL,
    comment_content VARCHAR2(100)    NOT NULL,
    comment_date    DATE             DEFAULT SYSDATE NOT NULL, 
    user_no         NUMBER(8)        NOT NULL, 
    CONSTRAINT comment_post_no_fk FOREIGN KEY (post_no) REFERENCES COMMUNITY (post_no),
    CONSTRAINT comment_user_no_fk FOREIGN KEY (user_no) REFERENCES USERS (user_no)
);

--COMMENTS_SEQ 생성
CREATE SEQUENCE COMMENTS_SEQ
START WITH 1
INCREMENT BY 1;

--COMMENTS_SEQ가 comment_no에 저장 trigger
CREATE OR REPLACE TRIGGER COMMENTS_AI_TRG
BEFORE INSERT ON COMMENTS 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT COMMENTS_SEQ.NEXTVAL
    INTO :NEW.comment_no
    FROM DUAL;
END;