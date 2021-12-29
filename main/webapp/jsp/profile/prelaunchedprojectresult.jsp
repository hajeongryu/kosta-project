<%@page import="com.team.project.vo.Project"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.team.user.vo.Interest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
  <title>Rholling Ideas - 재미있는 펀딩의 시작!</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/interestproject.css">
  <link  href="<%=request.getContextPath()%>/css/discover/discover_project.css" rel="stylesheet" type="text/css" >
</head>

<body>
  <header>
    <!-- 메뉴 -->
    <%@ include file="../menu.jsp" %>
  </header>

  <section>
    <!--본문-->
    <%List<Interest> list = (List)request.getAttribute("list");
    DecimalFormat formatter= new DecimalFormat("###,###");
    int interCnt = (int)request.getAttribute("interCnt");
    int alarmCnt = (int)request.getAttribute("alarmCnt");
    Project p = null;%>
    <div class="interest-header">
      <div class="interest-h1"><h1>관심 프로젝트</h1></div>
      <div class="interest-select">
        <span>
          <a href="interestlist">좋아한 <%=interCnt%></a>
        </span>
        <span class="selected-span">
          <a href="prelaunchedlist" class="selected-a" style="color: black;">알림신청 <%=alarmCnt%></a>
        </span>
      </div>
    </div>
    <div class="select-content">
	<br><br>
	<%if(list.size()==0) {%>
		<div class="no-content">
			<img src="<%=request.getContextPath()%>/images/profile/empty heart.png">
			<div>좋아한 프로젝트가 없습니다.</div>
		</div>
	<% } %>
      <%for(Interest inter : list){
		p = inter.getLikeProject();%>
		<!-- 글 -->
		<div class="item" >
			<!-- 사진 -->
			<!--@@@ 사진클릭시 상품페이지로 -->
			<a href="/rhollEE/projectdetail?projectNo=<%=p.getProjectNo()%>">
				<img class="item-image" src="/rhollEE/images/mainpage/<%=p.getProjectNo() %>.jpeg" alt="l">
			</a>
			<!-- 정보 -->
			<div class="info">
				<!-- (이름, 세부 카테, 설명)-->
				<a href ="/rhollEE/projectdetail?projectNo=<%=p.getProjectNo()%>">
					<span class="title"><%=p.getLongTitle() %></span>
				</a>
				<div class ="catelink">
					<!--@@@ 카테고리 클릭시 카테고리 페이지로 -->
					<span class="category"><a href=""><%=p.getCategory().getCategoryName() %></a></span>
					<span class="category">|</span>
					<!--@@@ Maker 클릭지 상품페이지로 -->
					<span class="company"><a href=""><%=p.getMaker().getUserName()%></a></span>
		
				</div>
				<span class="iteminfo"><%=p.getProjectBrief() %></span>

				<!-- 알림 신청 버튼 -->
				<button class="alarmrequest">알림 신청 완료</button>
				<%-- <div class="priceAndPercent">
					<span class="price"><%=formatter.format(p.getProjectChange().getSumPrice()) %>원</span>
					<span class="percent"><%=p.getAchiveRate()%>%</span>
					<span class="leftDay"> 
						<img src="/rhollEE/images/mainpage/time.PNG">
						<%=p.getRemainingDays() %>
					</span>
				</div> --%>
			</div>
		</div>
	<%} %>
    </div>
  </section>
</body>
