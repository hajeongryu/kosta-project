package com.team.interest.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.project.vo.Category;
import com.team.project.vo.Project;
import com.team.project.vo.ProjectChange;
import com.team.sql.MyConnection;
import com.team.user.vo.Interest;
import com.team.user.vo.Users;

public class InterestDAOOracle implements InterestDAOInterface {
	private static InterestDAOOracle dao = new InterestDAOOracle();
	private InterestDAOOracle() {
		
	}
	public static InterestDAOOracle getInstance() {
		return dao;
	}
	@Override 
	public Boolean findInterest(int projectNo, int userNo) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection(); //DB와 연결

			String selectSQL = "SELECT * FROM interest WHERE project_no=? and user_no=?";
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, projectNo);
			pstmt.setInt(2, userNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String interestAlarm = rs.getString("interest_alarm");
				return true;
			}
			throw new FindException("좋아요/알림 누르지 않음");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결닫기
			MyConnection.close(rs, pstmt, con);
		}
		return null;
	}

	@Override
	public void clickInterest(int projectNo, int userNo, String interestAlarm) throws AddException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 좋아요/알림 눌려 있는지 확인
			findInterest(projectNo, userNo);
			
			// 눌려있는데 다시 눌렀으므로 삭제
			try {
				con = MyConnection.getConnection(); //DB와 연결
				
				String deleteSQL = "DELETE FROM interest WHERE project_no=? and user_no=?";
				pstmt = con.prepareStatement(deleteSQL);
				pstmt.setInt(1, projectNo);
				pstmt.setInt(2, userNo);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (FindException e) {
			// 안눌려있으므로 좋아요/알림 추가
			try {
				System.out.println("좋아요/알림 존재하지 않음");
				con = MyConnection.getConnection(); //DB와 연결
				
				String insertSQL = "INSERT INTO interest(project_no, user_no, interest_alarm) VALUES(?,?,?)";
				pstmt = con.prepareStatement(insertSQL);
				pstmt.setInt(1,projectNo);
				pstmt.setInt(2, userNo);
				pstmt.setString(3, interestAlarm);
				pstmt.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				// 5. DB연결닫기
				MyConnection.close(pstmt, con);
			}
		}
	}
	@Override
	public List<Interest> findByUserNo(int userNo) throws FindException {
		String selectSQL = "SELECT i.project_no"
				+ "        ,i.interest_alarm"
				+ "        ,p.project_image "
				+ "        ,p.editor_pick "
				+ "        ,p.long_title "
				+ "        ,c.category_name "
				+ "        ,u.user_name "
				+ "        ,p.project_brief "
				+ "        ,p.target_price "
				+ "        ,pc.sum_price "
				+ "        ,pc.support_cnt "
				+ "        ,p.end_date "
				+ " FROM interest i "
				+ "    JOIN project p ON i.project_no = p.project_no "
				+ "    JOIN project_change pc ON i.project_no=pc.project_no "
				+ "    JOIN users u ON p.user_no = u.user_no "
				+ "    JOIN category c ON p.category_no=c.category_no "
				+ " WHERE i.user_no=?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection(); // DB연결
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			
			List<Interest> inters = new ArrayList<>();
			Interest inter = null;
			Project p = null;
			Users u = null;
			Category c = null;
			ProjectChange pc = null;
			while(rs.next()) {
				int project_no = rs.getInt("project_no");
				String interest_alarm = rs.getString("interest_alarm");
				String project_img = rs.getString("project_image");
				String editor_pick = rs.getString("editor_pick");
				String long_title = rs.getString("long_title");
				String category = rs.getString("category_name");
				String user_name = rs.getString("user_name"); // 창작자이름
				String brief = rs.getString("project_brief");
				int target_price = rs.getInt("target_price");
				int sum_price = rs.getInt("sum_price");
				int support_cnt = rs.getInt("support_cnt");
				Date end_date = rs.getDate("end_date");
		
				inter = new Interest();
				p = new Project();
				c = new Category();
				u = new Users();
				pc = new ProjectChange();
	
				p.setProjectNo(project_no);
				inter.setInterestAlarm(interest_alarm);
				p.setProjectImage(project_img);
				p.setEditorPick(editor_pick);
				p.setLongTitle(long_title);
				
				// Interest의 Project의 Category에 set
				c.setCategoryName(category);
				p.setCategory(c);
				
				u.setUserName(user_name);
				
				p.setProjectBrief(brief);
				p.setTargetPrice(target_price);
				
				// Interest의 Project의 ProjectChange에 set
				pc.setSumPrice(sum_price);
				pc.setSupportCnt(support_cnt);
				p.setProjectChange(pc);
				
				p.setEndDate(end_date);
				
				inter.setLikeProject(p);
				inter.setLikeUser(u);
				inters.add(inter);
			}
			if(inters.size()==0) {
				throw new FindException("좋아요/알람 없습니다");
			}
			return inters;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
	}
//	public static void main(String[] args) {
//		InterestDAOOracle dao = InterestDAOOracle.getInstance();
//		try {
//			List<Interest> i = new ArrayList<>();
//			i = dao.findByUserNo(1);
//			for(Interest a: i) {
//				System.out.print(a.getLikeProject().getProjectNo()+", ");
//				System.out.print(a.getInterestAlarm()+", ");
//				System.out.print(a.getLikeProject().getProjectImage()+", ");
//				System.out.print(a.getLikeProject().getEditorPick()+", ");
//				System.out.print(a.getLikeProject().getLongTitle()+", ");
//				System.out.print(a.getLikeProject().getCategory().getCategoryName()+", ");
//				System.out.print(a.getLikeUser().getUserName()+", ");
//				System.out.print(a.getLikeProject().getProjectBrief()+", ");
//				System.out.print(a.getLikeProject().getTargetPrice()+", ");
//				System.out.print(a.getLikeProject().getProjectChange().getSumPrice()+", ");
//				System.out.print(a.getLikeProject().getProjectChange().getSupportCnt()+", ");
//				System.out.println(a.getLikeProject().getEndDate());	
//			}
//		} catch (FindException e) {
//			e.printStackTrace();
//		}
//	}
}