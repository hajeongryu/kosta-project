package com.team.user.control;

import java.io.IOException;

import com.team.exception.AddException;
import com.team.user.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("name");
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");
		String resultMsg ="";
		UserService service = UserService.getInstance();
		String path = "";
		
		try {
			service.signup(userName, userId, userPwd);
			resultMsg = "가입성공";
			request.setAttribute("status", 1);
			path = "/jsp/login/login.jsp";
		} catch (AddException e) {
			e.printStackTrace();
			resultMsg = "가입실패";
			request.setAttribute("status", 0);
			path = "/jsp/login/signup.jsp";
		}
		

		request.setAttribute("msg", resultMsg);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
