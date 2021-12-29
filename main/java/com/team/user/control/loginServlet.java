package com.team.user.control;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.team.exception.FindException;
import com.team.user.service.UserService;
import com.team.user.vo.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idValue = request.getParameter("id");
		String pwdValue = request.getParameter("pwd");
		System.out.println("userId=" + idValue + ", userPwd=" + pwdValue);
		UserService service = UserService.getInstance();
		
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		
		String path = "";
		try {
			Users u = service.login(idValue, pwdValue);
			System.out.println("로그인 성공");
			session.setAttribute("loginInfo", u);
			session.setMaxInactiveInterval(24*60*60);
			path ="/rhollEE";
			response.sendRedirect(path);
		} catch (FindException e) {
			System.out.println(e.getMessage());
			request.setAttribute("status", 0);
			request.setAttribute("msg", "로그인실패");
			path = "/jsp/login/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		
	}
	
	
}
