<회원가입>

아이디 중복여부 확인
SELECT * FROM users WHERE user_id = ?;

회원추가
INSERT INTO users VALUES (~~~); --사용자이름URL 프라이버시~알림설정 default 없으면 일일이 설정
--참고로 user_no는 시퀀스 자동발급, 입력x
------------------------------------------------------------------------------------
<프로필> - 로그인 후 세션에서 회원번호 저장

프로필사진
SELECT user_image FROM users WHERE user_no=?; --조회
UPDATE users SET user_image=? WHERE user_no=?; --수정

이름
SELECT user_name FROM users WHERE user_no=?; --조회
UPDATE users SET user_name=? WHERE user_no=?; --수정

사용자이름URL
SELECT user_url FROM users WHERE user_no=?; --(조회 및 중복확인)
UPDATE users SET user_url=? WHERE user_no=?; --수정

소개
SELECT user_introduction FROM users WHERE user_no=?; --조회
UPDATE users SET user_introduction=? WHERE user_no=?; --수정

웹사이트(하나만 가능하도록 - 텀블벅은 여러개 허용)
SELECT user_website FROM users WHERE user_no=?; --조회
UPDATE users SET user_website=? WHERE user_no=?; --수정

이메일
SELECT user_id FROM users WHERE user_no=?; --조회
변경불가

비밀번호
SELECT user_pwd FROM users WHERE user_no=?; --조회
UPDATE users SET user_pwd=? WHERE user_no=?; --수정

연락처
SELECT user_phone FROM users WHERE user_no=?; --조회
UPDATE users SET user_phone=? WHERE user_no=?; --수정

회원탈퇴
UPDATE users SET user_status=? WHERE user_no=?; --변경

결제수단
SELECT * FROM card WHERE user_no=?; --조회
INSERT INTO card VALUES (~~~~~~~); --카드 추가 card_no는 생략 시퀀스로 자동발급
변경불가
DELETE * FROM card WHERE card_no=?; --카드삭제

배송지
SELECT * FROM address WHERE user_no=? --조회
INSERT INTO address VALUES (~~~); --배송지추가 address_no는 생략 시퀀스로 자동발급
UPDATE address SET (~~~~) WHERE address_no=?; --수정
DELETE * FROM address WHERE address_no=?; --삭제





