-- interest 테이블 생성
CREATE TABLE INTEREST(
    project_no       NUMBER(8), 
    user_no          NUMBER(8),
    interest_alarm   CHAR(1)       NOT NULL,
    CONSTRAINT inter_pk PRIMARY KEY (project_no, user_no),
    CONSTRAINT inter_proj_no_fk FOREIGN KEY (project_no) REFERENCES PROJECT (project_no),
    CONSTRAINT inter_user_no_fk FOREIGN KEY (user_no) REFERENCES USERS (user_no),
    CONSTRAINT inter_alarm_ck CHECK(interest_alarm IN ('I','A'))
);