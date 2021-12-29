<%@page import="com.team.project.vo.Reward"%>
<%@page import="com.team.user.vo.Address"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.team.project.vo.Project"%>
<%@page import="com.team.order.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Rholling Ideas - 재미있는 펀딩의 시작!</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/profile/orderdetail.css">
</head>
<body>
  <header>
    <!-- 메뉴 -->
    <%@ include file="../menu.jsp" %>
  </header>

  <section>
    <!--본문-->
    <%Order o = (Order)request.getAttribute("order");
    Project p = o.getProject();
    Address a = o.getAddress();
    Reward r = o.getReward();
    DecimalFormat formatter= new DecimalFormat("###,###");%>
    <div class="project-container">
      <div class="project-img">
        <a href="/rhollEE/projectdetail?projectNo=<%=p.getProjectUrl()%>">
          <img src="<%=request.getContextPath()%>/<%=o.getProject().getProjectImage()%>">
        </a>
      </div>
      <div class="project-text">
        <div class="cate-maker"><%=p.getCategory().getCategoryName() %> | <%=p.getMaker().getUserName() %></div>
        <div class="longtitle">
          <a href="/rhollEE/projectdetail?projectNo=<%=p.getProjectUrl()%>">
            <%=o.getProject().getLongTitle() %>
          </a>
        </div>
        <div>
          <span class="sumprice"><%=formatter.format(p.getProjectChange().getSumPrice())%>원</span>
          <span class="rate"><%=p.getAchiveRate()%>%</span>
          <span class="payresult">· <%=o.getPaymentResult() %></span>
        </div>
        <a href="" class="message">
         창작자에게 문의
      	</a>
      </div>
    </div>
    
    <div class="orderinfo-container">
      <div class="orderinfo-title"><p>후원 정보</p></div>
      <div class="orderinfo">
        <table>
          <tr>
            <th>후원 날짜</th>
            <td><%=o.getPaymentDate()%></td>
          </tr>
          <tr>
            <th>후원 번호</th>
            <td><%=o.getPaymentNo()%></td>
          </tr>
          <tr>
            <th>펀딩 마감일</th>
            <td><%=p.getEndDate()%></td>
          </tr>
        </table>
      </div>

      <div class="orderinfo-title"><p>선물 정보</p></div>
      <div class="orderinfo">
        <table>
          <tr>
            <th>선물 구성</th>
            <td><%if(r.getRewardName() != null){%>
            	<%=r.getRewardName()%>
            	<%} 
            	if(r.getItemName() != null) {%>
            	<ul class="item"><li><%=r.getItemName()%></li></ul>
            	<%}%>
            </td>
          </tr>
          <tr>
            <th>후원 금액</th>
            <td><%=o.getTotalPrice()%>원</td>
          </tr>
          <tr>
            <th>전달 상태</th>
            <td><%if(r.getDeliverSelect().equals("1")){
            		if(!o.getPaymentResult().equals("펀딩실패")){%>
            			<%-- <%=r.getDeliverDate()%> --%> 배송 예정
            		<%}%>
            	<%}else{ %>
            		미배송 상품
            	<%} %>
            </td>
          </tr>
        </table>
      </div>

      <div class="orderinfo-title"><p>결제 정보</p></div>
      <div class="orderinfo">
        <table>
          <tr>
            <th>결제 수단</th>
            <td><%=o.getCard().getCardNum()%></td>
          </tr>
          <tr>
            <th>결제 금액</th>
            <td><%=o.getTotalPrice()%>원</td>
          </tr>
          <tr>
            <th>결제 상태</th>
            <td><%=o.getPaymentResult()%></td>
          </tr>
        </table>
      </div>

      <div class="orderinfo-title"><p>배송 정보</p></div>
      <div class="orderinfo">
        <table>
          <tr>
            <th>받는 사람</th>
            <td><%=a.getReceiverName()%></td>
          </tr>
          <tr>
            <th>연락처</th>
            <td><%=a.getReceiverPhone()%></td>
          </tr>
          <tr>
            <th>주소</th>
            <td>(<%=a.getReceiverZipcode()%>) <%=a.getReceiverAddress()%> <%=a.getReceiverAddressDetailed()%></td>
          </tr>
        </table>
      </div>
      
      <button type="button" class="orderlistpage" onclick="location.href='<%=request.getContextPath()%>/orderlist'">후원목록 보기</button>
      
    </div>
  </section>
</body>
</html>