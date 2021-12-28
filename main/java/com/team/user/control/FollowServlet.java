package com.team.user.control;

import java.io.IOException;
import java.util.List;

import com.team.exception.FindException;
import com.team.user.service.FollowService;
import com.team.user.vo.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FollowServlet
 */
@WebServlet("/follow")
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String loginedUserNo=null;
		
		Users loginedUser = (Users) session.getAttribute("loginInfo");
		
		if( loginedUser != null ) {
			loginedUserNo = ""+loginedUser.getUserNo();
		}
		System.out.println("[FollowServlet] 로인한 유저의 유저번호 : "+loginedUserNo);
		
		
		FollowService service =FollowService.getInstace();
		
			try {
				if( loginedUserNo != null) {
					List<Users> masterList= service.getMaster(Integer.parseInt(loginedUserNo));
					request.setAttribute("masterList", masterList);

			
				}
			} catch (FindException e) {
				e.printStackTrace();
			}
			
			
			try {
				if( loginedUserNo != null) {
				List<Users> savantList = service.getSavant(Integer.parseInt(loginedUserNo));
				request.setAttribute("savantList", savantList);
				}
			} catch (FindException e) {
				e.printStackTrace();
			}
		String path="./jsp/profile/follow.jsp";
		RequestDispatcher rd =request.getRequestDispatcher(path); 
		rd.forward(request, response);
	}
}
