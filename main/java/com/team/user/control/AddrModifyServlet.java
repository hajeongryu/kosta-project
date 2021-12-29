package com.team.user.control;

import java.io.IOException;

import com.team.exception.ModifyException;
import com.team.user.service.AddrService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addrmodify")
public class AddrModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addressNo = Integer.parseInt(request.getParameter("addressNo")); 
		int userNo = Integer.parseInt(request.getParameter("userNo")); 
		String receiverName = request.getParameter("receiverName"); 
		int receiverZipcode =Integer.parseInt(request.getParameter("receiverZipcode")); 
		String receiverAddress = request.getParameter("receiverAddress");
		String receiverAddressDetailed = request.getParameter("receiverAddressDetailed"); 
		String receiverPhone = request.getParameter("receiverPhone");
		String defaultAddress = request.getParameter("defaultAddress");
		AddrService service = AddrService.getInstance();
		try {
			service.modifyAddrService(addressNo, userNo, receiverName, receiverZipcode, receiverAddress, receiverAddressDetailed, receiverPhone, defaultAddress);
			response.sendRedirect("/rhollEE/jsp/settings/addressset.jsp");
		} catch (ModifyException e) {
			e.printStackTrace();
		}
	}

}
