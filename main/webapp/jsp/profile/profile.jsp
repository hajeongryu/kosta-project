<%@page import="java.util.List"%>
<%@page import="com.team.user.vo.Interest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="../../css/header.css">
  <link rel="stylesheet" href="../../css/profile/interestproject.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="../../js/mainpage/index.js"></script>
  <script src="../menu.jsp"></script>
  
  <script src="../../js/profile/interestprojectresult.js"></script>
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
  	<div class="left_profile">
    	<a href="설정"><img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\default.png">
    	<a href="설정"><img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\edit.png">
    	<!--설정 페이지 삽입해야함-->
 
 <section>
 <div class="top_box">
 	<a href="https://help.tumblbug.com/hc/ko">후원현황</a>
    <a href="https://help.tumblbug.com/hc/ko">관심 프로젝트</a>
    <a href="https://help.tumblbug.com/hc/ko">만든 프로젝트</a>
 </div>
    <!--후원현황-->
    <%-- <%List<Order> list = (List)request.getAttribute("list");
    int cnt= list.size();%> --%>
    <!--관심 프로젝트-->
    <%-- <%List<project> list = (List)request.getAttribute("list");
    int cnt= list.size();%> --%>
    <!--만든 프로젝트-->
    <%-- <%List<project> list = (List)request.getAttribute("list");
    int cnt= list.size();%> --%>
  		<div class="below_box"></div>
      		<a href="팔로우/팔로잉">팔로우/팔로잉</a><img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\following.png"/></a>
      		<!--팔로우/팔로잉 페이지 삽입하기-->
      		<a href="메시지">메시지</a><img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\inform.png"/></a>
      		<!--메시지 페이지 삽입하기-->
      	</div>
      			<div class="maker_tip">
        		<h3>메이커팁</h3>
        			<a href="https://tumblbug.com/notices"><img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\inform.png"/></a>
        			<a href="https://tumblbug.com/notices">공지사항</a>
        			<a href="https://help.tumblbug.com/hc/ko"><img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\help.png"/></a>
        			<a href="https://help.tumblbug.com/hc/ko">헬프센터</a><br>
        			<a href="https://creator.tumblbug.com/?v=1"><img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\guide.png"/></a>
        			<a href="https://creator.tumblbug.com/?v=1">창작자가이드</a>
       				<a href="https://tumblbug.channel.io/"><img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\telephone.png"/></a>
        			<a href="https://tumblbug.channel.io/">문의하기</a>
        		</div>
  </section>
</body>
</html>