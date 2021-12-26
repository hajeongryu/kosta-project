<%@page import="com.team.community.service.PostService"%>
<%@page import="com.team.community.service.CommentService"%>
<%@page import="com.team.project.dao.CommunityDAOOracle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.team.project.vo.Community"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<!-- 
	https://2-juhyun-2.tistory.com/173-->
<%
List<Community> post = (List)request.getAttribute("post");
%>
<table>
<tr><th>게시글번호</th>
    <th>글번호</th>
    
    <th>작성자</th>
    <th>글내용</th>
    <th>글작성일</th>
</tr>

<%
for(Community posts: post){
	int pjNo = posts.getProject().getProjectNo();
	int postNo = posts.getPostNo();
	String makerName = posts.getMaker().getUserName();
	java.util.Date postDate = posts.getPostDate();
	String postCon = posts.getPostContent();
	
%> 

	<tr>
    	<td><%=pjNo %></td>
    	<td><%=postNo %></td>
    	<td><%=makerName %></td>
    	<td><%=postDate %></td>
    	<td><%=postCon %></td>
   </tr>
<%
}
%>
</table>
</body>
</html>