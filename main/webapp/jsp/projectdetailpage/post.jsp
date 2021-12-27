<%@page import="com.team.project.vo.Project"%>
<%@page import="com.team.community.service.PostService"%>
<%@page import="com.team.community.service.CommentService"%>
<%@page import="com.team.project.dao.CommunityDAOOracle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.team.project.vo.Community"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<!-- 
	https://2-juhyun-2.tistory.com/173
	https://kimhyun2017.tistory.com/113
	
	https://victorydntmd.tistory.com/150
	https://designatedroom87.tistory.com/325
	-->
<%
List<Community> posts = (List)request.getAttribute("post");
%>
<table>
<tr><th>게시글번호</th>
    <th>글번호</th>
    
    <th>작성자</th>
    <th>글내용</th>
    <th>글작성일</th>
</tr>

<%
for(Community post: posts){
	Project pjNo = post.getProject();
	int postNo = post.getPostNo();
	String makerName = post.getMaker().getUserName();
	java.util.Date postDate = post.getPostDate();
	String postCon = post.getPostContent();
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