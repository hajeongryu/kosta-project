package com.team.user.control;

import java.io.IOException;

import com.team.exception.RemoveException;
import com.team.user.service.AddrService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addrremove")
public class AddrRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addressNo = Integer.parseInt(request.getParameter("addressNo"));
		AddrService service = AddrService.getInstance();
		try {
			service.removeAddrService(addressNo);
			response.sendRedirect("/rhollEE/jsp/settings/addressset.jsp");
		} catch (RemoveException e) {
			e.printStackTrace();
		}
	}

}
