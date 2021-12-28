<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
	<h1>설정</h1>
	<ul class="settings_list">
	    <li><a href="<%=request.getContextPath()%>/jsp/settings/profileset.jsp">프로필</a></li>
	    <li><a href="<%=request.getContextPath()%>/jsp/settings/accountset.jsp">계정</a></li>
	    <li><a href="<%=request.getContextPath()%>/jsp/settings/paymentset.jsp">결제수단</a></li>
	    <li><a href="<%=request.getContextPath()%>/jsp/settings/addressset.jsp">배송지</a></li>
	</ul>
</section>
