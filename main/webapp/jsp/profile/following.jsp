<%@page import="com.team.user.service.FollowService"%>
<%@page import="com.team.project.service.ProjectService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.team.user.vo.Users"%>
<%@page import="com.team.order.vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    <%List<Users> savantList = (List)request.getAttribute("savantList");
	List<Users> masterList = (List)request.getAttribute("masterList");
	if(savantList == null){
		savantList = new ArrayList<>();
	}
	if(masterList == null){
		masterList= new ArrayList<>();
	}
  	int savantCnt = 0;
  			if((Integer)request.getAttribute("savantCnt") != null){
  				savantCnt = (Integer)request.getAttribute("savantCnt");
  			}
  	int masterCnt = 0; 
			if((Integer)request.getAttribute("masterCnt") != null){
				masterCnt = (Integer)request.getAttribute("masterCnt");
			}
  	ProjectService service = ProjectService.getInstance();
  	FollowService followService = FollowService.getInstace();
  	
  	%>
    <div class="like-header">
      <div class="like-h1"><h1>팔로우</h1></div>
      <div class="like-select"></div>
				<span class="selected-span">
					<a href="follower" class="selected-a" style="color: black;">팔로워 <%=savantCnt%></a>
				</span>
				<span>
          <a href="following">팔로잉 <%=masterCnt%></a>
        </span>
			</div>

    <div class="select-content">
		<br><br>
    <%if(masterList.size()==0) {%>
    	<div class="no-content">
				<img src="<%=request.getContextPath()%>/images/profile/empty follower.png">
      <div>아직 팔로잉한 유저가 없습니다.</div>
    </div>
    <% } %>
      <%
      if(masterList.size() != 0){
    	  for(Users u: masterList){
		  int userNo = u.getUserNo();
    	  String userImage = u.getUserImage();
    	  String userName = u.getUserName();
    	  String userIntroduction = u.getUserIntroduction();
    	  int mastetCnt2 = followService.getMaster(u.getUserNo()).size();
    	  int projectsmadeCnt = service.findByUserNo("u.getUserNo()").size();
    	  %>
    	  
    	  <div class="following_box">
					<div class="image">
	    	  	<img src="<%=request.getContextPath()%>/files/user_image/default.png">
					</div>
					<div class="lower_text">
	    	  			<span><%=userName %></span><br>
						<span><%=userIntroduction %></span><br>
					</div>
					<div class="lower_cnt">
	    	  	팔로워<span><%=savantCnt %></span><br>
	    	  	올린 프로젝트<span><%=projectsmadeCnt %></span><br>
					</div>		
						<div class="button">
							<form action="<%=request.getContextPath()%>/removefollow"> <!-- 서블릿구현해야함-->
								<input type="text" class="invisible" value="<%=userNo%>" name="userNo">
								<button><h4>-팔로잉</h4></button>
							</form>
						</div>
    	  </div>
      	%>
    <% } %>
    <% } %> 
    </div>
  </section>
</body>