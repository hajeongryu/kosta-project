package com.team.user.service;

import java.util.List;

import com.team.exception.FindException;
import com.team.user.dao.FollowDAOOracle;
import com.team.user.vo.Users;

public class FollowService {
	private static FollowService service = new FollowService();
	private FollowService(){
	}
	
	public static FollowService getInstace() {
		return service;
	}
	private FollowDAOOracle dao = FollowDAOOracle.getInstance();
	
	
	
	//inUserNo의 마스터들
	public List<Users> getMaster(int inUserNo) throws FindException{
		return dao.findFollwingByUserNoReturnUserList(inUserNo);
	}
	

	//inUserNo의 서번트(섬기는자)들 
	public List<Users> getSavant(int inUserNo) throws FindException{
		return dao.findFollowerByUserNoReturnUserList(inUserNo);
	}
	
}
