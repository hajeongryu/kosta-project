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
	public Users findByUserId(String id) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			String selectSQL = "SELECT * FROM users WHERE user_id=?";
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int userNo = rs.getInt("userNo");
				String userRole = rs.getString("userRole");
				String userImage = rs.getString("userImage");
				String userName = rs.getString("userName");
				String userPwd = rs.getString("userPwd");
				String userPhone = rs.getString("userPhone");
				String userIntroduction = rs.getString("userIntroduction");
				String userWebsite = rs.getString("userWebsite");
				String userUrl = rs.getString("userUrl");
				Date userSignupDate = rs.getDate("userSignupDate");
				String userStatus = rs.getString("userStatus");
				Users u = new Users(userNo, userRole, id, userName, userPwd, userSignupDate, 
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
	public Users findByUserNo(int userNO) throws FindException {
		// TODO Auto-generated method stub
		return null;
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
