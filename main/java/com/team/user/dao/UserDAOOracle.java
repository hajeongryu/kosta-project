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
				return null;
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
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertDML = "INSERT INTO users(user_name, user_id, user_pwd) VALUES (?,?,?)";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(insertDML);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserId());
			//userId 중복은 UserService signup에서 처리
			pstmt.setString(3, user.getUserPwd());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(pstmt, con);
		}
	}
	
	
	@Override
	public void modifyProfile(Users user) throws ModifyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String profileUpdateDML="UPDATE users SET user_image=?,"
										+ " user_name=?,"
										+ " user_url=?,"
										+ " user_introduction=?,"
										+ " user_website=?"
										+ " WHERE user_no=?";
		int userNo = user.getUserNo();
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(profileUpdateDML);
			pstmt.setString(1, user.getUserImage());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserUrl());
			pstmt.setString(4, user.getUserIntroduction());
			pstmt.setString(5, user.getUserWebsite());
			pstmt.setInt(6, userNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			int errorCode = e.getErrorCode();
			if(errorCode == 1) {
				throw new ModifyException("이미 존재하는 URL입니다");
			} else {
				e.printStackTrace();
				throw new ModifyException(e.getMessage());
			}
		} finally {
			MyConnection.close(pstmt, con);
		}
	}
	
	
	@Override
	public void modifyInfo(Users user) throws ModifyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String infoUpdateDML = "UPDATE users SET user_id=?,"
											+ " user_pwd=?,"
											+ " user_phone=?"
											+ " WHERE user_no=?";
		int userNo = user.getUserNo();
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(infoUpdateDML);
			pstmt.setString(1, user.getUserId());
			//userId 중복은 UserService signup에서 처리
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getUserPhone());
			pstmt.setInt(4, userNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(pstmt, con);
		}
	}
	
	
	@Override
	public void modifyStatus(int userNo) throws ModifyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String statusUpdateDML = "UPDATE users SET user_status=0 WHERE user_no=?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(statusUpdateDML);
			pstmt.setInt(1, userNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(pstmt, con);
		}
	}
	
}


