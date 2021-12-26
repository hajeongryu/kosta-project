package com.team.project.vo;



import java.util.Date;

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
	private Community post;
	private Users maker;
	private String commentContent;
	private Date commentDate;
	
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comments(int commentNo, Community post, Users maker, String commentContent,
			Date commentDate) {
		super();
		this.commentNo = commentNo;
		this.post = post;
		this.maker = maker;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}
	
	
	
	@Override
	public String toString() {
		return "Comments [commentNo=" + commentNo + ", post=" + post + ", maker=" + maker + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + "]";
	}

	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public Community getPost() {
		return post;
	}
	public void setPost(Community post) {
		this.post = post;
	}
	public Users getMaker() {
		return maker;
	}
	public void setMaker(Users maker) {
		this.maker = maker;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
}
