<%@page import="java.util.ArrayList"%>
<%@page import="com.team.project.vo.Project"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
List<Project> releaseList = (List)request.getAttribute("release");
if(releaseList == null){
	releaseList = new ArrayList<>();
}

%>
<link rel="stylesheet" type="text/css" href="/rhollEE/css/mainpage/main_release_projects.css">
    
<div class="fundingList release-project">
  <!-- 게시판 이름 -->
  <span class="listTitle">공개예정 프로젝트</span>
  <button class="release-nextB"></button>
  <button class="release-backB"></button>
  <!-- 게시판 상태,달성률,추천 -->
  <!-- 현재 총 펀딩 게시물 수 -->

  <!-- 부모 랩퍼-->
  <div class="item-rapper">

      <!-- 자식랩퍼1 -->
      <div class="item-inrap3">


		<%
		if(!(releaseList.isEmpty() && releaseList != null)){
			for(Project p : releaseList){
		%>
				  <!-- 글 -->
          <div class="item" >
              <!-- 사진 -->
                  <!--@@@ 사진클릭시 상품페이지로 -->
              <a href="/rhollEE/projectdetail?projectNo=<%=p.getProjectNo()%>">
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
                  <a href ="/rhollEE/projectdetail?projectNo=<%=p.getProjectNo()%>">
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
      </div>
      <!-- 1end -->
  </div>
  <!-- 부모랩퍼 end -->
  <!-- 슬라이드 기능 구현해야함 광고+ 게시물+ 서버시간표시 -->
</div>