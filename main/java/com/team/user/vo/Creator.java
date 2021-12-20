package com.team.user.vo;

import com.team.project.vo.Project;

/*
	`user_no`	NUMBER(8)	NOT NULL,
	`maker_account`	VARCHAR2(20)	NULL,
	`project_no`	NUMBER(8)	NOT NULL
*/

public class Creator {
	private Users userNo;
	private Project projectNo;
	private String makerAccount;
	
	
	public Creator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Creator(Users userNo, Project projectNo, String makerAccount) {
		super();
		this.userNo = userNo;
		this.projectNo = projectNo;
		this.makerAccount = makerAccount;
	}


	public Users getUserNo() {
		return userNo;
	}
	public void setUserNo(Users userNo) {
		this.userNo = userNo;
	}
	public Project getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Project projectNo) {
		this.projectNo = projectNo;
	}
	public String getMakerAccount() {
		return makerAccount;
	}
	public void setMakerAccount(String makerAccount) {
		this.makerAccount = makerAccount;
	}
	
	

}
