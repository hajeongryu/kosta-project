-- REJECT 테이블 생성
CREATE TABLE REJECT(
    project_no       NUMBER(8)        CONSTRAINT rej_proj_no_pk PRIMARY KEY, 
    reject_reason    VARCHAR2(100)    NOT NULL,
    CONSTRAINT rej_proj_no_fk FOREIGN KEY (project_no) REFERENCES PROJECT_CHANGE (project_no)
);