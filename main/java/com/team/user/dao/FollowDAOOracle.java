package com.team.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team.exception.FindException;
import com.team.project.vo.Comments;
import com.team.project.vo.Community;
import com.team.sql.MyConnection;
import com.team.user.vo.Follow;
import com.team.user.vo.Users;

public class FollowDAOOracle implements FollowDAOInterface {
	private static FollowDAOOracle dao = new FollowDAOOracle();
	private FollowDAOOracle() {}
	public static FollowDAOOracle getInstance() {
		return dao;
	}
	private UserDAOOracle userDao = UserDAOOracle.getInstance();
	@Override
	public Follow findFollowerByUserNo(int userNo) throws FindException {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		String selectSQL =  "select follow from follow"
				+ "where user_no=?";
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery(); 
			List<Users> users = new ArrayList<>();
			while(rs.next()) {		
				int	follow = rs.getInt("follow");
				Users u = userDao.findByUserNo(follow);
				users.add(u);
			}
			if(users.isEmpty()) {
				throw new FindException("아직 팔로워가 없습니다");
			}	
			Follow f = new Follow(userNo,users);
			return f;
		} catch (SQLException e) { //팔로워가 없을 경우 수행
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
		}	
	}

		
	@Override
	public Follow findFollowingByUserNo(int userNo) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

}
