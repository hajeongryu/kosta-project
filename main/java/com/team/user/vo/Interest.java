package com.team.user.vo;

import com.team.project.vo.Project;

public class Interest {
	
	private Project	projectNo    ;
	private Users	userNo       ;
	private String	interestAlarm;
	public Interest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Interest(Project projectNo, Users userNo, String interestAlarm) {
		super();
		this.projectNo = projectNo;
		this.userNo = userNo;
		this.interestAlarm = interestAlarm;
	}
	public Project getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Project projectNo) {
		this.projectNo = projectNo;
	}
	public Users getUserNo() {
		return userNo;
	}
	public void setUserNo(Users userNo) {
		this.userNo = userNo;
	}
	public String getInterestAlarm() {
		return interestAlarm;
	}
	public void setInterestAlarm(String interestAlarm) {
		this.interestAlarm = interestAlarm;
	}
	
	

}
