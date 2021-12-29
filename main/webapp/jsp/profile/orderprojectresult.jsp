<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.team.order.vo.Order"%>
<%@page import="com.team.project.vo.Project"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/interestproject.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/orderproject.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
    <%@ include file="../menu.jsp" %>
  </header>

  <section>
    <!--본문-->
    <%List<Order> fail = (List)request.getAttribute("fail");
    List<Order> ongoing = (List)request.getAttribute("ongoing");
    List<Order> success = (List)request.getAttribute("success");
    List<Order> payed = (List)request.getAttribute("payed");
    int orderCnt = (int)request.getAttribute("orderCnt");
    
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    Calendar del = Calendar.getInstance();
    %>
    <div class="interest-header">
      <div class="interest-h1"><h1>후원현황</h1></div>
    </div>
    <div class="order-list">
      <div class="order-cnt-search">
        <div class="order-cnt">
          <span><%=orderCnt %></span>건의 후원 내역이 있습니다.
        </div>
        <div class="order-search">
          <div><img src="<%=request.getContextPath()%>/images/mainpage/search2.png"></div>
          <input type="search" placeholder="프로젝트, 선물, 창작자를 검색하세요" class="search-input" name="keyword" value="" autocomplete="off">
        </div>
      </div>
      <%if(orderCnt == 0) {%>
      <div class="noorder-content">
        <br><br>
        <div class="no-content">
          <img src="<%=request.getContextPath()%>/images/profile/empty present.png">
          <div>후원한 프로젝트가 없습니다.</div>
        </div>
      </div>
      <%} else {%>
      
      <!-- 펀딩 실패 내역 -->
      <div class="order-content">
        <%if(fail.size() != 0){%>
        <div class="order">
          <div class="payment-cont">
            <span class="paymentresult">펀딩 실패</span>
            (<%=fail.size()%>)
          </div>
          <%for(Order o: fail){ %>
          <div class="each-order-content">
            <div class="order-img">
              <a href="/rhollEE/orderdetail?paymentNo=<%=o.getPaymentNo()%>">
                <img src="<%=request.getContextPath()%>/<%=o.getProject().getProjectImage()%>">
              </a>
            </div>
            <div class="order-text">
              <div class="date-payno">후원날짜 <%=o.getPaymentDate() %> | 후원번호 <%=o.getPaymentNo() %></div>
              <div class="longtitle">
                <a href="/rhollEE/orderdetail?paymentNo=<%=o.getPaymentNo()%>">
                  <%=o.getProject().getLongTitle() %>
                </a>
              </div>
              <div class="deliverselect"><%if(o.getReward().getDeliverSelect().equals("1")){ %>
                무료배송
              	<%}else{ %>
              	미배송상품
              	<%} %>
              </div>
              <div class="reward-item">
                <div>
                <%if(o.getReward().getRewardName() != null){%>
                    <%=o.getReward().getRewardName() %>
                <%} %>
                </div>
              <%if(o.getReward().getItemName() != null){ %>
                <ul>
                  <li><%=o.getReward().getItemName() %></li>
                </ul>
              <%} %>
              </div>
            </div>
          </div>
          <%} %>
        </div>
        <%}%>
        
        <!-- 진행중 내역 -->
        <%if(ongoing.size() != 0){%>
        <div class="order">
          <div class="payment-cont">
            <span class="paymentresult">진행중</span>
            (<%=ongoing.size()%>)
          </div>
          <%for(Order o: ongoing){ 
        	  cal.setTime(o.getProject().getEndDate());
        	  cal.add(Calendar.DATE, 1);
        	  del.setTime(o.getProject().getEndDate());
        	  del.add(Calendar.DATE, o.getReward().getDeliverDate());%>
          <div class="each-order-content">
            <div class="order-img">
              <a href="/rhollEE/orderdetail?paymentNo=<%=o.getPaymentNo()%>">
                <img src="<%=request.getContextPath()%>/<%=o.getProject().getProjectImage()%>">
              </a>
            </div>
            <div class="order-text">
              <div class="date-payno">결제예정일 <%=df.format(cal.getTime()) %> | 후원번호 <%=o.getPaymentNo() %></div>
              <div class="longtitle">
                <a href="/rhollEE/orderdetail?paymentNo=<%=o.getPaymentNo()%>">
                  <%=o.getProject().getLongTitle() %>
                </a>
              </div>
              <div class="deliverselect"><%if(o.getReward().getDeliverSelect().equals("1")){ %>
                무료배송
              	<%}else{ %>
              	미배송상품
              	<%} %>
              </div>
              <div class="reward-item">
                <div>
                <%if(o.getReward().getRewardName() != null){%>
                    <%=o.getReward().getRewardName() %>
                <%} %>
                </div>
              <%if(o.getReward().getItemName() != null){ %>
                <ul>
                  <li><%=o.getReward().getItemName() %></li>
                </ul>
              <%} %>
              </div>
              <%if(o.getReward().getDeliverSelect().equals("1")){%>
              <div class="deliverdate">선물 전달 예정일 <%=df.format(del.getTime()) %></div>
              <%} %>
              <div class="totalprice"><%=o.getTotalPrice()%>원 결제 예정 </div>
            </div>
          </div>
          <%} %>
        </div>
        <%}
        if(success.size() != 0){%>
        
        <!-- 펀딩 성공 내역 -->
        <div class="order">
        <%for(Order o: success){  
        	  cal.setTime(o.getProject().getEndDate());
        	  cal.add(Calendar.DATE, 1);
        	  del.setTime(o.getProject().getEndDate());
        	  del.add(Calendar.DATE, o.getReward().getDeliverDate());%>
          <div class="payment-cont">
            <span class="paymentresult">펀딩 성공</span>
            (<%=success.size()%>)
          </div>
          <div class="each-order-content">
            <div class="order-img">
              <a href="/rhollEE/orderdetail?paymentNo=<%=o.getPaymentNo()%>">
                <img src="<%=request.getContextPath()%>/<%=o.getProject().getProjectImage()%>">
              </a>
            </div>
            <div class="order-text">
              <div class="date-payno">결제예정일 <%=df.format(cal.getTime()) %> | 후원번호 <%=o.getPaymentNo() %></div>
              <div class="longtitle">
                <a href="/rhollEE/orderdetail?paymentNo=<%=o.getPaymentNo()%>">
                  <%=o.getProject().getLongTitle() %>
                </a>
              </div>
              <div class="deliverselect"><%if(o.getReward().getDeliverSelect().equals("1")){ %>
                무료배송
              	<%}else{ %>
              	미배송상품
              	<%} %>
              </div>
              <div class="reward-item">
                <div>
                <%if(o.getReward().getRewardName() != null){%>
                    <%=o.getReward().getRewardName() %>
                <%} %>
                </div>
              <%if(o.getReward().getItemName() != null){ %>
                <ul>
                  <li><%=o.getReward().getItemName() %></li>
                </ul>
              <%} %>
              </div>
              <%if(o.getReward().getDeliverSelect().equals("1")){%>
              <div class="deliverdate">선물 전달 예정일 <%=df.format(del.getTime()) %></div>
              <%} %>
              <div class="totalprice"><%=o.getTotalPrice()%>원 결제 예정 </div>
            </div>
          </div>
          <%} %>
        </div>
        <%}
        if(payed.size() != 0){%>
        
        <!-- 결제 완료 내역 -->
        <div class="order">
        <%for(Order o: payed){  
        	  cal.setTime(o.getProject().getEndDate());
        	  cal.add(Calendar.DATE, 1);
        	  del.setTime(o.getProject().getEndDate());
        	  del.add(Calendar.DATE, o.getReward().getDeliverDate());%>
          <div class="payment-cont">
            <span class="paymentresult">결제 완료</span>
            (<%=payed.size()%>)
          </div>
          <div class="each-order-content">
            <div class="order-img">
              <a href="/rhollEE/orderdetail?paymentNo=<%=o.getPaymentNo()%>">
                <img src="<%=request.getContextPath()%>/<%=o.getProject().getProjectImage()%>">
              </a>
            </div>
            <div class="order-text">
              <div class="date-payno">결제완료일 <%=df.format(cal.getTime()) %> | 후원번호 <%=o.getPaymentNo() %></div>
              <div class="longtitle">
                <a href="/rhollEE/orderdetail?paymentNo=<%=o.getPaymentNo()%>">
                  <%=o.getProject().getLongTitle() %>
                </a>
              </div>
              <div class="deliverselect"><%if(o.getReward().getDeliverSelect().equals("1")){ %>
                무료배송
              	<%}else{ %>
              	미배송상품
              	<%} %>
              </div>
              <div class="reward-item">
                <div>
                <%if(o.getReward().getRewardName() != null){%>
                    <%=o.getReward().getRewardName() %>
                <%} %>
                </div>
              <%if(o.getReward().getItemName() != null){ %>
                <ul>
                  <li><%=o.getReward().getItemName() %></li>
                </ul>
              <%} %>
              </div>
              <%if(o.getReward().getDeliverSelect().equals("1")){%>
              <div class="deliverdate">선물 전달 예정일 <%=df.format(del.getTime()) %></div>
              <%} %>
              <div class="totalprice"><%=o.getTotalPrice()%>원 결제 완료 </div>
            </div>
          </div>
          <%} %>
        </div>
        <%}%>
      <%}%>
      </div>
    </div>
  </section>
</body>
