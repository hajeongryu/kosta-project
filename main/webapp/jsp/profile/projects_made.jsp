<%@page import="com.team.project.vo.Project"%>
<%@page import="com.team.user.vo.Users"%>
<%@page import="com.team.order.vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
    <%List<Project> list = (List)request.getAttribute("list");
    int 심사중 = 0;
    int 반려 = 0;
    int 승인 = 0;
    int 중지 = 0;%>
    <!--프로세스 어떻게 넣는지 한 번 확인하기-->
   <span>
          <a href="followingist" class="follow">팔로잉 <%=following%></a>
   </span>
    <div class="buttons">	
			<button>관리</button>
			<button>삭제</button>               
			</div>    
</body>
</html>