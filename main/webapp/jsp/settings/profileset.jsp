<%@page import="com.team.user.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css" >
	<link href="<%=request.getContextPath()%>/css/settings/settingsheader.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/settings/profileset.css" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/settings/profileset.js"></script>
	<title>Rholling Ideas - 재미있는 펀딩의 시작!</title>

</head>
<body>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="./settingsheader.jsp"/>
    
    <%Users u = (Users)session.getAttribute("loginInfo");
    String userIntroduction = "";
    String userWebsite = "";
    if(u.getUserIntroduction() != null) {
    	userIntroduction = u.getUserIntroduction();
    }
    if(u.getUserWebsite() != null) {
    	userWebsite = u.getUserWebsite();
    }
    %>

    <section class="settings_box">
    	<form class="profileset" action="<%=request.getContextPath()%>/profileset" method="post">
    	
			<div class="settings_subtitle">프로필 사진</div>
			<img id="profile_image_viewer" width="50px" src="<%=request.getContextPath()%>/images/profile/default.png">
			<input type="text" name="image" value="<%=u.getUserImage()%>" readonly>
			<hr>
			
			<div class="settings_subtitle">이름</div>
			<input type="text" name="name" value="<%=u.getUserName()%>">
			<hr>
			
			<div class="settings_subtitle">사용자 이름(URL)</div>		
			localhost:8888/rhollEE/<input type="text" name="url" value="<%=u.getUserUrl()%>"><br>
			<hr>
			
			<div class="settings_subtitle">소개</div>
			<input type="text" name="introduction" value="<%=userIntroduction%>">
			<hr>
			
			<div class="settings_subtitle">웹사이트</div>
			<input type="text" name="website" value="<%=userWebsite%>"><br>
			
			<button>변경</button>
		</form>
    </section>
    
    
    
</body>
</html>