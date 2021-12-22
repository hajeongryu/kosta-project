package com.team.user.vo;

import java.util.Date;

public class Alarm {

	private int	alarmNo         ;
	private Users	userNo      ;
	private String	alarmContent;
	private Date	alarmDate   ;
	private String	alarmRead   ;
	public Alarm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alarm(int alarmNo, Users userNo, String alarmContent, Date alarmDate, String alarmRead) {
		super();
		this.alarmNo = alarmNo;
		this.userNo = userNo;
		this.alarmContent = alarmContent;
		this.alarmDate = alarmDate;
		this.alarmRead = alarmRead;
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public Users getUserNo() {
		return userNo;
	}
	public void setUserNo(Users userNo) {
		this.userNo = userNo;
	}
	public String getAlarmContent() {
		return alarmContent;
	}
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	public Date getAlarmDate() {
		return alarmDate;
	}
	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}
	public String getAlarmRead() {
		return alarmRead;
	}
	public void setAlarmRead(String alarmRead) {
		this.alarmRead = alarmRead;
	}
	
	
}
