<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Rholling Ideas - 재미있는 펀딩의 시작!</title>

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login/login.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/login/login.js"></script>
	<script>
        $(function(){
			loginClick();
        });
	</script>
</head>
<body>
    <div class="logo">
        <a href="<%=request.getContextPath()%>/jsp/mainpage/index.jsp">
            <img src="<%=request.getContextPath()%>/images/mainpage/rholling.PNG">
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
            <form class= "email_login" method="post" action="<%=request.getContextPath()%>/login">
                <input type="text" name="id" placeholder="이메일 주소 입력" required>
                <input type="password" name="pwd" placeholder="비밀번호 입력" required>
                <button>로그인</button>
            </form>
            <div class="login_text">아직 Rholling ideas 계정이 없으신가요?
            			<a href="<%=request.getContextPath()%>/jsp/login/signup.jsp">가입하기</a></div>
            <hr>
            <div class="login_text"><a href="">혹시 비밀번호를 잊으셨나요?</a></div>
        </div>
    </div>
</body>
</html>