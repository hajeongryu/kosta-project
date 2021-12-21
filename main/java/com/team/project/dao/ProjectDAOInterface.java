package com.team.project.dao;

import com.team.exception.FindException;
import com.team.project.vo.Project;

public interface ProjectDAOInterface {
	
	public Project findByProjectNo(String projectNo) throws FindException;

}
