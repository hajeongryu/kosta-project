<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rholling Ideas</title>
	<link rel="stylesheet" type="text/css" href="../../css/login/login.css">
</head>
<body>
    <div class="logo">
        <a href="../../jsp/mainpage/main_nav.jsp">
            <img src="../../images/mainpage/rholling.PNG">
        </a>
    </div>
    <div class="login_box">
        <div class="login_box2">
            <h3>로그인</h3>
            <div class="sns_login">
                    <button>페이스북 아이디로 로그인</button>
                    <button>네이버 아이디로 로그인</button>
                    <button>카카오톡 아이디로 로그인</button>
            </div>
            <hr>
            <form class= "email_login" method="post" action="../../login">
                <input type="text" name="id" placeholder="이메일 주소 입력" required>
                <input type="password" name="pwd" placeholder="비밀번호 입력" required>
                <button>로그인</button>
            </form>
            <div class="login_text">아직 Rholling ideas 계정이 없으신가요?<a href="">가입하기</a></div>
            <hr>
            <div class="login_text"><a href="">혹시 비밀번호를 잊으셨나요?</a></div>
        </div>
    </div>
</body>
</html>