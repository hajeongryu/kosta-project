package com.team.user.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.exception.FindException;
import com.team.user.service.UserService;
import com.team.user.vo.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idValue = request.getParameter("id");
		String pwdValue = request.getParameter("pwd");
		System.out.println("userId=" + idValue + ", userPwd" + pwdValue);
		String resultMsg="";
		UserService service = UserService.getInstance();
		
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		
		String path = "";
		try {
			Users u = service.login(idValue, pwdValue);
			System.out.println("로그인 성공");
			session.setAttribute("loginInfo", u);
		} catch (FindException e) {
			System.out.println(e.getMessage());
			resultMsg = "로그인 실패";
			request.setAttribute("status", 0);
		}
		
		request.setAttribute("msg", resultMsg);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
