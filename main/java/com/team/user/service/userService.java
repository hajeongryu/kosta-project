package com.team.user.service;

import com.team.user.dao.userDAO;

public class userService {
	private userDAO dao = userDAO.getInstance();
	private static userService service = new userService();
	private userService() {}
	public static userService getInstance() {
		return service;
	}
	
}
