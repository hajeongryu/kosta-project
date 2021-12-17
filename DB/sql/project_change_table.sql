-- PROJECT_CHANGE 테이블 생성
CREATE TABLE PROJECT_CHANGE(
    project_no        NUMBER(8)       CONSTRAINT proj_ch_no_pk PRIMARY KEY, 
    support_cnt       NUMBER(8)       DEFAULT 0 NOT NULL,
    project_status    VARCHAR2(10)    DEFAULT '심사중' NOT NULL, 
    get_price         NUMBER(8)       DEFAULT 0 NOT NULL, 
    project_like_cnt  NUMBER(8)       DEFAULT 0 NOT NULL,
    CONSTRAINT proj_status_ck CHECK(project_status IN('심사중', '승인', '반려', '중지')),
    CONSTRAINT proj_change_no_fk FOREIGN KEY (project_no) REFERENCES PROJECT (project_no)
);




