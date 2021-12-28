<%@page import="com.team.user.vo.Card"%>
<%@page import="java.util.List"%>
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

<%
List<Card> cards = (List)request.getAttribute("card");
%>
<body>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="./settingsheader.jsp"/>
    
    
<% 
if(cards != null){
for(Card card : cards){
	int cardNo = card.getCardNo();
	String cardNum = card.getCardNum();
	java.util.Date cardValidDate = card.getCardValidDate();
	String cardPwd = card.getCardPwd();
	String cardOwnerBirth = card.getCardOwnerBirth();
	String defaultCard = card.getDefaultCard();
%>
    <section class="settings_box">
		등록된 결제수단
		
		<%=cardNo %>
		<%=cardNum %>
		<%=cardValidDate %>
		<%=cardPwd %>
		<%=cardOwnerBirth %>
		<%=defaultCard %>
        <button>변경</button>
    </section>
<%
}
}
%>    
    
    
</body>
</html>