package com.team.user.vo;

import java.util.List;

/*
	`following` NUMBER(8) NOT NULL, 
	`user_no` NUMBER(8) NOT NULL
*/
public class Follow {
	private int userNo;
	private List<Users> following;
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Follow(int userNo, List<Users> following) {
		super();
		this.userNo = userNo;
		this.following = following;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public List<Users> getFollowing() {
		return following;
	}
	public void setFollowing(List<Users> following) {
		this.following = following;
	}

	
	
}
