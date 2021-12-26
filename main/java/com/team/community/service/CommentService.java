package com.team.community.service;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.project.dao.CommentsDAOOracle;
import com.team.project.vo.Comments;


public class CommentService {
	static CommentService service = new CommentService();
	CommentsDAOOracle dao = CommentsDAOOracle.getInstance();
	public static CommentService getInstance() {
		return service;
	}
	public List<Comments> findPostNo(int postNo) throws FindException{
		return dao.findPostNo(postNo);
	}
	
	public List<Comments> findByPostNo(int postNo) throws FindException{		
		return dao.findByPostNo(postNo);
	}
	
	public void add(Comments comm) throws AddException{
		dao.add(comm);
	}

}
