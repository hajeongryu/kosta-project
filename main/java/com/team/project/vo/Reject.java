package com.team.project.vo;

/*
	`project_no`	NUMBER(8)	NOT NULL,
	`reject_reason`	VARCHAR2(100)	NULL
*/

public class Reject {
	private Project project;
	private String rejectReason;
	
	public Reject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reject(Project project, String rejectReason) {
		super();
		this.project = project;
		this.rejectReason = rejectReason;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
}
