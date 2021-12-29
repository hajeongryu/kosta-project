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

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/projectdetailpage/post.css">

<body>

	<% 	
		List<Community> posts = (List)request.getAttribute("findedPost");
		Users loginedUser = (Users)session.getAttribute("loginInfo");
	%>
		

			<% 
			if(posts !=null){ 
				for(Community post: posts){ 
					int projectNo=post.getProject().getProjectNo(); 
					int postNo=post.getPostNo(); 
					String makerName=post.getMaker().getUserName(); 
					java.util.Date postDate=post.getPostDate(); 
					String postCon=post.getPostContent(); 		
			%>
					<div>
					<h2>커뮤니티</h2>
					</div>					
					<div style="display:none;">
						게시글번호<br>
						<%=postNo %>
					</div>
					<div>
						<br>
						<%=makerName %>
						<br>
						<%=postDate %>
					</div>
					<div class="postbox">
						게시글내용<br>
						<%=postCon %>
					</div>
										<div>
											<div style="border-bottom:none;" valign="middle"><br>
												<br>
												<%if(loginedUser !=null){ %>
													<%=loginedUser.getUserName()%>
														<%} %>
											</div>
											<div>
											<form method="post" action="<%=request.getContextPath()%>/postadd">
												<div>
													<input type="text" style=" height:100px;" class="form-control"
														placeholder="커뮤니티 게시글 작성" name="postText">
													<input type="hidden" name="projectNo" value="<%=projectNo%>">
													<input type="submit" class="pull" value="작성">
												</div>
											</form>
											</div>
										</div>
					
					
				<a href="javascript:doDisplay();">
					<button>댓글접기</button>
				</a>
				
				
				<script>
					function doDisplay() {
						var con = document.getElementById("cmt");
						if (con.style.display == 'none') {
							con.style.display = 'block';
						} else {
							con.style.display = 'none';
						}
					}
				</script>
					<div id="cmt" class="commentlist">
						
						<% 
							List<Comments> cmt = post.getComments();
							for(Comments comment: cmt){
							int commentNo = comment.getCommentNo();
							java.util.Date commentDate = comment.getCommentDate();
							String makers = comment.getMaker().getUserName();
							postNo = comment.getPost().getPostNo();
							String commentCon = comment.getCommentContent();
						%>
							<div class="cmtbox">
								<div style="display:none;">
									게시글번호 
									<%=postNo %>
								</div>
								<div style="display:none;">
									댓글번호 
									<%=commentNo %>
								</div>
								<div> 
									<%=makers %>
									<%=commentDate %>
								</div>
								<div>
									댓글내용
									<%=commentCon %>
								</div>
							</div>
							<% } %>
	
								<% } } %>
								
					</div>




</body>

</html>