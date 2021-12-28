<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login/signup.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/login/signup.js"></script>
<script>
       $(function(){
			
       });
</script>
<title>Rholling Ideas</title>
</head>
<body>
    <div class="logo">
        <a href="<%=request.getContextPath()%>">
            <img src="<%=request.getContextPath()%>/images/mainpage/rholling.PNG">
        </a>
    </div>
    <div class="signup_box">
        <form class="signup_box2" method="post" action="<%=request.getContextPath()%>/signup">
            <h3>가입하기</h3>
            이름<br>
            <input type="text" name="name" placeholder="사용하실 이름을 입력해주세요" required>
            이메일 주소<br>
            <input type="text" name="id" placeholder="이메일 주소를 입력해주세요" required>
            <input type="text" name="id2" placeholder="이메일 주소를 확인합니다" required>
            비밀번호<br>
            <input type="password" name="pwd" placeholder="비밀번호를 입력해주세요" required>
            <input type="password" name="pwd2" placeholder="비밀번호를 확인합니다" required>

            <button id="signup_button">가입하기</button>
        </form>
        <hr>
        <div>
            이미 Rholling Ideas 계정이 있으신가요?
            <a href="<%=request.getContextPath()%>/jsp/login/login.jsp">기존 계정으로 로그인하기</a>
        </div>
    </div>
</body>
</html>