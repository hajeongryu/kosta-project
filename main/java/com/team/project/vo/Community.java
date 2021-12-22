package com.team.project.vo;


import java.util.Date;
import java.util.List;

import com.team.user.vo.Users;

/*
	`post_no`	NUMBER(8)	NOT NULL,
	`project_no`	NUMBER(8)	NOT NULL,
	`post_content`	VARCHAR2(100)	NULL,
	`post_date`	DATE	NULL,
	`user_no`	NUMBER(8)	NOT NULL
*/


public class Community {
	private int	postNo         ;
	private Project	projectNo  ;
	private Date	postDate   ;
	private String	postContent;
	private Users	userNo     ;
	private List<Comments> 	comments   ;
	
	public Community() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Community(int postNo, Project projectNo, Date postDate, String postContent, Users userNo,
			List<Comments> comments) {
		super();
		this.postNo = postNo;
		this.projectNo = projectNo;
		this.postDate = postDate;
		this.postContent = postContent;
		this.userNo = userNo;
		this.comments = comments;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public Project getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(Project projectNo) {
		this.projectNo = projectNo;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Users getUserNo() {
		return userNo;
	}

	public void setUserNo(Users userNo) {
		this.userNo = userNo;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
			
}
