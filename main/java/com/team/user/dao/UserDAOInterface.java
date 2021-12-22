package com.team.user.dao;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.user.vo.Users;

public interface UserDAOInterface {
	/**
	 * 아이디(이메일)로 검색
	 * @param id
	 * @return
	 * @throws FindException
	 */
	public Users findByUserId(String id) throws FindException;
	/**
	 * 회원번호로 검색
	 * @param userNO
	 * @return
	 * @throws FindException
	 */
	public Users findByUserNo(int userNO) throws FindException;
	/**
	 * 사용자 추가
	 * @param user
	 * @throws AddException
	 */
	public void addUser(Users user) throws AddException;
	/**
	 * 프로필이미지, 이름, URL, 소개, 웹사이트 수정
	 * @param user
	 * @throws ModifyException
	 */
	public void modifyProfile(Users user) throws ModifyException;
	/**
	 * 아이디(이메일), 비밀번호, 연락처 수정
	 * @param user
	 * @throws ModifyException
	 */
	public void modifyInfo(Users user) throws ModifyException;
	/**
	 * 회원상태 수정 (활성/비활성)
	 * @param user
	 * @throws ModifyException
	 */
	public void modifyfStatus(Users user) throws ModifyException;
}
