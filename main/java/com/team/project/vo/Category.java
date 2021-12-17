package com.team.project.vo;

/*
	`category_no`	NUMBER(8)	NOT NULL,
	`category_p`	NUMBER(8)	NOT NULL,
	`category_name`	VARCHAR2(100)	NULL
*/

public class Category {
	private int categoryNo;
	private int categoryP;
	private String categoryName;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryNo, int categoryP, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryP = categoryP;
		this.categoryName = categoryName;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getCategoryP() {
		return categoryP;
	}
	public void setCategoryP(int categoryP) {
		this.categoryP = categoryP;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
}
