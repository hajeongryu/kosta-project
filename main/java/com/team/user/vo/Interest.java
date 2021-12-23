package com.team.user.vo;

import com.team.project.vo.Category;
import com.team.project.vo.Project;
import com.team.project.vo.ProjectChange;

public class Interest {
	private Project	likeProject;
	private Users	likeUser;
	private String	interestAlarm;
	
	//JOIN
	private Category projectCategory;
	private ProjectChange projectChange;
	
	public Interest() {
		super();
	}
	public Interest(Project likeProject, Users likeUser, String interestAlarm, Category projectCategory,
			ProjectChange projectChange) {
		super();
		this.likeProject = likeProject;
		this.likeUser = likeUser;
		this.interestAlarm = interestAlarm;
		this.projectCategory = projectCategory;
		this.projectChange = projectChange;
	}
	public Project getLikeProject() {
		return likeProject;
	}
	public void setLikeProject(Project likeProject) {
		this.likeProject = likeProject;
	}
	public Users getLikeUser() {
		return likeUser;
	}
	public void setLikeUser(Users likeUser) {
		this.likeUser = likeUser;
	}
	public String getInterestAlarm() {
		return interestAlarm;
	}
	public void setInterestAlarm(String interestAlarm) {
		this.interestAlarm = interestAlarm;
	}
	public Category getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(Category projectCategory) {
		this.projectCategory = projectCategory;
	}
	public ProjectChange getProjectChange() {
		return projectChange;
	}
	public void setProjectChange(ProjectChange projectChange) {
		this.projectChange = projectChange;
	}
	
	public void printInfo() {
		System.out.println("프로젝트번호:"+likeProject+", 유저번호:"+likeUser+", 좋아요/알람:"+interestAlarm);	
	}

}
