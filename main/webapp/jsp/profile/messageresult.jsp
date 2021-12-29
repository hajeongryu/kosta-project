<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Rholling Ideas - 재미있는 펀딩의 시작!</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/interestproject.css">
</head>
<body>
  <header>
    <!-- 메뉴 -->
    <%@ include file="../menu.jsp" %>
  </header>

  <section>
    <!--본문-->
      <div class="interest-header">
        <div class="interest-h1"><h1>메시지</h1></div>
        <div class="interest-select">
          <span class="selected-span">
            <a href="<%=request.getContextPath()%>/jsp/profile/messageresult.jsp" class="selected-a" style="color: black;">보낸 메시지</a>
          </span>
          <span>
            <a href="<%=request.getContextPath()%>/jsp/profile/messageresult.jsp">받은 메시지</a>
          </span>
        </div>
      </div>
      <div class="select-content">
	    <br><br>
      <div class="no-content">
        <img src="<%=request.getContextPath()%>/images/profile/message.png">
        <div>새로운 메시지가 없습니다.</div>
      </div>
	  </div>
  </section>
</body>
</html>