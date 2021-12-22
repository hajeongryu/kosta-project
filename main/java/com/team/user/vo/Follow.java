package com.team.user.vo;

import java.util.List;

/*
	`following` NUMBER(8) NOT NULL, 
	`user_no` NUMBER(8) NOT NULL
*/
public class Follow {
	private Users userNo;
	private List<Users> following;
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Follow(Users userNo, List<Users> following) {
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
	public List<Users> getFollowing() {
		return following;
	}
	public void setFollowing(List<Users> following) {
		this.following = following;
	}

	
	
}
