package com.team.interest.dao;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.user.vo.Interest;

public interface InterestDAOInterface {
	/**
	 * 로그인한 유저번호가 해당 프로젝트를 좋아요/알림 눌렀는지 보여준다
	 * @param projectNo 프로젝트번호
	 * @param userNo 유저번호
	 * @return 좋아요/알림 눌렀으면 true
	 * @throws FindException
	 */
	public Boolean findInterest(int projectNo, int userNo) throws FindException;
	
	/**
	 * 좋아요/알림 눌렀을 때 눌려있으면 삭제하고, 눌려있지 않으면 추가한다
	 * @param projectNo 프로젝트번호
	 * @param userNo 유저번호
	 * @param interestAlarm 좋아요면 'I', 알람이면 'A'
	 * @throws AddException
	 */
	public void clickInterest(int projectNo, int userNo, String interestAlarm) throws AddException;
	
	/**
	 * 유저번호가 좋아요/알림누른 프로젝트들을 보여준다
	 * @param userNo 유저번호
	 * @return 좋아요/알림 프로젝트정보들
	 * @throws FindException
	 */
	public List<Interest> findByUserNo(int userNo) throws FindException;
}
