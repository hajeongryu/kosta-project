-- ADDRESS 테이블 생성
CREATE TABLE ADDRESS(
    address_no                   NUMBER(8)       CONSTRAINT address_no_pk PRIMARY KEY, 
    user_no                      NUMBER(8)       NOT NULL, 
    receiver_name                VARCHAR2(20)    NOT NULL, 
    receiver_zipcode             NUMBER(8)       NOT NULL, 
    receiver_address             VARCHAR2(100)   NOT NULL, 
    receiver_address_detailed    VARCHAR2(100)   NOT NULL, 
    receiver_phone               VARCHAR2(20)    NOT NULL, 
    default_address              CHAR(1)         NOT NULL, 
    CONSTRAINT address_user_no_fk FOREIGN KEY (user_no) REFERENCES USERS (user_no),
    CONSTRAINT address_default_ck CHECK (default_address IN (1, 0))
);

--ADDRESS_SEQ생성
CREATE SEQUENCE ADDRESS_SEQ
START WITH 1
INCREMENT BY 1;

--ADDRESS_SEQ가 address_no에 저장 트리거
CREATE OR REPLACE TRIGGER ADDRESS_AI_TRG
BEFORE INSERT ON ADDRESS 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT ADDRESS_SEQ.NEXTVAL
    INTO :NEW.address_no
    FROM DUAL;
END;


