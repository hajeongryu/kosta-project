package com.team.community.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.community.service.PostService;
import com.team.project.vo.Community;
import com.team.project.vo.Project;

@WebServlet("/postadd")
public class postaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		PostService service = PostService.getInstance();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//int projectNo = request.getParameter("projectNo");
		
		//int userNo= request.getParameter("userNo");
		
		int userNo = 1;
		
		String postCon = request.getParameter("post_content");
		
		//Community post = new Community(projectNo, postCon, userNo);
	
		
		//service.add(post);
	}
}
