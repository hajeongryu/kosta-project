package com.team.community.control;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.team.community.service.CommentService;
import com.team.community.service.PostService;
import com.team.exception.FindException;
import com.team.project.service.ProjectService;
import com.team.project.vo.Comments;
import com.team.project.vo.Community;
import com.team.project.vo.Project;

import jakarta.servlet.RequestDispatcher;

@WebServlet("/postinfo")
public class PostInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostService postService = PostService.getInstance();
	CommentService cmtService = CommentService.getInstance();
	ProjectService proService = ProjectService.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String postNo = request.getParameter("postNo");
		int postNum = Integer.parseInt(postNo);

		String projectNo = request.getParameter("projectNo");
		
		int cmtNum = 1;
		
		String path = "";

		try {			

			Project p = proService.findByProjectNo(projectNo);
			
			//List<Community> post = service.findProjectNo(postNum);
			List<Community> post = postService.findByProjectNo(postNum);
			
			//List<Comments> cmt = cmtservice.findPostNo(cmtNum);
			List<Comments> cmt = cmtService.findByPostNo(cmtNum);
			
			request.setAttribute("p", p);
			request.setAttribute("post", post);
			request.setAttribute("cmt", cmt);
			
			path = "./jsp/projectdetailpage/post.jsp";
						
			
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path ="";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}

