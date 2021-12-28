package com.team.user.service;

import java.util.List;

import com.team.exception.FindException;
import com.team.order.vo.Order;
import com.team.project.dao.OrderDAOOracle;

public class OrderService {
	private OrderDAOOracle dao = OrderDAOOracle.getInstance();
	
	private static OrderService orderService = new OrderService();
			
	
	private OrderService() {
	}
	
	public static OrderService getInstace() {
		return orderService;
	}
	
	
	public List<Order> findByUserNo(int inUserNo) throws FindException{
		return dao.findByUserNo(inUserNo);
	}
			
}
