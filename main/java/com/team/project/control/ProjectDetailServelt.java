package com.team.project.control;

import java.io.IOException;
import java.util.List;

import com.team.exception.FindException;
import com.team.project.service.ProjectService;
import com.team.project.vo.Project;
import com.team.project.vo.Reward;
import com.team.user.vo.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProjectDetailServelt
 */
@WebServlet("/projectdetail")
public class ProjectDetailServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectDetailServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String loginedUserNo =null;

		Users u = (Users)session.getAttribute("loginInfo");
		if(u != null) {
			loginedUserNo = u.getUserNo()+"";
		}
			System.out.println("[projectDetailSelvert] 로그인한 유저의 유저번호 : "+loginedUserNo);

		String projectNo = request.getParameter("projectNo");
		ProjectService projectService = ProjectService.getInstance();
		
		
		try {
			Project p = projectService.findByProjectNo(projectNo);
			request.setAttribute("findedProject", p);
			List<Reward> rewardList = projectService.findReward(projectNo);
			request.setAttribute("findedProjectReward", rewardList);
		} catch (FindException e) {
			e.printStackTrace();
		}

		String path="./jsp/projectdetailpage/detail_head.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}
