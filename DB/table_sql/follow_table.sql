--FOLLOWING Table Create SQL
CREATE TABLE follow(
    follow NUMBER(8),
    user_no NUMBER(8),
    CONSTRAINT follow_pk PRIMARY KEY(follow, user_no),
    CONSTRAINT follow_user_no_fk FOREIGN KEY (user_no) REFERENCES USERS (user_no),
    CONSTRAINT follow_fk FOREIGN KEY (follow) REFERENCES USERS (user_no)
);