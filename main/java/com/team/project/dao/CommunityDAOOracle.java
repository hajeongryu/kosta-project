package com.team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.RemoveException;
import com.team.project.vo.Comments;
import com.team.project.vo.Community;
import com.team.project.vo.Project;
import com.team.sql.MyConnection;
import com.team.user.vo.Users;

public class CommunityDAOOracle implements CommunityDAOInterface{

	private static CommunityDAOOracle dao = new CommunityDAOOracle();
	private CommunityDAOOracle() {
		
	}
	public static CommunityDAOOracle getInstance() {
		return dao;
	}
	
	
	@Override
	public List<Community> findAll() throws FindException {
		return null;
	}
	@Override
	public List<Community> findByProjectNo(int ProjectNo) throws FindException {
		
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신
	
		String selectProjectNoSQL = "SELECT user_name 작성자이름\r\n"
				+ "    , post_content 게시글내용\r\n"
				+ "    , post_date 작성일자\r\n"
				+ " FROM community c JOIN users u ON c.user_no=u.user_no"
				+ " WHERE project_no = ?";
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectProjectNoSQL);
			pstmt.setInt(1, ProjectNo);
			rs = pstmt.executeQuery();
	
		List<Community> posts = new ArrayList<>();
		Community post = null;
		List<Comments> comments = null;

		
		while(rs.next()) {			
			int		postNo = rs.getInt("post_no");        
			int		projectNo = rs.getInt("project_no");
			Date	postDt = rs.getDate("post_date");   
			String	postContent = rs.getString("post_content");
			int		userNo = rs.getInt("user_no");      
			
			
			post = new Community();
			post.setPostNo(postNo);
			post.setPostDate(postDt);
			comments = new ArrayList<>();
			post.setComments(comments);
			posts.add(post);
		}
		return posts;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new FindException(e.getMessage());
	} finally {
		MyConnection.close(rs, pstmt, con);
	}

	}
	@Override
	public void add(Community comm) throws AddException {
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신

		String insertInfoSQL =
				" INSERT INTO community(post_no, project_no, post_content, post_date, user_no)"
				+ " VALUES(post_seq.NEXTVAL,'?','?',SYSDATE,'?')";
		try {
			con = MyConnection.getConnection();//DB와 연결
			con.setAutoCommit(false); //자동커밋해제
						
		}catch(Exception e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
				}
			}
			throw new AddException(e.getMessage());
		}finally {
			MyConnection.close(pstmt, con);
		}

		
	}
	@Override
	public void remove(Community comm) throws RemoveException {
		// TODO Auto-generated method stub
		
	}
}
