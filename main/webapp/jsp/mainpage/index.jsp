<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
	<link  href="css/header.css" rel="stylesheet" type="text/css" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/mainpage/index.js"></script>
  <script src="jsp/menu.jsp"></script>
</head>
<script>
    $(function(){
        popSlide();
        endcomeSlide();
    });
</script>
<body>
  <header>
    <!-- 메뉴 -->
    <!--  jsp:include page="../menu.jsp"/ -->
  </header>

  <section>
    <!--본문-->
    <%//@include file="./all_cate.jsp" %>
    
    <%@include file="./main_add.jsp" %>
    
    <!-- 주목할만한 프로젝트 -->
    <%@include file="./main_attention_projects.jsp" %>
    
    <div class="ad2">메인광고2</div>
    
    <div class="project-rap">
      <!--  인기 프로젝트-->
      <%@include file="./main_popular_projects.jsp" %>
      
      <!--  곧 마감되는 프로젝트-->
      <%@include file="./main_endcome_projects.jsp" %>
      
      <!-- 공개예정 프로젝트 -->
      <%@include file="./main_release_projects.jsp" %>
      
      <!-- 신규 프로젝트 -->
      <%@include file="./main_new_projects.jsp" %>
    </div>
  </section>
</body>
