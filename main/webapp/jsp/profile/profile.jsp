<%@page import="java.util.ArrayList"%>
<%@page import="com.team.project.vo.Project"%>
<%@page import="com.team.order.vo.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.team.user.vo.Interest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

int projectSize =0;
int orderSize=0;
int interestSize=0;


if( null!=request.getAttribute("projectSize")){
	projectSize = (int) request.getAttribute("projectSize");
}
if( null!=request.getAttribute("orderSize")){
orderSize = (int) request.getAttribute("orderSize");
}
if( null!=request.getAttribute("interestSize")){
interestSize = (int) request.getAttribute("interestSize");
}

%>


    
<!DOCTYPE html>
<head>
	<title>Rholling Ideas - 재미있는 펀딩의 시작!</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/interestproject.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/profile.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/mainpage/index.js"></script>
  <script src="<%=request.getContextPath()%>/jsp/menu.jsp"></script>
  
  <script src="<%=request.getContextPath()%>js/profile/interestprojectresult.js"></script>
  <script>
  	$(function(){
  		/*--메뉴 클릭 되었을 때 START--*/
  		menuClick();
  		/*--메뉴 클릭 되었을 때 END--*/
  	});
  </script>
	
</head>
<body>
  <header>
    <!-- 메뉴 -->
    <jsp:include page="../menu.jsp"/>
  </header>
  
	<section>
			<div class="aside">
				<div class="image">
					<a href=""><img class = "image" src="<%=request.getContextPath()%>/images/profile/default.png"></a>
				</div>
				<div class="imagedit">
					<a href=""><img class = "imagedit" src="<%=request.getContextPath()%>/images/profile/edit.png"></a>
				</div>
				<h3>user_name님></h3>
				<h6>일반유저or창작자</h6>
				<!--조건 설정해야함-->
				<div class="logout">
					<button><h4>로그아웃<h4></button>
				</div>
			</div>

		<article>
		<div class="article">
			<div class="topbox">
				<div>
					<a href=""><span><%=orderSize%></span>후원현황</a>
				</div>
				<div>
					<a href=""><span><%=interestSize%></span>관심 프로젝트</a>
				</div>
				<div>
					<a href=""><span><%=projectSize%></span>만든 프로젝트</a>
				</div>
			</div>
			<div class="belowbox">
					<a href=""><img class="img" src="<%=request.getContextPath()%>/images/profile/following.png"/><span>팔로우/팔로잉</span></a>
					<!--팔로우/팔로잉 페이지 삽입하기-->
					<a href=""><img class="img" src="<%=request.getContextPath()%>/images/profile/message.png"/><span>메시지</span></a>
					<!--메시지 페이지 삽입하기-->
					<h3>메이커팁</h3>
					<a href=""><img class="img" src="<%=request.getContextPath()%>/images/profile/inform.png"/><span>공지사항</span></a>
					<a href=""><img class="img" src="<%=request.getContextPath()%>/images/profile/help.png"/><span>헬프센터</span></a>
					<a href=""><img class="img" src="<%=request.getContextPath()%>/images/profile/guide.png"/><span>창작자가이드</span></a>
					<a href=""><img class="img" src="<%=request.getContextPath()%>/images/profile/telephone.png"/><span>문의하기</span></a>
			</div>
		</div>
  </section>
</body>
</html>