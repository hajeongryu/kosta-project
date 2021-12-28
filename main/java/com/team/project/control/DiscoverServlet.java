package com.team.project.control;

import java.io.IOException;
import java.util.List;

import com.team.exception.FindException;
import com.team.project.service.ProjectService;
import com.team.project.vo.Project;
import com.team.user.vo.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DiscoverServlet
 */
@WebServlet("/discover")
public class DiscoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("서블릿 매핑 테스트");
		
		
		HttpSession session = request.getSession();
		
		String path="";
		
		String loginedUserNo =null;

		//리퀘스트 값들 받기
		String category = request.getParameter("category");
		String ongoing= request.getParameter("ongoing");
		String editorPick= request.getParameter("editorPick");
		String achiveRate= request.getParameter("achiveRate");
		String sort = request.getParameter("sort");
		String rowCount = request.getParameter("rowCount");
		
		
		Users u = (Users)session.getAttribute("loginInfo");
		if(u != null) {
			loginedUserNo = u.getUserNo()+"";
		}
			System.out.println("[discoverSelvert] 로그인한 유저의 유저번호 : "+loginedUserNo);

		
		
		ProjectService service = ProjectService.getInstance();
		try {
			List<Project> discoverList=
					service.getProjects(category, ongoing, editorPick, achiveRate, sort, rowCount, loginedUserNo);

			
			request.setAttribute("discoverList", discoverList);
			//미구현

			
			path="./jsp/discover/discover.jsp";
		} catch (FindException e) {
			System.out.println("DiscoverServlet.java  doGet 익셉션");
			e.printStackTrace();
			
			//미구현
			path="failresult.jsp";
		}

		System.out.println("요청됨");
			path="./jsp/discover/discover.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
