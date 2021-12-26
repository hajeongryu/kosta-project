package com.team.project.dao;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.RemoveException;
import com.team.project.vo.Community;

public interface CommunityDAOInterface {

	/**
	 * 전체 커뮤니티 게시글을 반환
	 * @return
	 * @throws FindException 커뮤니티게시글이 없는 경우 예외 발생
	 */
	public List<Community> findAll() throws FindException;
	
	/**
	 * 프로젝트 번호에 해당하는 커뮤니티 게시글을 반환(SELECT * FROM community WHERE project_no =?)
	 * @param ProjectNo 프로젝트번호
	 * @return
	 * @throws FindException
	 */
	public List<Community> findProjectNo(int ProjectNo) throws FindException;
	
	
	/**
	 * 프로젝트 번호에 해당하는 커뮤니티 게시글을 반환
	 * @param ProjectNo 프로젝트번호
	 * @return
	 * @throws FindException
	 */
	public List<Community> findByProjectNo(int ProjectNo) throws FindException;
	
	/**
	 * 커뮤니티 게시글을 추가한다
	 * @param comm
	 * @throws AddException 
	 */
	public void add(Community comm) throws AddException;
	
	/**
	 * 커뮤니티 게시글을 삭제한다
	 * @param comm
	 * @throws RemoveException
	 */
	public void remove(Community comm) throws RemoveException;
	
}
