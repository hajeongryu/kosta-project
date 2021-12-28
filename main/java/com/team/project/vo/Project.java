package com.team.project.vo;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.interceptor.AbstractCreateStatementInterceptor;

import com.team.user.vo.Interest;
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
	private Users maker;
	
	//프로젝트의 선물삼자들
	private List<Reward> reward;

	//좋아요 상태 (로그인 유저가 이프로젝트가 좋아요 일시 true)
	private boolean loginedUserProjectInterest=false; 

	                                  

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(int projectNo,  String longTitle, String projectBrief,
			String editorPick, String projectImage, int targetPrice, Date startDate, Date endDate, String shortTitle,
			String projectContent, String projectUrl) {
		super();
		this.projectNo = projectNo;
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


	public Users getMaker() {
		return maker;
	}
	


	public String getRemainingDays() {
		Date endDate=this.getEndDate();
		Date sysDate = new Date();
		
		long diffDay = (endDate.getTime() - sysDate.getTime()) /(24*60*60*1000);
		
		if(diffDay>=0) {
			return diffDay+"일 남음";
		}
		
		else {
			return Math.abs(diffDay)+"일 지남";
		}
	}

	public int getAchiveRate() {
		double achiveRate = this.getProjectChange().getSumPrice() / (double)this.getTargetPrice()  *100; 
		System.out.println((int)achiveRate);
		return (int)achiveRate;
	}

	public boolean isLoginedUserProjectInterest() {
		return loginedUserProjectInterest;
	}


	public void setLoginedUserProjectInterest(boolean loginedUserProjectInterestState) {
		this.loginedUserProjectInterest= loginedUserProjectInterestState;
	}


	public void setMaker(Users maker) {
		this.maker = maker;
	}


	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}




	public ProjectChange getProjectChange() {
		return projectChange;
	}


	public void setProjectChange(ProjectChange projectChange) {
		this.projectChange = projectChange;
	}


	public List<Reward> getReward() {
		return reward;
	}


	public void setReward(List<Reward> reward) {
		this.reward = reward;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
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
