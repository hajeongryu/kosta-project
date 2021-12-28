<%@page import="java.util.ArrayList"%>
<%@page import="com.team.user.vo.Users"%>
<%@page import="com.team.order.vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	List<Users> savantList = (List) request.getAttribute("savantList");
	List<Users> masterList = (List) request.getAttribute("masterList");
	
	if(savantList == null){
		savantList = new ArrayList<>();
	}
	if(masterList == null){
		masterList= new ArrayList<>();
	}
%>
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
    <div class="like-header">
      <div class="like-h1"><h1>팔로우</h1></div>
      <div class="like-select">
      	<%-- <%for(Users user: list){
    	  String following = user.getFollowing();
    	  String follower = user.getFollower();
    	  if(following == 0 ){
    		  팔로잉한 사용자가 없습니다.
        <%}
        else{%>후원성공(<%=list.size()%>)<%}%> --%>
        <span>
          <a href="followingist" class="follow">팔로잉 <%=masterList.size()%></a>
        </span>
        <span>
          <a href="followerlist">팔로워 <%=savantList.size()%></a>
        </span>
      </div>
    </div>
    <div class="select-content">
      
    </div>
  </section>
</body>