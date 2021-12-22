<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
	<link  href="../../css/mainpage/main_nav.css" rel="stylesheet" type="text/css" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="../../js/mainpage/index.js"></script>

	<script>
		$(function(){
			popSlide();
			endcomeSlide();
		});
	</script>
</head>

    <div class="menu1">
        <div class="menu1-logo" >
          <a href="#">
            <img src="<%=request.getContextPath()%>/images/mainpage/rholling.PNG" >
          </a>
        </div>
        <div class="menu1-addproject">
          <a href="#">
            프로젝트 올리기
          </a>
        </div>
        <div class="menu1-like">
          <a href="#">
            <img src="../../images/mainpage/like.png">
          </a>
        </div>
        <div class="menu1-aram">
          <a href="#">
            <img src="../../images/mainpage/aram.PNG">
          </a>
        </div>

        <div class="menu1-profile">
        <a href="#">
          <!-- 유저내임 들어가야함  -->
          프로필
        </a>
        </div>
        
    </div>


<nav role="navigation">
  <ul id="main-menu">
    <li class="cate"><a href="#">카테고리</a>
      <ul id="sub-menu">
        <li><a href="./nav5.html" aria-label="subemnu"><div class="all">전체</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="game">게임</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="show">공연</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="design">디자인</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="cartoon">만화</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="art">예술</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="crafts">공예</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="picture">사진</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="movie">영화 비디오</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="foods">푸드</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="music">음악</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="books">출판</div></a></li>
        <li><a href="#" aria-label="subemnu"><div class="fasion">패션</div></a></li>
      </ul>
    </li>
    <li><a href="#">홈</a> </li>
    <li><a href="#">인기</a></li>
    <li><a href="#">신규</a></li>
    <li><a href="#">마감임박</a></li>
    <li><a href="#">공개예정</a></li>
    <li class="search"><input type="text" placeholder="검색어를 입력하세요.." ><button>검색</button></li>
  </ul>
</nav>


<%//@include file="./all_cate.jsp" %>

<%@include file="./main_add.jsp" %>

<%@include file="./main_attention_projects.jsp" %>

<div class="ad2">메인광고2</div>

<div class="project-rap">
<!--  인기 프로젝트-->
<%@include file="./main_popular_projects.jsp" %>

<!--  곧 마감되는 프로젝트-->
<%@include file="./main_endcome_projects.jsp" %>

</div>
