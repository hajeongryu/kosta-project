package com.team.order.service;

import java.util.ArrayList;
import java.util.List;

import com.team.exception.FindException;
import com.team.order.vo.Order;
import com.team.project.dao.OrderDAOOracle;

public class OrderService {
	private OrderDAOOracle dao = OrderDAOOracle.getInstance();
	private static OrderService service = new OrderService();
	private OrderService() {
		
	}
	public static OrderService getInstance() {
		return service;
	}
	
	public void add(Order order) throws FindException {
		dao.add(order);
	}
	
	/**
	 * 사용자가 주문한 목록을 반환한다
	 * @param userNo 유저번호
	 * @return 주문한 목록들
	 * @throws FindException
	 */
	public List<Order> myOrderProjects(int userNo) throws FindException{
		List<Order> orders = new ArrayList<>();
		orders = dao.findByUserNo(userNo);
		return orders;
	}
	
	/**
	 * 사용자가 주문한 개수를 반환한다
	 * @param userNo 유저번호
	 * @return 주문한 개수
	 * @throws FindException
	 */
	public int countOrderProjects(int userNo) throws FindException {
		List<Order> order = new ArrayList<>();
		order = dao.findByUserNo(userNo);
		int cnt = order.size();
		return cnt;
	}
}
