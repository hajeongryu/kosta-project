package com.team.community.control;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.team.community.service.PostService;
import com.team.exception.FindException;
import com.team.project.vo.Community;

import jakarta.servlet.RequestDispatcher;

@WebServlet("/postinfo")
public class PostInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostService service = PostService.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String postNo = request.getParameter("postNo");
//		int postNum = Integer.parseInt(postNo);
		
		int postNum = 1;
		String path = "";

		try {
			List<Community> post = service.findProjectNo(postNum);
			
			request.setAttribute("post", post);
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

