package com.team.user.control;

import java.io.IOException;

import com.team.exception.ModifyException;
import com.team.user.service.UserService;
import com.team.user.vo.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/withdrawal")
public class WithdrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users u = (Users)session.getAttribute("loginInfo");
		int userNo = u.getUserNo();
		UserService service = UserService.getInstance();
		try {
			service.withdrawal(userNo);
			session.invalidate();
			response.sendRedirect("/rhollEE");
		} catch (ModifyException e) {
			e.printStackTrace();
		}
	}

}
