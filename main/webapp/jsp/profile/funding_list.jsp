<%@page import="com.team.order.vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/interestproject.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/mainpage/index.js"></script>
  <script src="<%=request.getContextPath()%>/jsp/menu.jsp"></script>
  
  <script src="<%=request.getContextPath()%>/js/profile/interestprojectresult.js"></script>
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
    <!--본문-->
    <%-- <%List<Order> list = (List)request.getAttribute("list");
    int cnt= list.size();%> --%>
    <div class="like-header">
      <div class="like-h1"><h1>후원현황</h1></div>
      <div class="like-select">
        <span>
        <%-- <%if(cnt==0){%>
        	후원 내역이 없습니다.
        <%}
        else{%>후원성공(<%=list.size()%>)<%}%> --%>
        </span>
      </div>
    </div>
    <div class="select-content">
      <form class= "searching" method="post" action="../../seach">
			<input type="text" name="search" placeholder="프로젝트, 선물, 창작자를 입력하세요" required><br>
		</form>
			<div class="funding lists_empty">
			<img src="C:\Workspace\Rholling ideas\teamProject\rhollEE\src\main\webapp\images\profile\empty present.png" width="100" height="100">
    </div>
  </section>
</body>