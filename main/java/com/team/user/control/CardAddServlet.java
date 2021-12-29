package com.team.user.control;

import java.io.IOException;
import java.sql.Date;

import com.team.exception.AddException;
import com.team.user.service.CardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cardadd")
public class CardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String cardNum = request.getParameter("cardNum");
		String cardValidDate = request.getParameter("cardValidDate");
		String cardPwd = request.getParameter("cardPwd");
		String cardOwnerBirth = request.getParameter("cardOwnerBirth");
		String defaultCard = request.getParameter("defaultCard");
		Date d = Date.valueOf(cardValidDate);
		String defaultC;
		if(defaultCard == null) {
			defaultC = "0";
		} else {
			defaultC = "1";
		}
		
		CardService service = CardService.getInstance();
		try {
			service.addCardService(userNo, cardNum, d, cardPwd, cardOwnerBirth, defaultC);
			response.sendRedirect("/rhollEE/jsp/settings/paymentset.jsp");
		} catch (AddException e) {
			e.printStackTrace();
		}
	}

}
