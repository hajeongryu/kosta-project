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
	<title>Rholling Ideas - 재미있는 펀딩의 시작!</title>

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
		배송지 추가
		<div class="address_box1">
			<form method="post" action="<%=request.getContextPath()%>/addressadd">
				<input type="text" value="<%=userNo%>" name="userNo" class="invisible">
				<span>이름</span> <input type="text" name="receiverName" required><br>
				<span>우편번호</span> <input type="text" name="receiverZipcode" required><br>
				<span>주소</span> <input type="text" name="receiverAddress" required><br>
				<span>상세주소</span> <input type="text" name="receiverAddressDetailed" required><br>
				<span>전화번호</span><input type="text" name="receiverPhone" required><br>
				기본배송지로 등록 <input type="checkbox" name="defaultAddress" checked>
				<button>추가</button>
			</form>
		</div>
		<hr>
		등록된 배송지
<% 
if(addrs != null){
for(Address addr : addrs){
	int addressNo = addr.getAddressNo();
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

	
		<div class="address_box2">
			<%=receiverName%><br>
			[<%=receiverZipcode%>]
			<%=receiverAddress%>
			<%=receiverAddressDetailed%><br>
			<%=receiverPhone%><br>
			기본배송지여부 <%=defaultAddressOX%><br>
			<button id="address_modify">변경</button>
			<form action="<%=request.getContextPath()%>/addrremove">
				<input type="text" class="invisible" name="addressNo" value="<%=addressNo%>">
				<button id="address_remove">삭제</button>
			</form>
		</div>

<%
}
}
%>    
    </section>
    
</body>
</html>