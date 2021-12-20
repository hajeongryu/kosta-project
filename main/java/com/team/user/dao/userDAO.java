package com.team.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.sql.MyConnection;
import com.team.user.vo.Users;

public class userDAO {
	private static userDAO dao = new userDAO();
	private userDAO() {}
	public static userDAO getInstance() {
		return dao;
	}
	public void add(Users user) throws AddException {
		
	}
	public void findById(String id) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			String selectAllSQL = "";
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
