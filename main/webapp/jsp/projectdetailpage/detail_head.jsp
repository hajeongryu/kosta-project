<%@page import="com.team.project.vo.Community"%>
<%@page import="java.util.List"%>
<%@page import="com.team.project.vo.Reward"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.team.project.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 Project p = (Project) request.getAttribute("findedProject");
 List<Reward> rewardList = (List) request.getAttribute("findedProjectReward");
 

 SimpleDateFormat format = new SimpleDateFormat("MM-DD");
 
 Calendar cal =Calendar.getInstance();
 cal.setTime(p.getEndDate());
 cal.add(Calendar.DATE, 7);
 
 String paymentDay=""+format.format(cal.getTime());
 %>

<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/projectdetailpage/detail_head.css">
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
<div class="container">
	<div class="head">
		<div class="title">
			<div class="category">
			<%=p.getCategory().getCategoryName() %>
			</div>
			<div class="longtitle">
			프로젝트제목
			<%=p.getLongTitle() %>
			</div>
			<div class="creatoruser">
		<%=p.getMaker().getUserName()%> 님의 프로젝트
		</div>
		</div>

		<div class="img">
			<div class="projectimg">
			<img class="item-image" src="/rhollEE/images/mainpage/<%=p.getProjectNo()%>.jpeg">
			</div>
		</div>
	
		<div class="info">
			<div class="sumprice">
			모인금액<br>
			<h1><%=p.getProjectChange().getSumPrice()%>원</h1>
			</div>
			<div class="duedate">
			남은시간<br>
			<h1><%=p.getRemainingDays() %></h1>
			</div>
			<div class="supportcnt">
			후원자수<br>
			<h1><%=p.getProjectChange().getSupportCnt()%>명</h1>
			</div>
			<div class="ingbox">
			펀딩 진행중
				<div class="tagetprice">
				목표금액 인<%=p.getTargetPrice()%> 원이 모여야 결제됩니다.
				</div>
				<div class="duedate">
				결제시작일은 <%=paymentDay%>일 입니다.
				</div>
			</div>
		
			
			<div style="display: none;">
			<button>좋아한프로젝트</button>
			<button>이 프로젝트 후원하기</button>
			</div>
		
			</div>
	</div>

	<div class="bot">
	<div class="content">
	
	<!-- object data="/rhollEE/<%=p.getProjectContent()%>" style="min-height:100vh;width:100%"></object> -->
		<iframe src="/rhollEE/src/main/webapp/<%=p.getProjectContent()%>" style="width:200px;height:200px;"></iframe>
	</div>

	<div class="postcon">
		<%@include file="./post.jsp" %>
	</div>
	</div>


</div>
	<div class="reward">
			<%
			if(rewardList != null){
				for(Reward r : rewardList){
			%>
			<div>
				<button type="button" onclick="location.href='http://localhost:8888/rhollEE/order?projectNo=<%=p.getProjectNo()%>&rewardNo=<%=r.getRewardNo()%>'">
					선물번호
					<%=r.getRewardNo() %>
					선물이름
					<%=r.getRewardName() %>
				</button>
			</div>
			<%} }%>
		</div>
</section>