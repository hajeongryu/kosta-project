package com.team.project.dao;

import com.team.exception.FindException;
import com.team.project.vo.DisplayProjectType;

public interface ProjectDAOInterface {
	
	public DisplayProjectType findByProjectNo(int projectNo) throws FindException;

}
