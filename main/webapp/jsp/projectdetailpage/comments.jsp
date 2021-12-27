<%@page import="com.team.project.vo.Community"%>
<%@page import="com.team.project.vo.Comments"%>
<%@page import="java.util.List"%>
<%@page import="com.team.user.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<%
List<Comments> comments = (List)request.getAttribute("cmt");
%>    
<table class="commentlist">
<tr><th>커뮤니티번호</th>
    <th>댓글번호</th>
    <th>작성자</th>
    <th>댓글내용</th>
    <th>댓글작성일</th>
</tr>
<%
for(Comments comment: comments){
	int commentNo = comment.getCommentNo();
	java.util.Date commentDate = comment.getCommentDate();
	Users makers = comment.getMaker();
	Community postNo = comment.getPost();
	String commentCon = comment.getCommentContent();
	%>
	<tr>
    	<td><%=postNo %></td>
    	<td><%=commentNo %></td>
    	<td><%=makers %></td>
    	<td><%=commentCon %></td>
    	<td><%=commentDate %></td>
   </tr>
<%
}
%>

</table>

<div class="container">
	<div class="form-group">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<tr>
					<td style="border-bottom:none;" valign="middle"><br>
					<br><!-- 유저아이디 --></td>
					<td><input type="text" style="height:100px;" class="form-control" placeholder="댓글 내용" name = "commentText"></td>
					<td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="file" name="fileName"></td>
				</tr>
			</table>
	</div>
</div>
