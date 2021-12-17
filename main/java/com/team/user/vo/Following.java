package com.team.user.vo;


/*
	`following` NUMBER(8) NOT NULL, 
	`user_no` NUMBER(8) NOT NULL
*/
public class Following {
	private Users userNo;
	private Users following;
	public Following() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Following(Users userNo, Users following) {
		super();
		this.userNo = userNo;
		this.following = following;
	}
	
	public Users getUserNo() {
		return userNo;
	}
	public void setUserNo(Users userNo) {
		this.userNo = userNo;
	}
	public Users getFollowing() {
		return following;
	}
	public void setFollowing(Users following) {
		this.following = following;
	}
	
	

	

	
}
