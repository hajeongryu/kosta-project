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
	<script>
	$(function(){
		// 모달 열기
		function modalOpen() {
		    document.querySelector('.modal_wrap').style.display = 'block';
		    document.querySelector('.modal_background').style.display = 'block';
		}

		// 모달 끄기
		function modalClose() {
		    document.querySelector('.modal_wrap').style.display = 'none';
		    document.querySelector('.modal_background').style.display = 'none';
		}

		//버튼 클릭리스너 달기
		document.querySelector('#modal_btn').addEventListener('click', modalOpen);
		document.querySelector('.modal_close').addEventListener('click', modalClose);
	});
	</script>
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
		<div class="settings_subtitle">배송지 추가</div>
		<div class="address_box">
			<form method="post" action="<%=request.getContextPath()%>/addressadd" class="submit_wrap">
				<input type="text" value="<%=userNo%>" name="userNo" class="invisible">
				<span class="address_value_name">이름</span> <input type="text" name="receiverName" size="40" required><br>
				<span class="address_value_name">우편번호</span> <input type="text" name="receiverZipcode" size="40" required><br>
				<span class="address_value_name">주소</span> <input type="text" name="receiverAddress" size="40" required><br>
				<span class="address_value_name">상세주소</span> <input type="text" name="receiverAddressDetailed" size="40" required><br>
				<span class="address_value_name">전화번호</span> <input type="text" name="receiverPhone" size="40" required><br>
				기본배송지로 등록 <input type="checkbox" name="defaultAddress" checked>
				<button>추가</button>
			</form>
		</div>
		<hr>
		<div class="settings_subtitle">등록된 배송지</div>
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
	String defaultChk = "";
	if(defaultAddress.equals("1")) {
		defaultAddressOX = "O";
		defaultChk = "checked";
	}

	
%>

	
		<div class="address_box">
			<form method="post" action="<%=request.getContextPath()%>/addrmodify">
				<span class="address_value_name">이름</span> <input type="text" name="receiverName" value="<%=receiverName%>" size="40" required><br>
				<span class="address_value_name">우편번호</span> <input type="text" name="receiverZipcode" value="<%=receiverZipcode%>" size="40" required><br>
				<span class="address_value_name">주소</span> <input type="text" name="receiverAddress" value="<%=receiverAddress%>" size="40" required><br>
				<span class="address_value_name">상세주소</span> <input type="text" name="receiverAddressDetailed" value="<%=receiverAddressDetailed%>" size="40" required><br>
				<span class="address_value_name">전화번호</span> <input type="text" name="receiverPhone" value="<%=receiverPhone%>" size="40" required><br>
				<span id="default_value">기본배송지여부</span> <%=defaultAddressOX%><br>
				<input type="text" class="invisible" name="addressNo" value="<%=addressNo%>">
				<input type="text" class="invisible" name="defaultAddress" value="<%=defaultAddress%>">
				<input type="text" class="invisible" name="userNo" value="<%=userNo%>">
				<button>수정</button>
			</form>
			<form method="post" action="<%=request.getContextPath()%>/addrdefault">
				<input type="text" class="invisible" name="receiverName" value="<%=receiverName%>">
				<input type="text" class="invisible" name="receiverZipcode" value="<%=receiverZipcode%>">
				<input type="text" class="invisible" name="receiverAddress" value="<%=receiverAddress%>">
				<input type="text" class="invisible" name="receiverAddressDetailed" value="<%=receiverAddressDetailed%>">
				<input type="text" class="invisible" name="receiverPhone" value="<%=receiverPhone%>">
				<input type="text" class="invisible" name="addressNo" value="<%=addressNo%>">
				<input type="text" class="invisible" name="defaultAddress" value="<%=defaultAddress%>">
				<input type="text" class="invisible" name="userNo" value="<%=userNo%>">
				<button>기본배송지로 변경</button>
			</form>
			<form action="<%=request.getContextPath()%>/addrremove">
				<input type="text" class="invisible" name="addressNo" value="<%=addressNo%>">
				<button>삭제</button>
			</form>
		</div>

<%
	}
}
%>    
    </section>
    
</body>
</html>