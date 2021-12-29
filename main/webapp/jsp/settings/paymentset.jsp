<%@page import="java.text.SimpleDateFormat"%>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/settings/paymentset.js"></script>

	<title>Rholling Ideas - 재미있는 펀딩의 시작!</title>

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
		결제수단 추가
		<div class="card_box">
			<form method="post" action="<%=request.getContextPath()%>/cardadd">
				<input type="text" value="<%=userNo%>" name="userNo" class="invisible">
				카드번호 <input type="text" name="cardNum" required><br>
				유효기한 <input type="date" name="cardValidDate" required><br>
				비밀번호 <input type="password" name="cardPwd" required><br>
				생년월일 <input type="text" name="cardOwnerBirth" placeholder="ex)19910101" required><br>
				기본결제수단으로 등록 <input type="checkbox" name="defaultCard" checked>
				<button>추가</button>
			</form>
		</div>
		<hr>
		등록된 결제수단
<% 
if(cards != null){
for(Card card : cards){
	int cardNo = card.getCardNo();
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
			유효기간 <%=cardValidDate%><br>
			생년월일 <%=cardOwnerBirth %><br>
			기본결제수단여부 <%=defaultCardOX%><br>
			<form action="<%=request.getContextPath()%>/cardmodify">
				<input type="text" class="invisible" value="<%=cardNo%>" name="cardNo">
				<button id="card_default">기본결제수단으로 변경</button>
			</form>
			<form action="<%=request.getContextPath()%>/cardremove">
				<input type="text" class="invisible" value="<%=cardNo%>" name="cardNo">
				<button id="card_remove">삭제</button>
			</form>
		</div>

<%
}
}
%>    
    </section> 
    
</body>
</html>