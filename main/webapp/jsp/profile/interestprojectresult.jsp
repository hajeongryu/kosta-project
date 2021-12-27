<%@page import="java.util.List"%>
<%@page import="com.team.user.vo.Interest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="../../css/header.css">
  <link rel="stylesheet" href="../../css/profile/interestproject.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="../../js/mainpage/index.js"></script>
  <script src="../menu.jsp"></script>
  
  <script src="../../js/profile/interestprojectresult.js"></script>
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
    <%List<Interest> list = (List)request.getAttribute("list");
    int i = 0;
    int a = 0;%>
    <div class="like-header">
      <div class="like-h1"><h1>관심 프로젝트</h1></div>
      <div class="like-select">
      <%-- <%for(Interest inter: list){
    	  String iora = inter.getInterestAlarm();
    	  if(iora == "I"){
    		  i++;
    	  }else if(iora == "A"){
    		  a++;
    	  }
      }%> --%>
        <span>
          <a href="interestlist" class="interest">좋아한 <%=i%></a>
        </span>
        <span>
          <a href="alarmlist">알림신청 <%=a%></a>
        </span>
      </div>
    </div>
    <div class="select-content">
      
    </div>
  </section>
</body>
