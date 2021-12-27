<%@page import="com.team.user.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
    $(function(){
        popSlide();
        endcomeSlide();
    });
</script>
<div class="header-container">
    <div class="header-upper">
        <a href="../../jsp/mainpage/index.jsp" id="logo"><img src="../../images/mainpage/rholling.PNG" height="60px"></a>
        <nav class="user-menu">
            <ul>
            <%Users u = (Users)session.getAttribute("loginInfo");
            if(u==null){ //로그인 안된경우
            %>
                <li><a href=""><span class="user-li">프로젝트 올리기</span></a></li>
                <li class="login-container">
                    <a href="#">
                        <span class="user-li login">
                            <img src="../../images/mainpage/user_default.png">
                            <span>로그인/회원가입</span>
                        </span>
                    </a>
                </li>
            <%}else{ //로그인 된 경우%>
                <li class="user-logo">
                    <a href="likelist">
                        <span class="user-li">
                            <img src="../../images/mainpage/like.png">
                        </span>
                    </a>
                </li>
                <li class="user-logo">
                    <a href="#">
                        <span class="user-li">
                            <img src="../../images/mainpage/aram.PNG">
                        </span>
                    </a>
                </li>
                <li class="login-dropdown">
                    <span class="user-li login">
                        <img src="">
                        <span><%=u.getUserName() %></span>
                    </span>
                    <div class="dropdown-content" id="myDropdown">
                        <a href="">프로필</a>
                        <hr>
                        <a href="">후원현황</a>
                        <a href="">관심 프로젝트</a>
                        <a href="">팔로우</a>
                        <hr>
                        <a href="">알림</a>
                        <a href="">메시지</a>
                        <hr>
                        <a href="">내가 만든 프로젝트</a>
                        <a href="">설정</a>
                        <hr>
                        <a href="">로그아웃</a>
                    </div>
                </li>
            <%} %>
            </ul>
        </nav>
    </div>
    
    <div class="header-content">
        <div class="header-search">
            <nav class="cate-navbar">
                <ul class="main-menu">
                    <li class="cate">
                        카테고리
                        <ul class="category">
                        	<li><a href="">전체</a></li>
                            <li><a href="">보드게임 · TRPG</a></li>
                            <li><a href="">디지털 게임</a></li>
                            <li><a href="">웹툰 · 만화</a></li>
                            <li><a href="">웹툰 리소스</a></li>
                            <li><a href="">디자인 문구</a></li>
                            <li><a href="">캐릭터 · 굿즈</a></li>
                            <li><a href="">홈 · 리빙</a></li>
                            <li><a href="">테크 · 가전</a></li>
                            <li><a href="">반려동물</a></li>
                            <li><a href="">푸드</a></li>
                            <li><a href="">향수 · 뷰티</a></li>
                            <li><a href="">의류</a></li>
                            <li><a href="">잡화</a></li>
                            <li><a href="">주얼리</a></li>
                            <li><a href="">출판</a></li>
                            <li><a href="">디자인</a></li>
                            <li><a href="">예술</a></li>
                            <li><a href="">사진</a></li>
                            <li><a href="">음악</a></li>
                            <li><a href="">영화 · 비디오</a></li>
                            <li><a href="">공연</a></li>
                        </ul>
                    </li>
                    <li><a href="#">홈</a></li>
                    <li><a href="#">인기</a></li>
                    <li><a href="#">신규</a></li>
                    <li><a href="#">마감임박</a></li>
                    <li><a href="#">공개예정</a></li>
                </ul>
            </nav>
            <div class="search">
                <form>
                    <input type="search" placeholder="검색어를 입력해주세요." class="search-input" name="keyword" value="">
                    <div><img src="../../images/mainpage/search.png"></div>
                </form>
            </div>
        </div>
    </div>
</div>