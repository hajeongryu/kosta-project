package com.team.user.dao;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.user.vo.Users;

public interface UserDAOInterface {
	
	/**
	 * 아이디(이메일)로 검색
	 * @param id
	 * @return 검색한 유저 반환
	 * @throws FindException
	 */
	public Users findByUserId(String userId) throws FindException;
	
	
	/**
	 * 회원번호로 검색
	 * @param userNO
	 * @return 검색한 유저 반환
	 * @throws FindException
	 */
	public Users findByUserNo(int userNo) throws FindException;
	
	
	/**
	 * 사용자 추가
	 * @param user UserService에서 입력하는 user
	 * @throws AddException
	 */
	public void addUser(Users user) throws AddException;
	
	
	/**
	 * 프로필이미지, 이름, URL, 소개, 웹사이트 수정
	 * @param user UserService에서 입력하는 user
	 * @throws ModifyException
	 */
	public void modifyProfile(Users user) throws ModifyException;
	
	
	/**
	 * 아이디(이메일), 비밀번호, 연락처 수정
	 * @param user UserService에서 입력하는 user
	 * @throws ModifyException
	 */
	public void modifyInfo(Users user) throws ModifyException;
	
	
	/**
	 * 회원탈퇴 (계정활성화는 2차 구현 예정)
	 * @param user UserService에서 입력하는 user
	 * @throws ModifyException
	 */
	public void modifyStatus(int userNo) throws ModifyException;
}
