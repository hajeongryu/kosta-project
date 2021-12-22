package com.team.user.vo;

import java.sql.Date;
import java.util.List;
import java.util.Objects;



/*
	`user_no`	NUMBER(8)	NOT NULL,
	`user_role`	VARCHAR2(10)	NULL,
	`user_id`	VARCHAR2(30)	NULL,
	`user_image`	VARCHAR2(100)	NULL,
	`user_name`	VARCHAR2(20)	NULL,
	`user_pwd`	VARCHAR2(20)	NULL,
	`user_phone`	VARCHAR2(20)	NULL,
	`user_introduction`	VARCHAR2(100)	NULL,
	`user_website`	VARCHAR2(100)	NULL,
	`user_url`	VARCHAR2(100)	NULL,
	`user_privacy`	CHAR(1)	NULL,
	`message_alarm_check`	CHAR(1)	NULL,
	`updates_alarm_check`	CHAR(1)	NULL,
	`follow_alarm_check`	CHAR(1)	NULL,
	`marketing_alarm_check`	CHAR(1)	NULL,
	`user_signup_date`	DATE	NULL,
	`user_status`	VARCHAR2(10)	NULL,
*/


public class Users {
	private int	userNo;                          
	private String	userRole;	                 
	private String	userId;                      
	private String	userName;                    
	private String	userPwd;                     
	private Date	userSignupDate;              
	private String	userStatus;                  
	private String	userImage;                   
	private String	userPhone;                   
	private String	userIntroduction;            
	private String	userWebsite;                 
	private String	userUrl;                     
		                                         
	public Users() {                              
		super();                                  
		// TODO Auto-generated constructor stub   
	}


	public Users(int userNo, String userRole, String userId, String userName, String userPwd, Date userSignupDate,
			String userStatus, String userImage, String userPhone, String userIntroduction, String userWebsite,
			String userUrl) {
		super();
		this.userNo = userNo;
		this.userRole = userRole;
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userSignupDate = userSignupDate;
		this.userStatus = userStatus;
		this.userImage = userImage;
		this.userPhone = userPhone;
		this.userIntroduction = userIntroduction;
		this.userWebsite = userWebsite;
		this.userUrl = userUrl;
	}


	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getUserSignupDate() {
		return userSignupDate;
	}

	public void setUserSignupDate(Date userSignupDate) {
		this.userSignupDate = userSignupDate;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserIntroduction() {
		return userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	public String getUserWebsite() {
		return userWebsite;
	}

	public void setUserWebsite(String userWebsite) {
		this.userWebsite = userWebsite;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}	
	
	
}
