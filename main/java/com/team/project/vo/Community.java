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
	private Project	project  ;
	private Date	postDate   ;
	private String	postContent;
	private Users	maker     ;
	private List<Comments> 	comments   ;
	
	public Community() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Community(int postNo, Project project, Date postDate, String postContent, Users maker,
			List<Comments> comments) {
		super();
		this.postNo = postNo;
		this.project = project;
		this.postDate = postDate;
		this.postContent = postContent;
		this.maker = maker;
		this.comments = comments;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public Users getMaker() {
		return maker;
	}

	public void setMaker(Users maker) {
		this.maker = maker;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
			
}
