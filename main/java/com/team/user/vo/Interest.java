package com.team.user.vo;

import com.team.project.vo.Category;
import com.team.project.vo.Project;
import com.team.project.vo.ProjectChange;

public class Interest {
	private Project	likeProject;
	private Users	likeUser;
	private String	interestAlarm;
	
	public Interest() {
		super();
	}
	public Interest(Project likeProject, Users likeUser, String interestAlarm) {
		super();
		this.likeProject = likeProject;
		this.likeUser = likeUser;
		this.interestAlarm = interestAlarm;
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
}
