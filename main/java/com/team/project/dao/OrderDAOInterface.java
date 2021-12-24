package com.team.project.dao;

import java.util.List;

import com.team.exception.FindException;
import com.team.order.vo.Order;
import com.team.project.vo.Project;

public interface OrderDAOInterface {
	/**
	 * 유저가 후원한 프로젝트를 프로필 내 후원현황에 리스트업
	 * @param userNo
	 * @return
	 * @throws FindException
	 */
	public List<Order> findByUserNo(int userNo) throws FindException;
	/**
	 * 후원 시 후원현황에 추가하기
	 * @param order
	 * @throws Findxception
	 */
	public void add(Order order) throws FindException;
}
