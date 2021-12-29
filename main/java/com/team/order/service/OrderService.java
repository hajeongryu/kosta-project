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
	
	/**
	 * 주문정보를 추가한다
	 * @param order 주문객체
	 * @throws FindException
	 */
	public void add(Order order) throws FindException {
		dao.add(order);
	}
	
	/**
	 * 주문번호를 통해 주문정보를 불러온다
	 * @param payment_no 주문번호
	 * @return 주문정보
	 * @throws FindException
	 */
	public Order findByPaymentNo(int payment_no) throws FindException{
		return dao.findByPaymentNo(payment_no);
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
	
	/**
	 * 유저의 결제상태가 펀딩실패인 프로젝트를 반환한다 
	 * @param userNo 유저번호
	 * @return 펀딩실패 목록들
	 * @throws FindException
	 */
	public List<Order> failProjects(int userNo) throws FindException{
		List<Order> orders = new ArrayList<>();
		orders = dao.findByUserNo(userNo);
		
		List<Order> fail = new ArrayList<>();
		for(Order o: orders) {
			if(o.getPaymentResult().equals("펀딩실패")) {
				fail.add(o);
			}
		}
		return fail;
	}
	
	/**
	 * 유저가 결제한 아직 진행중인 프로젝트를 반환한다 
	 * @param userNo 유저번호
	 * @return 진행중 목록들
	 * @throws FindException
	 */
	public List<Order> ongoingProjects(int userNo) throws FindException{
		List<Order> orders = new ArrayList<>();
		orders = dao.findByUserNo(userNo);
		
		List<Order> ongoing = new ArrayList<>();
		for(Order o: orders) {
			if(o.getPaymentResult().equals("진행중")) {
				ongoing.add(o);
			}
		}
		return ongoing;
	}
	
	/**
	 * 유저가 결제한 펀딩성공한(펀딩은 성공, 결제는 x) 프로젝트를 반환한다 
	 * @param userNo 유저번호
	 * @return 펀딩성공한 목록들
	 * @throws FindException
	 */
	public List<Order> successProjects(int userNo) throws FindException{
		List<Order> orders = new ArrayList<>();
		orders = dao.findByUserNo(userNo);
		
		List<Order> success = new ArrayList<>();
		for(Order o: orders) {
			if(o.getPaymentResult().equals("펀딩성공")) {
				success.add(o);
			}
		}
		return success;
	}
	
	/**
	 * 유저의 결제상태가 결제완료인 프로젝트를 반환한다 
	 * @param userNo 유저번호
	 * @return 결제완료한 목록들
	 * @throws FindException
	 */
	public List<Order> payedProjects(int userNo) throws FindException{
		List<Order> orders = new ArrayList<>();
		orders = dao.findByUserNo(userNo);
		
		List<Order> payed = new ArrayList<>();
		for(Order o: orders) {
			if(o.getPaymentResult().equals("결제완료")) {
				payed.add(o);
			}
		}
		return payed;
	}
}
