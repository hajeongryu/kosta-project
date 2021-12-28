package com.team.community.control;

import java.io.IOException;

import com.team.community.service.PostService;
import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.project.service.ProjectService;
import com.team.project.vo.Community;
import com.team.project.vo.Project;
import com.team.user.vo.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/postadd")
public class postaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		PostService service = PostService.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginedUserNo=null;
		Community post =new Community();

		//getSession : loginedUser
		HttpSession session = request.getSession();
		//유저객체
		Users loginedUser = (Users)session.getAttribute("loginInfo");
		if( loginedUser != null) {
		loginedUserNo = loginedUser.getUserNo()+"";
		}
		System.out.println("[PostaddSelvert] 로그인한 유저의 유저번호 : "+loginedUserNo);
		
		
		//주석해제해서 고치기
//		String postContent =request.getAttribute("postCon");
		
		
		
		//getProject( requestDate)
		String projectNo = request.getParameter("projectNo");
		ProjectService projectService= ProjectService.getInstance();
		try {
			Project p = projectService.findByProjectNo(projectNo);

			//실제 project객체 연결
			post.setProject(p);
			post.setMaker(loginedUser);
			
			//콘텐트 넣어서 
			//post.setPostContent();
			
			
			service.add(post);
			
			
		} catch (FindException e) {
			e.printStackTrace();
		} catch (AddException e) {
			e.printStackTrace();
		}
		
		
	
		String postCon = request.getParameter("post_content");
		
		//Community post = new Community(projectNo, postCon, loginedUserNo);
	
		
	}
}
