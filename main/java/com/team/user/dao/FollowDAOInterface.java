package com.team.user.dao;

import com.team.exception.FindException;
import com.team.user.vo.Follow;

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
}
