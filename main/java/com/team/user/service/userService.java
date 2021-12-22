package com.team.user.service;

import com.team.exception.FindException;
import com.team.user.dao.UserDAOOracle;
import com.team.user.vo.Users;

public class UserService {
	private UserDAOOracle dao = UserDAOOracle.getInstance();
	private static UserService service = new UserService();
	private UserService() {}
	public static UserService getInstance() {
		return service;
	}
	public Users login(String userId, String userPwd) throws FindException {
		try {
			Users u = dao.findByUserId(userId);
			if(u.getUserPwd().equals(userPwd)) {
				return u;
			}
			throw new FindException();
		} catch (FindException e) {
			throw new FindException("로그인 실패");
		}
	}
}
