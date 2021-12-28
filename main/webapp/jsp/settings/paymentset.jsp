<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css" >
	<link href="<%=request.getContextPath()%>/css/settings/settingsheader.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/settings/paymentset.css" rel="stylesheet" type="text/css">
<title>Rholling Ideas</title>
</head>
<body>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="./settingsheader.jsp"/>
    
    <section class="settings_box">
		등록된 결제수단
	    
	    <button>변경</button>
    </section>
    
    
    
</body>
</html>