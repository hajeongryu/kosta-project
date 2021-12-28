package com.team.user.dao;

import java.util.List;

import com.team.exception.FindException;
import com.team.user.vo.Follow;
import com.team.user.vo.Users;

public interface FollowDAOInterface {
	/**
	 * 팔로워(나(User_no를 기준으로)를 팔로우한 사람들)
	 * @param userNo
	 * @return
	 * @throws FindException 팔로워가 없는 경우에 예외 발생한다
	 */
	public Follow findFollowerByUserNo(int userNo) throws FindException;
	
	/**
	 * 팔로잉(User_no이 팔로우한 사람들)
	 * @param userNo
	 * @return
	 * @throws FindException 팔로잉이 없는 경우에 예외 발생한다
	 */
	public Follow findFollowingByUserNo(int userNo) throws FindException;
	
	
	
	
	
	/**
	 * inUserNo를 좋아하는 사람들을 보여줘( inUserNO를 구독한 사람들을 보여줘?) 
	 * @param userNo
	 * @return List<Users>  Savant(inUserNO를 섬기는자)들
	 * @throws FindException 팔로워가 없는 경우에 예외 발생한다
	 */
	public List<Users> findFollowerByUserNoReturnUserList(int inUserNo) throws FindException;
	
	
	
	/**
	 * inUserNo가  좋아한(따르는) 사람들  (inUserNo가 구독한 사람들을 보여줘?) 
	 * @param userNo
	 * @return List<Users> Master(inUserNo가 섬기는자)
	 * @throws FindException 팔로잉이 없는 경우에 예외 발생한다
	 */
	public List<Users> findFollwingByUserNoReturnUserList(int inUserNo) throws FindException;
}
