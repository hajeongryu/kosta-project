<%@page import="com.team.user.vo.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.team.user.service.AddrService"%>
<%@page import="com.team.user.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css" >
	<link href="<%=request.getContextPath()%>/css/settings/settingsheader.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/settings/addressset.css" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/settings/addressset.js"></script>
<title>Rholling Ideas</title>
</head>

<%
Users u = (Users)session.getAttribute("loginInfo");
int userNo = u.getUserNo();
AddrService addrService = AddrService.getInstance();
List<Address> addrs = addrService.findByUserNo(userNo);
%>
<body>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="./settingsheader.jsp"/>
    
    <section class="settings_box">
		등록된 배송지
		<button id="address_add">추가</button>
<% 
if(addrs != null){
for(Address addr : addrs){
	String receiverName = addr.getReceiverName();
	int receiverZipcode = addr.getReceiverZipcode();
	String receiverAddress = addr.getReceiverAddress();
	String receiverAddressDetailed = addr.getReceiverAddressDetailed();
	String receiverPhone = addr.getReceiverPhone();
	String defaultAddress = addr.getDefaultAddress();
	String defaultAddressOX = "X";
	if(defaultAddress.equals("1")) {
		defaultAddressOX = "O";
	}
%>

	
		<div class="address_box">
			<%=receiverName%><br>
			[<%=receiverZipcode%>]
			<%=receiverAddress%>
			<%=receiverAddressDetailed%><br>
			<%=receiverPhone%><br>
			기본배송지여부 <%=defaultAddressOX%><br>
			<button id="address_default">기본결제수단으로 변경</button>
			<button id="address_modify">변경</button>
			<button id="address_remove">삭제</button>
		</div>

<%
}
}
%>    
    </section>
    
</body>
</html>