package com.team.project.vo;

import java.sql.Blob;
import java.sql.Date;

import com.team.user.vo.Users;


/*
	`comment_no`	NUMBER(8)	NOT NULL,
	`post_no`	NUMBER(8)	NOT NULL,
	`comment_content`	VARCHAR2(100)	NULL,
	`comment_date`	DATE	NULL,
	`user_no`	NUMBER(8)	NOT NULL

*/
public class Comments {
	private int commentNo;
	private Community postNo;
	private Project projectNo;
	private Users UserNo;
	private Blob commentContent;
	private Date commentDate;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comments(int commentNo, Community postNo, Project projectNo, Users userNo, Blob commentContent,
			Date commentDate) {
		super();
		this.commentNo = commentNo;
		this.postNo = postNo;
		this.projectNo = projectNo;
		UserNo = userNo;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public Community getPostNo() {
		return postNo;
	}
	public void setPostNo(Community postNo) {
		this.postNo = postNo;
	}
	public Project getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Project projectNo) {
		this.projectNo = projectNo;
	}
	public Users getUserNo() {
		return UserNo;
	}
	public void setUserNo(Users userNo) {
		UserNo = userNo;
	}
	public Blob getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(Blob commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
}
