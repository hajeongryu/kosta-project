package com.team.user.control;

import java.io.IOException;

import com.team.exception.ModifyException;
import com.team.user.service.CardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cardmodify")
public class CardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CardService cardService = CardService.getInstance();
		int cardNo = Integer.parseInt(request.getParameter("cardNo"));
		System.out.println(cardNo);
		try {
			cardService.modifyCardService(cardNo);
			response.sendRedirect("/rhollEE/jsp/settings/paymentset.jsp");
		} catch (ModifyException e) {
			e.printStackTrace();
		}
	}

}
