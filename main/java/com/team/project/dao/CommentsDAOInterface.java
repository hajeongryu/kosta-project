package com.team.project.dao;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.RemoveException;
import com.team.project.vo.Comments;
import com.team.project.vo.Community;

public interface CommentsDAOInterface {
	/**
	 * 커뮤니티의 모든 댓글을 반환
	 * @return
	 * @throws FindException
	 */
	public List<Comments> findComment() throws FindException;
	
	/**
	 * 커뮤니티 게시글을 추가한다
	 * @param comm
	 * @throws AddException 
	 */
	public void add(Comments comm) throws AddException;
	
	/**
	 * 커뮤니티 게시글을 삭제한다
	 * @param comm
	 * @throws RemoveException
	 */
	public void remove(Community comm) throws RemoveException;

	

}
