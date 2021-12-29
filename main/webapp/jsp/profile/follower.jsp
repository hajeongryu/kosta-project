<%@page import="java.util.ArrayList"%>
<%@page import="com.team.user.vo.Users"%>
<%@page import="com.team.order.vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<Users> savantList = (List) request.getAttribute("savantList");
	List<Users> masterList = (List) request.getAttribute("masterList");
	if(savantList == null){
		savantList = new ArrayList<>();
	}
	if(masterList == null){
		masterList= new ArrayList<>();
	}
  int savantListCnt = (int)request.getAttribute("savantListCnt");
  Users u = null;%>

<!DOCTYPE html>
<head>
  <title>Rholling Ideas - 재미있는 펀딩의 시작!</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/interestproject.css">
  <script src="<%=request.getContextPath()%>/jsp/menu.jsp"></script>

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
      <div class="like-h1"><h1>팔로워</h1></div>
      <div class="like-select"></div>
    	<div class="no-content">
    <%if(list.size()==0) {%>
			<img src="<%=request.getContextPath()%>/images/profile/empty follower.png">
      <div>아직 팔로워가 없습니다.</div>
      </div>
    <% } %>
      <%for(Users u: savantList){
      savantList = u.getAttribute();%> 
    </div>
  </section>
</body>