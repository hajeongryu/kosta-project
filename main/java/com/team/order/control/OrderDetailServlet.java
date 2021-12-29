package com.team.order.control;

import java.io.IOException;

import com.team.exception.FindException;
import com.team.order.service.OrderService;
import com.team.order.vo.Order;
import com.team.user.vo.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/orderdetail")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service = OrderService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users u = (Users)session.getAttribute("loginInfo");
		int userNo = u.getUserNo();
		
		String paymentNo = request.getParameter("paymentNo");
		Order order = new Order();
		
		try {
			order = service.findByPaymentNo(Integer.parseInt(paymentNo));
			request.setAttribute("order", order);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		String path = "./jsp/profile/orderdetailresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
