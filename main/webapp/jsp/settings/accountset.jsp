<%@page import="com.team.user.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css" >
	<link href="<%=request.getContextPath()%>/css/settings/settingsheader.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/settings/accountset.css" rel="stylesheet" type="text/css">
<title>Rholling Ideas</title>
</head>
<body>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="./settingsheader.jsp"/>
    
	<%Users u = (Users)session.getAttribute("loginInfo");
    String userPhone = "";
    if(u.getUserPhone() != null) {
    	userPhone = u.getUserPhone();
    }

    %>
    
    <section class="settings_box">
    	<form method="post" action="<%=request.getContextPath()%>/accountest">
			<div class="settings_subtitle">이메일</div>
			<input type="text" name="id" value="<%=u.getUserId()%>">
			<hr>
			
			<div class="settings_subtitle">비밀번호</div>
			<input type="password" name="pwdChange" placeholder="변경할 비밀번호"><br>
			<input type="password" name="pwdChange2" placeholder="변경할 비밀번호 확인">
			<hr>
			
			<div class="settings_subtitle">연락처</div>
			<input type="text" name="phone" value="<%=userPhone%>">
			<hr>
			
			<div class="settings_subtitle">변경을 위해 현재 비밀번호가 필요합니다</div>
			<input type="password" name="pwd" placeholder="현재 비밀번호" required><br>
			
			<button>변경</button>
		</form>

			<div class="settings_subtitle">회원탈퇴</div>
		<form action="<%=request.getContextPath()%>/withdrawal">
			<button>탈퇴</button>
		</form>
    </section>
    
    
    
</body>
</html>