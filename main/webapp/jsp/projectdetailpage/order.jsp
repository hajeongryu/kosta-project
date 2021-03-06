<%@page import="com.team.user.service.AddrService"%>
<%@page import="com.team.user.vo.Address"%>
<%@page import="com.team.user.vo.Card"%>
<%@page import="com.team.user.service.CardService"%>
<%@page import="com.team.project.vo.Reward"%>
<%@page import="com.team.project.vo.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.team.user.vo.Users"%>
<%@page import="com.team.order.vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	Project buyProject = (Project)request.getAttribute("project");
	Reward buyReward = (Reward) request.getAttribute("reward");
	
	if(buyProject== null){
	}

	if(buyReward== null){
	}
	
	List<Card> cards =null;
	List<Address> addrs = null;
	Users u = (Users)session.getAttribute("loginInfo");
	if( u != null){
		int userNo = u.getUserNo();
		CardService cardService = CardService.getInstance();
		AddrService addrService = AddrService.getInstance();
		cards = cardService.findByUserNo(userNo);
		addrs = addrService.findByUserNo(userNo);
	}
%>
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/projectdetailpage/order.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/mainpage/index.js"></script>
  <script src="<%=request.getContextPath()%>/jsp/menu.jsp"></script>
  
  <script>
  	$(function(){
  	});
  </script>
  <title>Rholling Ideas - 재미있는 펀딩의 시작!</title>
  
</head>
<body>
  <header>
    <!-- 메뉴 -->
    <jsp:include page="../menu.jsp"/>
  </header>
  <section>
    <!--본문-->
<div class="order-rap">
		<div class="item-parent">
				<%if (buyProject != null) {%>
				<img
					class="item-image"
					src="/rhollEE/images/mainpage/<%=buyProject.getProjectNo() %>.jpeg"
					alt="l">
				<div class="item-info">
					<%=buyProject.getCategory().getCategoryName()%>
					|
					<%=buyProject.getMaker().getUserName() %>
					<h1><%=buyProject.getLongTitle() %></h1>
					<%=buyProject.getProjectChange().getSumPrice()%>원
					<%=buyProject.getAchiveRate() %>%
					<%=buyProject.getRemainingDays() %>
				<%}%>
				</div>
		</div>
		
		
		
<div class="item-boss">
		<div class="item-letf">

				<div class="title"><h3>선물정보</h3></div>
				<div class="boxform">
					<%if(buyReward != null) {%>
						<div class="box-item">선물구성 : <%=buyReward.getRewardName()%>
							  <% if(buyReward.getItemName() != null){%>
									 (<%=buyReward.getItemName()%>)
							 <%}%>
								 </div>
						<div class="box-item">선물금액 : <%=buyReward.getRewardPrice()%>원</div>
						<div class="box-item">예상 전달일 : <%=buyReward.getDeliverDate()%></div>

					<%}%>
				</div>

				<div class="title"><h3>후원자 정보</h3></div>
				<div class="boxform">
				<%if(u != null) {%>
                <div class="box-item">연락처 : <%=u.getUserPhone()%></div>
                <div class="box-item">이메일 : <%=u.getUserId() %></div>
				<%} %>
				</div>

	<% 
				if(addrs != null){
					for(Address addr : addrs){
						String receiverName = addr.getReceiverName();
						int receiverZipcode = addr.getReceiverZipcode();
						String receiverAddress = addr.getReceiverAddress();
						String receiverAddressDetailed = addr.getReceiverAddressDetailed();
						String receiverPhone = addr.getReceiverPhone();
						String defaultAddress = addr.getDefaultAddress();
						String defaultAddressOX = "X";
						if(defaultAddress.equals("1")) {
						defaultAddressOX = "O";
				}
		%>
				<div class="title"><h3>배송지</h2></div>
				<div class="boxform">
                <div class="box-item">받는사람 : <%=receiverName%></div>
                <div class="box-item">우편번호 : <%=receiverZipcode%></div>
                <div class="box-item"><%=receiverAddress%> 
									   <%=receiverAddressDetailed%></div>
               <div class="box-item">받는사람 전화번호 : <%=receiverPhone%></div>
                
                <div class="box-item">기본배송지여부<%=defaultAddressOX%></div>
				</div>
            <%
	}
}
%>

					  	<div class="title"><h3>결제수단</h3></div>
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
					    <div class="boxform">
                        <div class="box-item">카드번호 <%=cardNum %></div>
                        <div class="box-item">유효기간 <%=cardValidDate%></div>
                        <div class="box-item">생년월일 <%=cardOwnerBirth %></div>
                        <div class="box-item">기본결제수단여부 <%=defaultCardOX%></div>
						</div>

						<%
						}
					}
				%>
				</div> <!-- 아이템 레프트 -->
				
				
				<div class="item-right">

				<div class="final-payment">최종후원금액 <%=buyReward.getRewardPrice() %>원</div>
				<form method="post" action="<%=request.getContextPath()%>/orderadd">
				<input class="paymentButton" type="submit" value="후원하기!">
				<input type="hidden" name="totalPrice" value="<%=buyReward.getRewardPrice()%>">
				<input type="hidden" name="rewardNo" value="<%=buyReward.getRewardNo()%>">
				<input type="hidden" name="projectNo" value="<%=buyProject.getProjectNo()%>">
				</form>
				</div><!-- 아이템 라이트 -->
		</div><!-- 아이템 레프트 라이트 -->
</div><!-- 오더래퍼 -->

  </section>
</body>