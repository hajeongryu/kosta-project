<%@page import="com.team.project.vo.Project"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.team.user.vo.Interest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/interestproject.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/orderproject.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
    <%@ include file="../menu.jsp" %>
  </header>

  <section>
    <!--본문-->
    <div class="interest-header">
      <div class="interest-h1"><h1>후원현황</h1></div>
    </div>
    <div class="order-list">
      <div class="order-cnt-search">
        <div class="order-cnt">
          <span>1</span>건의 후원 내역이 있습니다.
        </div>
        <div class="order-search">
          <!-- <img src="/images/mainpage/search2.png"> -->
          <input type="search" placeholder="프로젝트, 선물, 창작자를 검색하세요" class="search-input" name="keyword" value="" autocomplete="off">
        </div>
        
      </div>
    </div>
  </section>
</body>
