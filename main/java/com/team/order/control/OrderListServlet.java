package com.team.order.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


@WebServlet("/orderlist")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderService service = OrderService.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users u = (Users)session.getAttribute("loginInfo");
		int userNo = u.getUserNo();
		
		String path = "./jsp/profile/orderprojectresult.jsp";
		List<Order> list = new ArrayList<>();
		int cnt = 0;
		
		try {
			list = service.myOrderProjects(userNo);
			cnt = service.countOrderProjects(userNo);
		} catch (FindException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.setAttribute("orderCnt", cnt);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
