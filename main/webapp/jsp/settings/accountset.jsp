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
    
    <section class="settings_box">
	    <div class="settings_subtitle">이메일</div>
	    
	    <div class="settings_subtitle">비밀번호</div>

	    <div class="settings_subtitle">연락처</div>
	    
	    <button>변경</button>
	    
	    <div class="settings_subtitle">회원탈퇴</div>
    </section>
    
    
    
</body>
</html>