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
	private static CommentsDAOOracle dao = new CommentsDAOOracle();
	private CommentsDAOOracle() {
		
	}
	public static CommentsDAOOracle getInstance() {
		return dao;
	}

	@Override
	public List<Comments> findComment() throws FindException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Comments> findPostNo(int paramPostNo) throws FindException {
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신

		String selectPostNoSQL = "SELECT * FROM comments WHERE post_no = ?";

		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectPostNoSQL);
			pstmt.setInt(1, paramPostNo);
			rs = pstmt.executeQuery();

			List<Comments> comments = new ArrayList<>();
			Comments comment = null;

			while(rs.next()) {
				
				String	commentContent = rs.getString("comment_content");
				Date	commentdt = rs.getDate("comment_date");   
				int		commentNo = rs.getInt("comment_no");
				int     postNo = rs.getInt("post_no");
				int userNo = rs.getInt("user_no");
				
				comment = new Comments();
				
				comment.setCommentDate(commentdt);
				comment.setCommentContent(commentContent);
				comment.setCommentNo(commentNo);
				
				//post
				Community post = new Community();
				post.setPostNo(postNo);
				comment.setPost(post);
				
				//user
				Users u = new Users();
				u.setUserNo(userNo);
				comment.setMaker(u);
				
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
	public List<Comments> findByPostNo(int paramPostNo) throws FindException {
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신

		String selectPostNoSQL = "SELECT user_name"
				+ ", comment_no"
				+ ", comment_content"
				+ ", comment_date"
				+ ", post_no"
				+ " FROM comments com JOIN users u ON com.user_no=u.user_no"
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
				int		commentNo = rs.getInt("comment_no");
				int     postNo = rs.getInt("post_no");
				
				comment = new Comments();
				
				comment.setCommentDate(commentdt);
				comment.setCommentContent(commentContent);
				comment.setCommentNo(commentNo);
				
				//post
				Community post = new Community();
				post.setPostNo(postNo);
				comment.setPost(post);
				
				//user
				Users u = new Users();
				u.setUserName(userName);
				comment.setMaker(u);
												
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
			
			int postNo = comm.getPost().getPostNo();
			String commentCon = comm.getCommentContent();
			int userNo = comm.getMaker().getUserNo();
			
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


//	public int getSeq() {
//		Connection con = null; //DB연결
//		PreparedStatement pstmt = null; //SQL송신
//		ResultSet rs = null; //결과 수신
//
//        int result = 1;
//        try {
//        	con = MyConnection.getConnection();
//            // 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
//            StringBuffer sql = new StringBuffer();
//            sql.append("SELECT comments_SEQ.NEXTVAL FROM DUAL");
//			
//            pstmt = con.prepareStatement(sql.toString());
//            rs = pstmt.executeQuery(); // 쿼리 실행
// 
//            if (rs.next())    result = rs.getInt(1);
// 
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
// 
//        return result;
//    } 
       
     // 댓글 목록 가져오기
	public ArrayList<Comments> getList(int postNo, int commentNo){
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신

		String SQL = "SELECT * FROM comments WHERE post_no = ? AND comment_no= ? ORDER BY comment_no DESC"; 
		ArrayList<Comments> list = new ArrayList<Comments>();
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, postNo);
			pstmt.setInt(2, commentNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Comments cmt = new Comments();
				
				//post
				Community post = new Community();
				post.setPostNo(rs.getInt(1));
				cmt.setPost(post);
				
				cmt.setCommentNo(rs.getInt(2));
				cmt.setCommentContent(rs.getString(3));
				cmt.setCommentDate(rs.getDate(4));
				
				//user
				Users u = new Users();
				u.setUserNo(rs.getInt(5));
				cmt.setMaker(u);
				
				list.add(cmt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
//    public static void main(String[] args) {
//	CommentsDAOOracle dao = CommentsDAOOracle.getInstance();
//	List<Comments> c = new ArrayList<>();
//	//c = dao.findPostNo(1);
//	c = dao.getList(1, 1);
//	
//	for (Comments comments : c) {
//		System.out.println(comments.getMaker());
//		System.out.println(comments.getCommentNo());
//		System.out.println(comments.getCommentContent());
//		System.out.println(comments.getCommentDate());
//		System.out.println(comments.getPost());
//		
//	}
//	}

}
