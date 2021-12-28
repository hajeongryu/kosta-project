<%@page import="com.team.user.vo.Users"%>
<%@page import="com.team.project.vo.Comments"%>
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

<%
List<Community> posts = (List)request.getAttribute("findedPost");
Users loginedUser = (Users)session.getAttribute("loginInfo");
%>
<table>
<tr><th>게시글번호</th>
    <th>글번호</th>
    
    <th>작성자</th>
    <th>글내용</th>
    <th>글작성일</th>
</tr>

	<a href="javascript:doDisplay();">
  		<button>댓글</button>
  		</a>
<%
if(posts != null){
for(Community post: posts){
	Project pjNo = post.getProject();
	int postNo = post.getPostNo();
	String makerName = post.getMaker().getUserName();
	java.util.Date postDate = post.getPostDate();
	String postCon = post.getPostContent();
	
	%>
		<tr>
    	<td>프로젝트번호<%=pjNo %></td>
    	<td>게시글번호<%=postNo %></td>
    	<td>작성자이름<%=makerName %></td>
    	<td>게시글작성일<%=postDate %></td>
    	<td>게시글내용<%=postCon %></td>
   </tr>
   
   <div class="container">
	<div class="form-group">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<tr>
					<td style="border-bottom:none;" valign="middle"><br>
					<br>
					<%if(loginedUser != null){ %>
					<%=loginedUser.getUserName()%>
					<%} %>
					
					</td>
					<td>
					<form method="post" action="/postadd">
					<input type="text" style="height:100px;" class="form-control" placeholder="댓글 내용" name="postText">
					<input type="hidden" name="postNo" value="<%=postNo%>">
					</td>
					<td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="file" name="fileName"></td>
				</tr>
					</form>
			</table>
	</div>
</div>
   
	<script>
	function doDisplay(){
		var con = document.getElementById("cmt");
		if(con.style.display=='none'){
			con.style.display = 'block';
		}else{
			con.style.display = 'none';
		}
	}
	</script>
	
	<div id="cmt">
	<table class="commentlist">
	<tr><th>커뮤니티번호</th>
	    <th>댓글번호</th>
	    <th>작성자</th>
	    <th>댓글내용</th>
	    <th>댓글작성일</th>
	</tr>
	</div>
	<%
	
	List<Comments> cmt = post.getComments();
	for(Comments comment: cmt){
		int commentNo = comment.getCommentNo();
		java.util.Date commentDate = comment.getCommentDate();
		String makers = comment.getMaker().getUserName();
		postNo = comment.getPost().getPostNo();
		String commentCon = comment.getCommentContent();
	%>
		<tr>
	    	<td>게시글번호 <%=postNo %></td>
	    	<td>댓글번호 <%=commentNo %></td>
	    	<td>댓글작성자 <%=makers %></td>
	    	<td>댓글내용<%=commentCon %></td>
	    	<td>댓글작성일 <%=commentDate %></td>
	   </tr>
	<%
	}
	%>
<%
}
}
%>
</table>
</table>



</body>
</html>