package com.team.order.control;

import java.io.IOException;

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
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String loginedUserNo=null;
		Users loginedUser = (Users) session.getAttribute("loginInfo");
		
		if( loginedUser != null ) {
			loginedUserNo = ""+loginedUser.getUserNo();
		}
		System.out.println("[OrderServlet] 로인한 유저의 유저번호 : "+loginedUserNo);
		
		String buyProjectNo = (String) request.getParameter("projectNo");
		String buyRewardNo= (String ) request.getParameter("rewardNo");
		System.out.println(buyProjectNo);
		System.out.println(buyRewardNo);
		
		
		ProjectService ps = ProjectService.getInstance();
		
		Reward returnReward = null;
		Project returnProject =null;
		try {
			
			if(buyProjectNo !=null) {
				returnProject = ps.findByProjectNo(buyProjectNo);
				if(buyRewardNo != null) {
					for ( Reward r :ps.findReward(buyProjectNo)) {
						if(r.getRewardNo() == Integer.parseInt(buyRewardNo)) {
							returnReward = r;
						}
					}
				}	
			}
		
			
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(returnProject == null) {
			System.out.println("그런 프로젝트 번호는 존재하지 않습니다!");
		}

		if(returnReward ==null) {
			System.out.println("해당프로젝트의 상품이 아닙니다!");
		}
	
		
		request.setAttribute("project", returnProject);
		request.setAttribute("reward", returnReward);
	
		String path = "./jsp/projectdetailpage/order.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}
}
