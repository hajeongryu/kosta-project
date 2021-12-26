<%@page import="com.team.project.dao.CommunityDAOOracle"%>
<%@page import="com.team.project.vo.Community"%>
<%@page import="com.team.project.vo.Comments"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
	<link  href="../../css/header.css" rel="stylesheet" type="text/css" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="../../js/mainpage/index.js"></script>
  <script src="../menu.jsp"></script>
</head>

<body>
  <header>
    <!-- 메뉴 -->
    <jsp:include page="../menu.jsp"/>
  </header>

  <section>
    <!--본문-->
    
    <%@include file="./detail_head.jsp" %>
        
    <div class="project-rap">
      내용
    </div>
    
    <div class="community">
    <button>커뮤티니</button>
    <%@include file="./post.jsp" %>
    </div>
  </section>
</body>
