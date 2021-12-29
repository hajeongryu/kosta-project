package com.team.community.service;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.project.dao.CommunityDAOOracle;
import com.team.project.vo.Community;
import com.team.project.vo.Project;

public class PostService {
	static PostService service = new PostService();
	CommunityDAOOracle dao = CommunityDAOOracle.getInstance();
	public static PostService getInstance() {
		return service;
	}
	public List<Community> findProjectNo(int projectNo) throws FindException{
		return dao.findProjectNo(projectNo);
	}
	
	public List<Community> findByProjectNo(int projectNo) throws FindException{		
		return dao.findByProjectNo(projectNo);
	}
	
	public void add(Community comm) throws AddException{
		//Project p = dao.findByProjectNo(comm.getProject().getProjectNo());
		dao.add(comm);
	}
	
}
