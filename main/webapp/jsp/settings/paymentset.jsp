<%@page import="com.team.user.service.CardService"%>
<%@page import="com.team.user.vo.Users"%>
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
Users u = (Users)session.getAttribute("loginInfo");
int userNo = u.getUserNo();
CardService cardService = CardService.getInstance();
List<Card> cards = cardService.findByUserNo(userNo);
%>
<body>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="./settingsheader.jsp"/>
    
    <section class="settings_box">
		등록된 결제수단
		<button id="card_add">추가</button>

<% 
if(cards != null){
for(Card card : cards){
	String cardNum = card.getCardNum();
	java.util.Date cardValidDate = card.getCardValidDate();
	String cardOwnerBirth = card.getCardOwnerBirth();
	String defaultCard = card.getDefaultCard();
	String defaultCardOX = "X";
	if(defaultCard.equals("1")) {
		defaultCardOX = "O";
	}
%>

	
		<div class="card_box">
			카드번호 <%=cardNum %><br>
			유효기간 <%=cardValidDate %><br>
			생년월일 <%=cardOwnerBirth %><br>
			기본결제수단여부 <%=defaultCardOX%><br>
			<button id="card_default">기본결제수단으로 변경</button>
			<button id="card_remove">삭제</button>
		</div>

    </section>
<%
}
}
%>    
    
    
</body>
</html>