<%@page import="com.team.project.vo.Project"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<% 
List<Project> endcomeList = (List)request.getAttribute("endcome");
%>
<link rel="stylesheet" type="text/css" href="/rhollEE/css/mainpage/main_endcome_projects.css">
    
<div class="fundingList endcome-project">
  <!-- 게시판 이름 -->
  <span class="listTitle">마감임박! 마지막 기회</span>
  <span class="leftTime">07:00:28</span>
  <button class="endcome-nextB"></button>
  <button class="endcome-backB"></button>
  <!-- 게시판 상태,달성률,추천 -->
  <!-- 현재 총 펀딩 게시물 수 -->

  <!-- 부모 랩퍼-->
  <div class="item-rapper">

      <!-- 자식랩퍼1 -->
      <div class="item-inrap1">

		<%
		if(!endcomeList.isEmpty()){
			for(Project p : endcomeList){
		%>
				  <!-- 글 -->
          <div class="item" >
              <!-- 사진 -->
                  <!--@@@ 사진클릭시 상품페이지로 -->
              <a href="">
              		<img class="item-image" src="/rhollEE/images/mainpage/<%=p.getProjectNo() %>.jpeg" alt="l">
              </a>
              <%if(p.isLoginedUserProjectInterest()) {%>
				  <button class="like" ></button>
              <%}else{ %>
				  <button class="not-like" ></button>
              <%}%>
              <!-- 정보 -->
              <div class="info">
                  <div class ="catelink">
					  <!--@@@ 카테고리 클릭시 카테고리 페이지로 -->
                      <span class="category"><a href=""><%=p.getCategory().getCategoryName() %></a></span>
                      <span class="category">|</span>
					  <!--@@@ Maker 클릭지 상품페이지로 -->
                      <span class="company"><a href=""><%=p.getMaker().getUserName()%></a></span>
                  </div>
                  <!-- (이름, 세부 카테, 설명)-->
                  
                  <!--@@@ 상품클릭시 상품페이지로 -->
                  <a href ="">
					  <span class="title"><%=p.getLongTitle() %></span>
				  </a>
                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="percent"><%= p.getAchiveRate()%>%달성</span>
                      <span class="leftDay"> 
                  </div>
              </div>
          </div>
          <%} 
				}%>


          <!-- 글 -->
          <div class="item" >
              <!-- 사진 -->
              <img class="item-image" src="/rhollEE/images/mainpage/1.jpeg" alt="l"><button class="not-like"></button>
              <!-- 정보 -->
              <div class="info">
                  <div class ="catelink">
                      <span class="category"><a href="">공예</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">오들리 파르메</a></span>
                  </div>
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">내손안의 작은바다<숨비와 파도의 반지></span>
                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="percent">2794% 달성</span>
                      <span class="leftDay"> 
                  </div>
              </div>
          </div>

          <div class="item" >
              <!-- 사진 -->
              <img class="item-image" src="/rhollEE/images/mainpage/1.jpeg" alt="l"><button class="not-like"></button>
              <!-- 정보 -->
              <div class="info">
                  <div class ="catelink">
                      <span class="category"><a href="">공예</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">오들리 파르메</a></span>
                  </div>
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">내손안의 작은바다<숨비와 파도의 반지></span>
                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="percent">2794% 달성</span>
                      <span class="leftDay"> 
                  </div>
              </div>
          </div>
          <div class="item" >
              <!-- 사진 -->
              <img class="item-image" src="/rhollEE/images/mainpage/1.jpeg" alt="l"><button class="not-like"></button>
              <!-- 정보 -->
              <div class="info">
                  <div class ="catelink">
                      <span class="category"><a href="">공예</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">오들리 파르메</a></span>
                  </div>
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">내손안의 작은바다<숨비와 파도의 반지></span>
                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="percent">2794% 달성</span>
                      <span class="leftDay"> 
                  </div>
              </div>
          </div>


          
          <div class="item" >
              <!-- 사진 -->
              <img class="item-image" src="/rhollEE/images/mainpage/1.jpeg" alt="l"><button class="not-like"></button>
              <!-- 정보 -->
              <div class="info">
                  <div class ="catelink">
                      <span class="category"><a href="">공예</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">오들리 파르메</a></span>
                  </div>
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">내손안의 작은바다<숨비와 파도의 반지></span>
                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="percent">2794% 달성</span>
                      <span class="leftDay"> 
                  </div>
              </div>
          </div>






          <div class="item" >
              <!-- 사진 -->
              <img  class="item-image" src="/rhollEE/images/mainpage/2.jpeg" alt="2"><button class="not-like"></button>
              <!-- 정보 -->
              <div class="info">
            <div class ="catelink">
                      <span class="category"><a href="">웹툰</a></span>
                      <span class="category">|</span>
                      <span class="company"><a href="">네이버웹툰</a></span>
                  </div>
                  <!-- (이름, 세부 카테, 설명)-->
                  <span class="title">2022년도 <냐한남자>와 함께하시오! 캘린더&다이어리!</span>
      
                  <!-- 가격 -->
                  <div class="priceAndPercent">
                      <span class="percent">436% 달성</span>
                  </div>
              </div>
          </div>

            <div class="item" >
                <!-- 사진 -->
                <img class="item-image" src="/rhollEE/images/mainpage/3.jpeg" alt="l"><button class="not-like"></button>
                <!-- 정보 -->
                <div class="info">
                    <div class ="catelink">
                        <span class="category"><a href="">요리책</a></span>
                        <span class="category">|</span>
                        <span class="company"><a href="">필라델피아 크림치즈</a></span>
                    </div>


                    <!-- (이름, 세부 카테, 설명)-->
                    <span class="title">제과 명장이 전하는 "필라델피아 크림치즈" 활용 아이디어!</span>
                                    <!-- 가격 -->
                    <div class="priceAndPercent">
                        <span class="percent">32% 달성</span>
    
                    </div>
                </div>
            </div>

      </div>
      <!-- 1end -->
  </div>
  <!-- 부모랩퍼 end -->
  <!-- 슬라이드 기능 구현해야함 광고+ 게시물+ 서버시간표시 -->
  </div>