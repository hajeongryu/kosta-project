--USERS Table Create SQL
CREATE TABLE users(
    user_no NUMBER(8)CONSTRAINT user_no_pk PRIMARY KEY,
    user_role VARCHAR2(10) not null,
    user_id VARCHAR2(30) not null,
    user_image VARCHAR2(100),
    user_name VARCHAR2(20) not null,
    user_pwd VARCHAR2(20) not null,
    user_phone VARCHAR2(20),
    user_introduction VARCHAR2(100),
    user_website VARCHAR2(100),
    user_url VARCHAR2(100) NOT NULL,
    user_privacy CHAR(1) NOT NULL,
    message_alarm_check CHAR(1) NOT NULL,
    updates_alarm_check CHAR(1) NOT NULL,
    follow_alarm_check CHAR(1) NOT NULL,
    marketing_alarm_check CHAR(1) NOT NULL,
    user_signup_date DATE DEFAULT SYSDATE NOT NULL,
    user_status VARCHAR2(10) DEFAULT 1 NOT NULL,
    CONSTRAINT user_no_ck CHECK(user_no>0),
    CONSTRAINT user_role_ck CHECK (user_role IN ('일반유저','창작자','관리자')),
    CONSTRAINT user_url_uq UNIQUE (user_url),
    CONSTRAINT user_privacy_ck CHECK (user_privacy IN (1,0)),
    CONSTRAINT message_alarm_ck CHECK (message_alarm_check IN (1,0)),
    CONSTRAINT updates_alarm_ck CHECK (updates_alarm_check  IN (1,0)),
    CONSTRAINT follow_alarm_ck CHECK (follow_alarm_check IN (1,0)),
    CONSTRAINT market_alarm_ck CHECK (marketing_alarm_check IN (1,0)),
    CONSTRAINT user_status_ck CHECK (user_status IN (1,0))
);
--USERS_SEQ 생성
CREATE SEQUENCE USERS_SEQ
START WITH 1
INCREMENT BY 1;

--USERS_SEQ가 user_no에 저장 trigger
CREATE OR REPLACE TRIGGER USERS_AI_TRG
BEFORE INSERT ON USERS
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT USERS_SEQ.NEXTVAL
    INTO :NEW.user_no
    FROM DUAL;
END;

--user_id 유니크 제약 추가
ALTER TABLE users ADD CONSTRAINT user_id_uq UNIQUE (user_id);