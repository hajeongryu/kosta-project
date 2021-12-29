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
		<div class="settings_subtitle">결제수단 추가</div>
		<div class="card_box">
			<form method="post" action="<%=request.getContextPath()%>/cardadd">
				<input type="text" value="<%=userNo%>" name="userNo" class="invisible">
				<span class="address_value_name">카드번호</span> <input type="text" name="cardNum" size="40" required><br>
				<span class="address_value_name">유효기한</span> <input type="date" name="cardValidDate" size="40" required><br>
				<span class="address_value_name">비밀번호</span> <input type="password" name="cardPwd" size="40" required><br>
				<span class="address_value_name">생년월일</span> <input type="text" name="cardOwnerBirth" placeholder="ex)19910101" size="40" required><br>
				기본결제수단으로 등록 <input type="checkbox" name="defaultCard" size="40" checked>
				<button>추가</button>
			</form>
		</div>
		<hr>
		<div class="settings_subtitle">등록된 결제수단</div>
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
			<span class="address_value_name">카드번호</span> <input type="text" name="receiverName" value="<%=cardNum%>" size="40" readonly><br>
			<span class="address_value_name">유효기간</span> <input type="text" name="receiverName" value="<%=cardValidDate%>" size="40" readonly><br>
			<span class="address_value_name">생년월일</span> <input type="text" name="receiverName" value="<%=cardOwnerBirth%>" size="40" readonly><br>
			<span id="default_value">기본배송지여부</span> <%=defaultCardOX%><br>
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