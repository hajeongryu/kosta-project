package com.team.interest.service;

import java.util.ArrayList;
import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.interest.dao.InterestDAOOracle;
import com.team.user.vo.Interest;

public class InterestService {
	private InterestDAOOracle dao = InterestDAOOracle.getInstance();
	private static InterestService service = new InterestService();
	private InterestService() {
		
	}
	public static InterestService getInstance() {
		return service;
	}
	public Boolean chkInterest() throws FindException {
		dao.findInterest(0, 0);
		return true;
	}
	
	/**
	 * 좋아요/알림 눌렀을 때 눌려있으면 삭제하고, 눌려있지 않으면 추가한다
	 * @param projectNo 프로젝트번호
	 * @param userNo 유저번호
	 * @param interestAlarm 좋아요면 'I', 알람이면 'A'
	 * @throws AddException
	 */
	public void clickInterest(int projectNo, int userNo, String interestAlarm) throws AddException{
		dao.clickInterest(projectNo, userNo, interestAlarm);
	}
	
	/**
	 * 유저번호가 좋아요 프로젝트들을 보여준다
	 * 내역이 존재하지 않으면 FindException이 발생한다
	 * @param userNo 유저번호
	 * @return 좋아요 프로젝트정보들
	 * @throws FindException
	 */
	public List<Interest> myInterestProjects(int userNo) throws FindException{
		List<Interest> list = new ArrayList<>();
		List<Interest> inters = new ArrayList<>();
		
		list = dao.findByUserNo(userNo);
		for(Interest i: list) {
			if(i.getInterestAlarm().equals("I")) {
				inters.add(i);
			}
		}
		return inters;
	}
	
	/**
	 * 유저번호가 알림설정한 프로젝트들을 보여준다
	 * 내역이 존재하지 않으면 FindException이 발생한다
	 * @param userNo 유저번호
	 * @return 알림설정한 프로젝트정보들
	 * @throws FindException
	 */
	public List<Interest> myAlarmProjects(int userNo) throws FindException{
		List<Interest> list = new ArrayList<>();
		List<Interest> alarm = new ArrayList<>();
		
		list = dao.findByUserNo(userNo);
		for(Interest i: list) {
			if(i.getInterestAlarm().equals("A")) {
				alarm.add(i);
			}
		}
		return alarm;
	}
	
	/**
	 * 사용자가 좋아요 누른 프로젝트 개수를 반환한다
	 * @param userNo 유저번호
	 * @return 좋아요 누른 프로젝트 개수
	 * @throws FindException
	 */
	public int countInterestProjects(int userNo) throws FindException {
		List<Interest> list = new ArrayList<>();
		List<Interest> inters = new ArrayList<>();
		
		list = dao.findByUserNo(userNo);
		for(Interest i: list) {
			if(i.getInterestAlarm().equals("I")) {
				inters.add(i);
			}
		}
		int cnt = inters.size();
		return cnt;
	}
	
	/**
	 * 사용자가 알림설정 누른 프로젝트 개수를 반환한다
	 * @param userNo 유저번호
	 * @return 알림설정 누른 프로젝트 개수
	 * @throws FindException
	 */
	public int countAlarmProjects(int userNo) throws FindException {
		List<Interest> list = new ArrayList<>();
		List<Interest> alarm = new ArrayList<>();
		
		list = dao.findByUserNo(userNo);
		for(Interest i: list) {
			if(i.getInterestAlarm().equals("A")) {
				alarm.add(i);
			}
		}
		int cnt = alarm.size();
		return cnt;
	}
}
