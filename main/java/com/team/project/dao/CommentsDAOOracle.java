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
import com.team.sql.MyConnection;
import com.team.user.vo.Users;

public class CommentsDAOOracle implements CommentsDAOInterface {

	@Override
	public List<Comments> findComment() throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comments> findByPostNo(int paramPostNo) throws FindException {
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신

		String selectPostNoSQL = "SELECT user_name"
				+ ", comment_content"
				+ ", comment_date"
				+ " FROM comments com JOIN users u ON c.user_no=u.user_no"
				+ " WHERE post_no = ?";

		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectPostNoSQL);
			pstmt.setInt(1, paramPostNo);
			rs = pstmt.executeQuery();

			List<Comments> comments = new ArrayList<>();
			Comments comment = null;

			while(rs.next()) {			
				String  userName = rs.getString("user_name");
				String	commentContent = rs.getString("comment_content");
				Date	commentdt = rs.getDate("comment_date");   
								      
				comment = new Comments();
				comment.setCommentDate(commentdt);
				comment.setCommentContent(commentContent);
				
				//user
				Users u = new Users();
				u.setUserName(userName);
				comment.setUserNo(u);
												
				comments.add(comment);
			}
			return comments;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
		}

	}
	
	@Override
	public void add(Comments comm) throws AddException {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		
		
		String insertInfoSQL =
				"INSERT INTO comments(comment_no, post_no, comment_content, comment_date, user_no)\r\n"
				+ " VALUES(comment_seq.NEXTVAL,'?','?',SYSDATE,'?')";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(insertInfoSQL);
			//오토커밋해제
			con.setAutoCommit(false);
			
			int postNo = comm.getPostNo().getPostNo();
			String commentCon = comm.getCommentContent();
			int userNo = comm.getUserNo().getUserNo();
			
			pstmt.setInt(1, postNo);
			pstmt.setString(2, commentCon);
			pstmt.setInt(3, userNo);
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
	public void remove(Comments comm) throws RemoveException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MyConnection.getConnection();
			String deleteSQL = "DELETE FROM comments WHERE comment_no = ?";
			pstmt = con.prepareStatement(deleteSQL);
			int commentNo = comm.getCommentNo();
			pstmt.setInt(1, commentNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(pstmt, con);
		}

	}

}
