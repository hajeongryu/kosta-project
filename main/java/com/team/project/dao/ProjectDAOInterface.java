package com.team.project.dao;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.project.vo.Project;

public interface ProjectDAOInterface {
	/**
	 * 전체상품을 반환한다
	 * @return
	 * @throws FindException 프로젝트가 없는 경우에 예외발생
	 */
	public List<Project> findAll() throws FindException;
	
	/**
	 * 프로젝트 번호에 해당하는 상품을 반환
	 * @param ProjectNo 프로젝트번호
	 * @return 
	 * @throws FindException 프로젝트가 없는 경우 예외발생
	 */
	public Project findByProjectNo(int ProjectNo) throws FindException;
	
	public void add(Project project) throws AddException;
	public void modify(Project project) throws ModifyException;
	public void remove(int projectNo) throws RemoveException;
}