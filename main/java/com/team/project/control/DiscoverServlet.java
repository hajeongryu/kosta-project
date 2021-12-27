package com.team.project.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.exception.FindException;
import com.team.project.service.ProjectService;
import com.team.project.vo.Project;

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

		System.out.println("요청됨");
		
		
		HttpSession session = request.getSession();
		
		String path="";
		

		//리퀘스트 값들 받기
		String category = request.getParameter("category");
		String ongoing= request.getParameter("ongoing");
		String editorPick= request.getParameter("editorPick");
		String achiveRate= request.getParameter("achiveRate");
		String sort = request.getParameter("sort");
		String rowCount = request.getParameter("rowCount");
		String loginedUserNo = (String) session.getAttribute("userNo");

		
		
		ProjectService service = ProjectService.getInstance();
		try {
			List<Project> findedProjects =
					service.getProjects(category, ongoing, editorPick, achiveRate, sort, rowCount, loginedUserNo);

			
			request.setAttribute("finedProjects", findedProjects);
			//미구현

			
			path="./jsp/mainpage/";
		} catch (FindException e) {
			System.out.println("DiscoverServlet.java  doGet 익셉션");
			e.printStackTrace();
			
			//미구현
			path="failresult.jsp";
		}

		System.out.println("요청됨");
			path="";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
