package com.team.user.control;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.team.exception.FindException;
import com.team.user.service.CardService;
import com.team.user.vo.Card;
import com.team.user.vo.Users;

import jakarta.servlet.http.HttpSession;


@WebServlet("/card")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CardService service = CardService.getInstance();	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginedUserNo = null;
		String path = "";
		
		//getSession : loginedUser
		HttpSession session = request.getSession();
		
		//유저객체
		Users loginedUser = (Users)session.getAttribute("loginInfo");
		int userNo = loginedUser.getUserNo();
		if( loginedUser != null) {
			loginedUserNo = loginedUser.getUserNo()+"";
		}
		System.out.println("[cardSelvert] 로그인한 유저의 유저번호 : "+ loginedUserNo);
		
		try {
			
			List<Card> card = service.findByUserNo(userNo);
			
			request.setAttribute("card", card);
			path = "./jsp/settings/paymentset.jsp";
			
		} catch (FindException e) {
			e.printStackTrace();
			path = "";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
