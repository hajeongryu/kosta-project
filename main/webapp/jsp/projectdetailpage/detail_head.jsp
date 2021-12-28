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
<link rel="stylesheet" href="../../css/projectdetailpage/detail_head.css">
<html>
<div class="title">
	<div class="category">
	카테고리
	<%=p.getCategory().getCategoryName() %>
	</div>
	<div class="longteitle">
	<h1>프로젝트제목</h1>
	<%=p.getLongTitle() %>
	</div>
	<div class="creatoruser">
	창작자이름
	<%=p.getMaker().getUserName()%>
	</div>
	
	
</div>

<div class="img">
	<div class="projectimg">
	프로젝트이미지
	<%=p.getProjectImage() %>
	</div>
</div>

<div class="info">
	<div class="sumprice">
	모인금액
	<%=p.getProjectChange().getSumPrice() %>
	</div>
	<div class="duedate">
	남은시간
	<%=p.getRemainingDays() %>
	</div>
	<div class="supportcnt">
	후원자수
	<%=p.getProjectChange().getSupportCnt() %>
	</div>
	<div>
	펀딩준비중상자
		<div class="tagetprice">
		목표금액
		<%=p.getTargetPrice() %>
		</div>
		<div class="duedate">
		결제시작일
		<%=paymentDay %>
		</div>
	</div>

	<div class="content">
		<%=p.getProjectContent()%>
	</div>

	<div>
	<button>좋아한프로젝트</button>
	<button>이 프로젝트 후원하기</button>
	</div>
	
	
	<div class="reward">
	<%
	if(rewardList != null){
		for(Reward r : rewardList){
	%>
	<div>
		선물번호
		<%=r.getRewardNo() %>
		선물이름
		<%=r.getRewardName() %>


	</div>
	<%} }%>
	</div>
</div>

</html>