package com.team.user.control;

import java.io.IOException;

import com.team.exception.RemoveException;
import com.team.user.service.CardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cardremove")
public class CardRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cardNo = Integer.parseInt(request.getParameter("cardNo"));
		CardService service = CardService.getInstance();
		try {
			service.removeCardService(cardNo);
			response.sendRedirect("/rhollEE/jsp/settings/paymentset.jsp");
		} catch (RemoveException e) {
			e.printStackTrace();
		}
	}

}
