package com.team.user.control;

import java.io.IOException;

import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.user.service.UserService;
import com.team.user.vo.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/profileset")
public class ProfileSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users u = (Users)session.getAttribute("loginInfo");
		
		int userNo = u.getUserNo();
		String userImage = request.getParameter("image");
		String userName = request.getParameter("name");
		String userUrl = request.getParameter("url");
		String userIntroduction = request.getParameter("introduction");
		String userWebsite = request.getParameter("website");
		UserService service = UserService.getInstance();
		try {
			service.profileSet(userNo, userImage, userName, userUrl, userIntroduction, userWebsite);
			session.removeAttribute("loginInfo");
			Users u2 = service.findByUserNo(userNo);
			session.setAttribute("loginInfo", u2);
			session.setMaxInactiveInterval(24*60*60);
			response.sendRedirect("/rhollEE/jsp/settings/profileset.jsp");
		} catch (ModifyException | FindException e) {
			e.printStackTrace();
		}
	}

}
