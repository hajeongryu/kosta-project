package com.team.community.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.community.service.PostService;
import com.team.exception.FindException;
import com.team.project.vo.Community;

import javax.servlet.RequestDispatcher;

@WebServlet("/postinfo")
public class PostInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostService service = PostService.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postNo = request.getParameter("post_no");
		int postNum = Integer.parseInt(postNo);
		String path = "";
		
		PostService service = new PostService();
		try {
			List<Community> post = service.findProjectNo(postNum);
			request.setAttribute("post", post);
			path = "/rhollEE/src/main/webapp/jsp/projectdetailpage/post.jsp";
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path ="";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}

