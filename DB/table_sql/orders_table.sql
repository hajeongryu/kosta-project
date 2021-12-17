--ORDERS Table Create SQL
CREATE TABLE orders(
    payment_no NUMBER(8)CONSTRAINT payment_no_pk PRIMARY KEY,
    user_no NUMBER(8)NOT NULL,
    payment_date DATE default sysdate NOT NULL,
    extra_price NUMBER(8),
    total_price NUMBER(8)NOT NULL,
    payment_result VARCHAR2(10)not null,
    address_no NUMBER(8),
    card_no NUMBER(8)NOT NULL,
    reward_no NUMBER(8)NOT NULL,
    project_no NUMBER(8)NOT NULL,
    CONSTRAINT extra_price_ck CHECK(extra_price>0),
    CONSTRAINT payment_result_ck CHECK(payment_result IN('펀딩실패', '진행중', '펀딩성공', '결제완료')),
    CONSTRAINT total_price_ck CHECK(total_price BETWEEN 1000 and 10000000),
    CONSTRAINT oreders_address_no_fk FOREIGN KEY (address_no) REFERENCES ADDRESS (address_no),
    CONSTRAINT oreders_reward_proj_no_fk FOREIGN KEY (reward_no, project_no) REFERENCES REWARD (reward_no, project_no),
    CONSTRAINT oreders_card_no_fk FOREIGN KEY (card_no) REFERENCES CARD (card_no),
    CONSTRAINT oreders_user_no_fk FOREIGN KEY (user_no) REFERENCES USERS (user_no)
);

--ORDERS_SEQ 생성
CREATE SEQUENCE ORDERS_SEQ
START WITH 1
INCREMENT BY 1;

--ORDERS_SEQ가 payment_no에 저장 trigger
CREATE OR REPLACE TRIGGER ORDERS_AI_TRG
BEFORE INSERT ON ORDERS 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT ORDERS_SEQ.NEXTVAL
    INTO :NEW.payment_no
    FROM DUAL;
END;