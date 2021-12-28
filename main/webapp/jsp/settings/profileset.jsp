<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css" >
	<link href="<%=request.getContextPath()%>/css/settings/settingsheader.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/settings/profileset.css" rel="stylesheet" type="text/css">
<title>Rholling Ideas</title>
</head>
<body>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="./settingsheader.jsp"/>
    
    <section class="settings_box">
	    <div class="settings_subtitle">프로필 사진</div>
	    
	    <img src=""> 하... 개꼬였다<br>
	    <div class="settings_subtitle">사용자 이름(URL)</div>
	    localhost:8888/rhollEE/<br>
	    <div class="settings_subtitle">소개</div>
	    
	    <div class="settings_subtitle">웹사이트</div>
	    
	    <button>변경</button>
    </section>
    
    
    
</body>
</html>