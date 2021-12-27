package com.team.project.control;

import java.io.IOException;
import java.util.List;

import com.team.exception.FindException;
import com.team.project.service.ProjectService;
import com.team.project.vo.Project;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MainPageProjectLodingServlet
 */
@WebServlet("/")
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
			List<Project>adList = service.getAdProjects(3, 4, 5);
			request.setAttribute("ads", adList);
		} catch (FindException e1) {
		}
		

		try {
			List<Project> attentionList= service.getAttentionProject(loginedUserNo);
			request.setAttribute("attention", attentionList);
		} catch (FindException e) {
		}
	

		try {
			List<Project>popluarList= service.getPopularProject(loginedUserNo);
			request.setAttribute("popular", popluarList );
		} catch (FindException e) {
		}


		try {
			List<Project>endcomeList =service.getEndcomeProject(loginedUserNo);
			request.setAttribute("endcome",endcomeList );
		} catch (FindException e) {
		}
		
		
		
		try {
			List<Project>releaseList =service.getReleaseProject(loginedUserNo);
			request.setAttribute("release",releaseList );
		} catch (FindException e) {
		}



		try {
			List<Project> newList =service.getNewProject(loginedUserNo);
			request.setAttribute("new", newList );
		} catch (FindException e) {
		}
		
		
		//테스트용
		try {
			List <Project> list =service.getProjects(null, null, null, null, null, null, "1");
			request.setAttribute("list", list);
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
		doGet(request, response);
	}

}
