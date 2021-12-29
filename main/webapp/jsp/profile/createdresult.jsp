<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Rholling Ideas - 재미있는 펀딩의 시작!</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/interestproject.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/orderproject.css">
</head>
<body>
  <header>
    <!-- 메뉴 -->
    <%@ include file="../menu.jsp" %>
  </header>

  <section>
    <!--본문-->
     <div class="interest-header">
      <div class="interest-h1"><h1>내가 만든 프로젝트</h1></div>
    </div>
    <div class="select-content">
        <br><br>
        <div class="no-content">
          <img src="<%=request.getContextPath()%>/images/profile/empty created.png">
          <div>작성한 프로젝트가 없습니다.</div>
        </div>
      </div>
  </section>
</body>
</html>