<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.team.project.vo.Project"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link  href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css" >
	<link  href="<%=request.getContextPath()%>/css/discover/all_cate.css" rel="stylesheet" type="text/css" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/mainpage/index.js"></script>
  <script src="<%=request.getContextPath()%>/jsp/menu.jsp"></script>
<%
	List<Project> discoverList = (List)request.getAttribute("discoverList");
%>
<%@ include file="../menu.jsp" %>
<meta charset="UTF-8">
<title>재미있는 펀딩의 시작! Rholling IDEAS</title>
</head>
<body>


<!-- 펀딩리리스트 -->
<div class="fundingList" style="width: 1100px;">
  <!-- 게시판 이름 -->
  <span class="listTitle">전체</span>
  <!-- 게시판 상태,달성률,추천 -->
  <div class="listInfo">
      <button class="status"></button>
      <button class="achiev"></button>
      <button class="recommend"></button>
  </div>
  <!-- 현재 총 펀딩 게시물 수 -->
  <div class="listLength">
      <div>
      <span class="fundcount">33,577</span>
      개의 프로젝트가 있습니다.
      </div>
      <button class="orderBy"></button>
  </div>

  <!-- 부모 랩퍼-->
  <div class="item-rapper">

      <!-- 자식랩퍼1 -->
      <div class="item-inrap1">


