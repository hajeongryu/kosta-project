package com.team.user.control;

import java.io.IOException;
import java.util.List;

import com.team.exception.FindException;
import com.team.order.vo.Order;
import com.team.project.service.ProjectService;
import com.team.project.vo.Project;
import com.team.user.service.OrderService;
import com.team.user.vo.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  HttpSession session = request.getSession();
		  String loginedUserNo= null;
		  
		  //로그인한 유저 정보 session으로 받기
		  Users loginedUser = (Users)session.getAttribute("loginInfo");
		  if( loginedUser != null) {
			  loginedUserNo= ""+loginedUser.getUserNo();
		  }
		  System.out.println("[Profileservlet] 로그인한 유저번호 : " + loginedUserNo);
		  

		  //TODO:1.로그인 한 유저가 만든 프로젝트 2.로그인 한 유저가 후원(결제)한 프로젝트  3.로그인한 유저가 좋아(알림신청)한 프로젝트
		  
		  ProjectService proejctService = ProjectService.getInstance();
		  OrderService orderService = OrderService.getInstace();
		  try {
			
			if(loginedUserNo != null) {
				//1.로그인한 유저가 만든 프로젝트
				List<Project> ProejctListMadeByLoginedUser = proejctService.findByUserNo(loginedUserNo);
				request.setAttribute("projectList", ProejctListMadeByLoginedUser);
				
				//2.로그인한 유저가 후원한 프로젝트
				List<Order> OrderListByLoginedUser = orderService.findByUserNo(Integer.parseInt(loginedUserNo));
				request.setAttribute("orderList", OrderListByLoginedUser);
				
				
				//3.로그인한 유저가 좋아한 프로젝트
			
			}
			
			String path ="./jsp/profile/profile.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
			
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
