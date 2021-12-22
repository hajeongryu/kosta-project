package com.team.project.vo;

import java.sql.Date;

import com.team.user.vo.Users;


/*
	`project_no`	NUMBER(8)	NOT NULL,
	`category_no`	NUMBER(8)	NOT NULL,
	`user_no`	NUMBER(8)	NOT NULL,
	`long_title`	VARCHAR2(200)	NULL,
	`project_brief`	VARCHAR2(200)	NULL,
	`editor_pick`	CHAR(1)	NULL,
	`project_image`	VARCHAR2(100)	NULL,
	`target_price`	NUMBER(8)	NULL,
	`start_date`	DATE	NULL,
	`end_date`	DATE	NULL,
	`short_title`	VARCHAR2(100)	NULL,
	`project_content`	VARCHAR2(100)	NULL,
	`project_url`	VARCHAR2(100)	NULL
*/


public class Project {            ;
	private int	projectNo         ;   
	private Category	categoryNo;   
	private Users	userNo        ;   
	private String	longTitle     ;   
	private String	projectBrief  ;   
	private String	editorPick    ;   
	private String	projectImage  ;   
	private int	targetPrice       ;   
	private Date	startDate     ;   
	private Date	endDate       ;   
	private String	shortTitle    ;   
	private String	projectContent;   
	private String	projectUrl    ;   

	//JOIN TABLE
	private ProjectChange projectChange;
	private Category category;
	private Users user;
	
	                                  

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(int projectNo, Category categoryNo, Users userNo, String longTitle, String projectBrief,
			String editorPick, String projectImage, int targetPrice, Date startDate, Date endDate, String shortTitle,
			String projectContent, String projectUrl) {
		super();
		this.projectNo = projectNo;
		this.categoryNo = categoryNo;
		this.userNo = userNo;
		this.longTitle = longTitle;
		this.projectBrief = projectBrief;
		this.editorPick = editorPick;
		this.projectImage = projectImage;
		this.targetPrice = targetPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.shortTitle = shortTitle;
		this.projectContent = projectContent;
		this.projectUrl = projectUrl;
	}


	public int getProjectNo() {
		return projectNo;
	}


	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}


	public Category getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(Category categoryNo) {
		this.categoryNo = categoryNo;
	}


	public ProjectChange getProjectChange() {
		return projectChange;
	}


	public void setProjectChange(ProjectChange projectChange) {
		this.projectChange = projectChange;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Users getUserNo() {
		return userNo;
	}


	public void setUserNo(Users userNo) {
		this.userNo = userNo;
	}


	public String getLongTitle() {
		return longTitle;
	}


	public void setLongTitle(String longTitle) {
		this.longTitle = longTitle;
	}


	public String getProjectBrief() {
		return projectBrief;
	}


	public void setProjectBrief(String projectBrief) {
		this.projectBrief = projectBrief;
	}


	public String getEditorPick() {
		return editorPick;
	}


	public void setEditorPick(String editorPick) {
		this.editorPick = editorPick;
	}


	public String getProjectImage() {
		return projectImage;
	}


	public void setProjectImage(String projectImage) {
		this.projectImage = projectImage;
	}


	public int getTargetPrice() {
		return targetPrice;
	}


	public void setTargetPrice(int targetPrice) {
		this.targetPrice = targetPrice;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getShortTitle() {
		return shortTitle;
	}


	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}


	public String getProjectContent() {
		return projectContent;
	}


	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}


	public String getProjectUrl() {
		return projectUrl;
	}


	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}


	
	
}