<%
	for(Project p : discoverList){
		
%>


     <!-- 글 -->
          <div class="item" >
              <!-- 사진 -->
				<img class="item-image" src="/rhollEE/images/mainpage/<%=p.getProjectNo() %>.jpeg" alt="l"><button class="like"></button>
              <!-- 정보 -->
              <div class="info">
                  <!-- (이름, 세부 카테, 설명)-->
				  <span class="title"><%=p.getLongTitle() %></span>
                  <div class ="catelink">
					  <!--@@@ 카테고리 클릭시 카테고리 페이지로 -->
					 <span class="category"><a href=""><%=p.getCategory().getCategoryName() %></a></span>
                      <span class="category">|</span>
					  <!--@@@ Maker 클릭지 상품페이지로 -->
                      <span class="company"><a href=""><%=p.getMaker().getUserName()%></a></span>
           
                  </div>
                  <span class="iteminfo"><%=p.getProjectBrief() %></span>

                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="price"><%=p.getProjectChange().getSumPrice() %>원</span>
                      <span class="percent"><%=p.getAchiveRate()%>%</span>
                      <span class="leftDay"> 
                          <img src="/rhollEE/images/mainpage/time.PNG">
                          <%=p.getEndDate()%>일 남음
                      </span>
                  </div>
              </div>
          </div>





<% }%>

          <!-- 글 -->
          <div class="item" >
              <!-- 사진 -->
              <img class="item-image" src="/rhollEE/images/mainpage/1.jpeg" alt="l"><button class="like"></button>
              <!-- 정보 -->
              <div class="info">
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">내손안의 작은바다<숨비와 파도의 반지></span>
                  <div class ="catelink">
                      <span class="category"><a href="">공예</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">오들리 파르메</a></span>
                  </div>
                  <span class="iteminfo">오들리 파르페의 찬연한 바다 3종. 숨비 오브젝트와 문진, 파도 반지.</span>

                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="price">13,971,000원</span>
                      <span class="percent">2794%</span>
                      <span class="leftDay"> 
                          <img src="/rhollEE/images/mainpage/time.PNG">
                          44일 남음 
                      </span>
                  </div>
              </div>
          </div>

          <div class="item" >
              <!-- 사진 -->
              <img  class="item-image" src="/rhollEE/images/mainpage/2.jpeg" alt="2"><button class="like"></button>
              <!-- 정보 -->
              <div class="info">
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">2022년도 <냐한남자>와 함께하시오! 캘린더&다이어리!</span>
                  <div class ="catelink">
                      <span class="category"><a href="">웹툰</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">네이버웹툰</a></span>
                  </div>
                  <span class="iteminfo">귀여운건 못참지! 2022년에도 네이버웹툰 냐한남자 함께 캘린더,다이어리,스티커,스마트톡</span>
                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="price">43,693,750원</span>
                      <span class="percent">436%</span>
                      <span class="leftDay"> 
                          <img src="/rhollEE/images/mainpage/time.PNG">
                          22일 남음 
                      </span>
                  </div>
              </div>
          </div>

          <div class="item" >
              <!-- 사진 -->
              <img class="item-image" src="/rhollEE/images/mainpage/3.jpeg" alt="l"><button class="like"></button>
              <!-- 정보 -->
              <div class="info">
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">제과 명장이 전하는 "필라델피아 크림치즈" 활용 아이디어!</span>
                  <div class ="catelink">
                      <span class="category"><a href="">요리책</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">필라델피아 크림치즈</a></span>
                  </div>
                  <span class="iteminfo">최고의 베이킹 파트너 필라델피아 크림치즈와 함께 당신의 베이킹에 풍미를 더해보세요!</span>

                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="price">1,789,300원</span>
                      <span class="percent">32%</span>
                      <span class="leftDay"> 
                          <img src="/rhollEE/images/mainpage/time.PNG">
                          27일 남음 
                      </span>
                  </div>
              </div>
          </div>

          <div class="item" >
              <!-- 사진 -->
              <img class="item-image" src="/rhollEE/images/mainpage/4.jpeg" alt="l"><button class="like"></button>
              <!-- 정보 -->
              <div class="info">
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">500가지 기호와 상징&lt;SYMBOLS&gt;심볼 사전</span>
                  <div class ="catelink">
                      <span class="category"><a href="">번역</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">디제이 아이북스</a></span>
                  </div>
                  <span class="iteminfo">수천 년의 인류 역사에 걸쳐 500개가 넘는 기호, 상징 고대 천문학부터 마법 악마학까지</span>

                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="price"> 59,868,400원</span>
                      <span class="percent">399%</span>
                      <span class="leftDay"> 
                          <img src="/rhollEE/images/mainpage/time.PNG">
                          48일 남음 
                      </span>
                  </div>
              </div>
          </div>
          <div class="item">
              <!-- 사진 -->
              <img class="item-image" src="/rhollEE/images/mainpage/5.jpeg" alt="l"><button class="like"></button>
              <!-- 정보 -->
              <div class="info">
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">조연은 그만. 오늘은 내가 주인공 할게요 <안개꽃 향수></span>
                  <div class ="catelink">
                      <span class="category"><a href="">조향</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">동네꽃집</a></span>
                  </div>
                  <span class="iteminfo">작고 평범한 존재가 만들어낸 기적, 하늘의 빛깔을 담아낸 안개꽃</span>

                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="price">14,037,000원</span>
                      <span class="percent">3857%</span>
                      <span class="leftDay"> 
                          <img src="/rhollEE/images/mainpage/time.PNG">
                          68일 남음 
                      </span>

                  </div>
              </div>

          </div>
           <div class="item">
              <!-- 사진 -->
              <img  class="item-image" src="/rhollEE/images/mainpage/6.jpeg" alt="l"><button class="like"></button>
              <!-- 정보 -->
              <div class="info">
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">달콤한 연말을 위해, 요나폿의 크리스마스 디저트 박스</span>
                  <div class ="catelink">
                      <span class="category"><a href="">베이킹 · 디저트</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">요나폿</a></span>
                  </div>
                  <span class="iteminfo">스튜디오 요나폿에서 준비한 크리스마스 디저트 박스</span>

                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="price">7,227,000원</span>
                      <span class="percent">1445%</span>
                      <span class="leftDay"> 
                          <img src="/rhollEE/images/mainpage/time.PNG">
                          15일 남음 
                      </span>

                  </div>
              </div>

          </div>               
  


      </div>
      <!-- 1end -->


      
  </div>
  <!-- 부모랩퍼 end -->
</div>




</body>
</html>