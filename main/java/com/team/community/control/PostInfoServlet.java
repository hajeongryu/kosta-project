package com.team.community.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.community.service.PostService;
import com.team.user.vo.Users;

/**
 * Servlet implementation class PostInfoServlet
 */
@WebServlet("/PostInfoServlet")
public class PostInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostService service = PostService.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute();
		String path = "";
		
	}

}
