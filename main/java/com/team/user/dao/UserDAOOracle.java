package com.team.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.sql.MyConnection;
import com.team.user.vo.Users;

public class UserDAOOracle implements UserDAOInterface {
	private static UserDAOOracle dao = new UserDAOOracle();
	private UserDAOOracle() {}
	public static UserDAOOracle getInstance() {
		return dao;
	}
	@Override
	public Users findByUserId(String userId) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			String selectSQL = "SELECT * FROM users WHERE user_id=?";
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int userNo = rs.getInt("user_no");
				String userRole = rs.getString("user_role");
				String userImage = rs.getString("user_image");
				String userName = rs.getString("user_name");
				String userPwd = rs.getString("user_pwd");
				String userPhone = rs.getString("user_phone");
				String userIntroduction = rs.getString("user_introduction");
				String userWebsite = rs.getString("user_website");
				String userUrl = rs.getString("user_url");
				Date userSignupDate = rs.getDate("user_signup_date");
				String userStatus = rs.getString("user_status");
				Users u = new Users(userNo, userRole, userId, userName, userPwd, userSignupDate, 
						userStatus, userImage, userPhone, userIntroduction, userWebsite, userUrl);
				return u;
			} else {
				throw new FindException("아이디에 해당하는 고객이 없습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		
	}
	@Override
	public Users findByUserNo(int userNo) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			String selectSQL = "SELECT * FROM users WHERE user_no=?";
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userRole = rs.getString("user_role");
				String userId = rs.getString("user_id");
				String userImage = rs.getString("user_image");
				String userName = rs.getString("user_name");
				String userPwd = rs.getString("user_pwd");
				String userPhone = rs.getString("user_phone");
				String userIntroduction = rs.getString("user_introduction");
				String userWebsite = rs.getString("user_website");
				String userUrl = rs.getString("user_url");
				Date userSignupDate = rs.getDate("user_signup_date");
				String userStatus = rs.getString("user_status");
				Users u = new Users(userNo, userRole, userId, userName, userPwd, userSignupDate, 
						userStatus, userImage, userPhone, userIntroduction, userWebsite, userUrl);
				return u;
			} else {
				throw new FindException("아이디에 해당하는 고객이 없습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		
	}
	@Override
	public void addUser(Users user) throws AddException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modifyProfile(Users user) throws ModifyException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modifyInfo(Users user) throws ModifyException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modifyfStatus(Users user) throws ModifyException {
		// TODO Auto-generated method stub
		
	}

}


