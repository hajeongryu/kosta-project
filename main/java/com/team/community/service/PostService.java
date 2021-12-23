package com.team.community.service;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.project.dao.CommunityDAOOracle;
import com.team.project.vo.Community;

public class PostService {
	static PostService service = new PostService();
	CommunityDAOOracle dao = CommunityDAOOracle.getInstance();
	public static PostService getInstance() {
		return service;
	}
	
	public List<Community> findByProjectNo(int projectNo) throws FindException{
		return dao.findByProjectNo(projectNo);
	}
	
	public void add(Community comm) throws AddException{
		dao.add(comm);
	}
	
}
