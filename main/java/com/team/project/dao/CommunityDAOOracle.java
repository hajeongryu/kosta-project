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
	public List<Community> findProjectNo(int paramProjectNo) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectProjectNoSQL = "SELECT * FROM community WHERE project_no = ?";
		
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectProjectNoSQL);
			pstmt.setInt(1, paramProjectNo);
			rs = pstmt.executeQuery();
			
			List<Community> posts = new ArrayList<>();
			Community post = null;
//			List<Comments> comments = null;
//			Comments comment = null;

			while(rs.next()) {			
				int 	userNo = rs.getInt("user_no");
				int		postNo = rs.getInt("post_no");
				String	postContent = rs.getString("post_content");
				Date	postDt = rs.getDate("post_date");
				int		projectNo = rs.getInt("project_no");
				
				
				post = new Community();
				post.setPostDate(postDt);
				post.setPostContent(postContent);
				post.setPostNo(postNo);
				
				Project p = new Project();
				p.setProjectNo(projectNo);
				post.setProject(p);
				
				//user
				Users u = new Users();
				u.setUserNo(userNo);
				post.setMaker(u);
				
//				//List<comments>
//				comments = new ArrayList<>();
//				post.setComments(comments);
				
				
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
	public List<Community> findByProjectNo(int paramPjNo) throws FindException {
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신

		String selectProjectNoSQL = "SELECT user_name"
				+ ", post_no"
				+ ", post_content"
				+ ", post_date"
				+ " FROM community c JOIN users u ON c.user_no=u.user_no"
				+ " WHERE project_no = ?";

		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectProjectNoSQL);
			pstmt.setInt(1, paramPjNo);
			rs = pstmt.executeQuery();

			List<Community> posts = new ArrayList<>();
			Community post = null;
			//List<Comments> comments = null;


			while(rs.next()) {			
				String  userName = rs.getString("user_name");
				int		postNo = rs.getInt("post_no");
				String	postContent = rs.getString("post_content");
				Date	postDt = rs.getDate("post_date");   
				
				post = new Community();
				post.setPostDate(postDt);
				post.setPostContent(postContent);
				post.setPostNo(postNo);
				
				//user
				Users u = new Users();
				u.setUserName(userName);
				post.setMaker(u);
				
//				//List<comments>
//				comments = new ArrayList<>();
//				post.setComments(comments);
				
				
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
		Connection con = null; 
		PreparedStatement pstmt = null; 
		
		String insertInfoSQL =
				" INSERT INTO community(post_no, project_no, post_content, post_date, user_no)"
						+ " VALUES(COMMUNITY_SEQ.NEXTVAL,?,?,SYSDATE,?)";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(insertInfoSQL);
			//오토커밋해제
			con.setAutoCommit(false);
			
			int projectNo = comm.getProject().getProjectNo();
			System.out.println(projectNo);
			String postCon = comm.getPostContent();
			System.out.println(postCon);
			int userNo = comm.getMaker().getUserNo();
			System.out.println(userNo);
			
			pstmt.setInt(1, projectNo);
			pstmt.setString(2, postCon);
			System.out.println(5);
			pstmt.setInt(3, userNo);
			System.out.println(6);
			pstmt.executeUpdate(); 
			
			//커밋
			con.commit();
		}catch(Exception e) {
			if(con != null) {
				try {
					//커밋실패
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
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MyConnection.getConnection();
			String deleteSQL = "DELETE FROM community WHERE post_no = ?";
			pstmt = con.prepareStatement(deleteSQL);
			int postNo = comm.getPostNo();
			pstmt.setInt(1, postNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(pstmt, con);
		}

	}
	
	
	public static void main(String[] args) {
		CommunityDAOOracle dao = CommunityDAOOracle.getInstance();
		List<Community> c = new ArrayList<>();
		try {
			c = dao.findProjectNo(1);
		
			for (Community community : c) {
				System.out.println(community.getPostNo());
				System.out.println(community.getMaker());
				System.out.println(community.getPostContent());
				System.out.println(community.getPostDate());
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
