package com.team.interest.dao;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.RemoveException;
import com.team.project.vo.Project;
import com.team.user.vo.Interest;
import com.team.user.vo.Users;

public interface InterestDAOInterface {
	/**
	 * 로그인한 유저번호가 해당 프로젝트를 좋아요/알림 눌렀는지 보여준다
	 * @param projectNo 프로젝트번호
	 * @param userNo 유저번호
	 * @return 좋아요/알림 프로젝트정보
	 * @throws FindException
	 */
	public Boolean findInterest(int projectNo, int userNo) throws FindException;
	
	/**
	 * 
	 * @param projectNo 프로젝트번호
	 * @param userNo 유저번호
	 * @param interestAlarm 좋아요면 'I', 알람이면 'A'
	 * @throws AddException
	 */
	public void addInterest(int projectNo, int userNo, String interestAlarm) throws AddException;
	
	/**
	 * 
	 * @param projectNo 프로젝트번호
	 * @param userNo 유저번호
	 * @throws RemoveException
	 */
	public void removeInterest(int projectNo, int userNo) throws RemoveException;
	
	/**
	 * 유저번호가 좋아요/알림누른 프로젝트들을 보여준다
	 * @param userNo 유저번호
	 * @return 좋아요/알림 프로젝트정보들
	 * @throws FindException
	 */
	public List<Interest> findByUserNo(int userNo) throws FindException;
}
