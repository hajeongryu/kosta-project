package com.team.project.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.exception.FindException;
import com.team.project.service.ProjectService;

/**
 * Servlet implementation class MainPageProjectLodingServlet
 */
@WebServlet("/mp")
public class MainPageProjectLodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageProjectLodingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectService service = ProjectService.getInstance();

		System.out.println("요청됨");
		
		HttpSession session = request.getSession();
		String loginedUserNo = (String)session.getAttribute("logineduserNo");

		

		try {
			service.getAdProjects(3, 4, 5);
		} catch (FindException e1) {
			e1.printStackTrace();
		}
		

		try {
			service.getAttentionProject(loginedUserNo);
		} catch (FindException e) {
			e.printStackTrace();
		}
	

		try {
			service.getPopularProject(loginedUserNo);
		} catch (FindException e) {
			e.printStackTrace();
		}


		try {
			service.getEndcomeProject(loginedUserNo);
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			service.getReleaseProject(loginedUserNo);
		} catch (FindException e) {
			e.printStackTrace();
		}



		try {
			service.getNewProject(loginedUserNo);
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		String path ="./jsp/mainpage/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
