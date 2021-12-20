--CARD 테이블 생성
CREATE TABLE CARD(
    card_no             NUMBER(8)       CONSTRAINT card_no_pk PRIMARY KEY, 
    user_no             NUMBER(8)       NOT NULL, 
    card_num            VARCHAR2(20)    NOT NULL, 
    card_valid_date     DATE            NOT NULL, 
    card_pwd            VARCHAR2(4)     NOT NULL, 
    card_owner_birth    VARCHAR2(20)    NOT NULL, 
    default_card        CHAR(1)         NOT NULL, 
    CONSTRAINT card_user_no_fk FOREIGN KEY (user_no) REFERENCES USERS (user_no),
    CONSTRAINT card_default_ck CHECK (default_card IN (1, 0))
);

--CARD_SEQ 생성
CREATE SEQUENCE CARD_SEQ
START WITH 1
INCREMENT BY 1;

--CARD_SEQ기 card_no에 저장 trigger
CREATE OR REPLACE TRIGGER CARD_AI_TRG
BEFORE INSERT ON CARD 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT CARD_SEQ.NEXTVAL
    INTO :NEW.card_no
    FROM DUAL;
END;