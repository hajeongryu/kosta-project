package com.team.user.control;

import java.io.IOException;

import com.team.exception.AddException;
import com.team.user.service.AddrService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addressadd")
public class AddressAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String receiverName = request.getParameter("receiverName");
		int receiverZipcode = Integer.parseInt(request.getParameter("receiverZipcode"));
		String receiverAddress = request.getParameter("receiverAddress");
		String receiverAddressDetailed = request.getParameter("receiverAddressDetailed");
		String receiverPhone = request.getParameter("receiverPhone");
		String defaultCheck = request.getParameter("defaultAddress");
		String defaultAddress;
		if(defaultCheck == null) {
			defaultAddress = "0";
		} else {
			defaultAddress = "1";
		}
		
		AddrService service = AddrService.getInstance();
		try {
			service.addAddrService(userNo, receiverName, receiverZipcode, receiverAddress, 
					receiverAddressDetailed, receiverPhone, defaultAddress);
			response.sendRedirect("/rhollEE/jsp/settings/addressset.jsp");
		} catch (AddException e) {
			e.printStackTrace();
		}
	}

}
