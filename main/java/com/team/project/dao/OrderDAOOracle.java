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
import com.team.order.vo.Order;
import com.team.project.vo.Project;
import com.team.project.vo.Reward;
import com.team.sql.MyConnection;
import com.team.user.vo.Address;
import com.team.user.vo.Card;
import com.team.user.vo.Users;

public class OrderDAOOracle implements OrderDAOInterface {
	public static OrderDAOOracle dao = new OrderDAOOracle();
	public OrderDAOOracle() {}
	public static OrderDAOOracle getInstance() {
		return dao;		
	}
	

	@Override
	public List<Order> findByUserNo(int userNo) throws FindException {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		List<Order> orderlist = new ArrayList<Order>();
		
		String selectSQL = "SELECT o.payment_date \"결제완료일\"\r\n"
				+ "    ,o.payment_no \"후원번호\"\r\n"
				+ "    ,p.project_image \"프로젝트 이미지\"\r\n"
				+ "    ,o.project_no \"프로젝트 번호\"\r\n"
				+ "    ,p.long_title \"프로젝트 제목\"\r\n"
				+ "    ,p.project_url \"프로젝트 페이지 주소\"\r\n"
				+ "    ,p.end_date \"종료일\"\r\n"
				+ "    ,r.reward_no \"선물 번호\"\r\n"
				+ "    ,r.deliver_date \"예상전달일\"\r\n"
				+ "    ,o.total_price \"총 결제금액\"\r\n"
				+ "    ,o.payment_result \"결제상태\"\r\n"
				+ " FROM orders o\r\n"
				+ " JOIN project p\r\n"
				+ "    ON o.project_no=p.project_no\r\n"
				+ " JOIN reward r\r\n"
				+ "    ON r.reward_no=o.reward_no\r\n"
				+ " WHERE o.user_no=?";
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery(); 
			Order o = null;
			Project p = null;
			Reward r = null;
		    System.out.println("1");
			while(rs.next()) {
				
				
				//Project Table
				String projectImage = rs.getString("project_image");
				
				String longTitle = rs.getString("long_title"); 
				String projectUrl = rs.getString("project_url");
				java.sql.Date endDate = rs.getDate("end_date");
				String projectContent = rs.getString("project_content"); 
				int targetPrice = rs.getInt("target_price");
				
				p = new Project();
				
				//[JOIN] Orders Table
				Date paymentDate = rs.getDate("payment_date");
				int paymentNo = rs.getInt("payment_no");
				int	projectNo = rs.getInt("project_no");
				int totalPrice = rs.getInt("total_price");
				String paymentResult = rs.getString("payment_result");
				
				o = new Order();
				
				o.setPaymentDate(paymentDate);
				o.setPaymentNo(paymentNo);
				p.setProjectNo(projectNo);
				o.setTotalPrice(totalPrice);
				o.setPaymentResult(paymentResult);
				
				//[JOIN] Reward Table
				int rewardNo = rs.getInt("reward_no");
				int deliverDate = rs.getInt("deliver_date");
				
				r = new Reward();
				
				r.setRewardNo(rewardNo);
				r.setDeliverDate(deliverDate);
				
				orderlist.add(o);
			}	
			if(orderlist.isEmpty()) {
				throw new FindException("후원 내역이 없습니다.");
			}
			return orderlist;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new FindException();
		}finally {
			MyConnection.close(rs,pstmt,con);
		}
	}
	
	
	
	@Override
	public void add(Order order) throws FindException {
		Connection con = null; 
		PreparedStatement stmt = null; 
		ResultSet rs = null; 
		
		String insertSQL = 
				"INSERT INTO orders(user_no, extra_price, total_price, payment_result, address_no, card_no, reward_no)\r\n"
						+ " VALUES('?','?','?','?','?','?','?')";
	
		
		try {
			con = MyConnection.getConnection();
			stmt = con.prepareStatement(insertSQL);
			rs = stmt.executeQuery(insertSQL);
			
			int paymentNo = order.getPaymentNo();
			int userNo = order.getOrderUser().getUserNo();
			Date paymentDate = order.getPaymentDate();
			int extraPrice = order.getExtraPrice();
			int totalPrice = order.getTotalPrice();
			String paymentResult = order.getPaymentResult();
			int addressNo = order.getAddress().getAddressNo();
			int rewardNo = order.getReward().getRewardNo();
			int cardNo = order.getCard().getCardNo();
			
			stmt.setInt(1, userNo);
			stmt.setInt(2, extraPrice);
			stmt.setInt(3, totalPrice);
			stmt.setString(4, paymentResult);
			stmt.setInt(5, addressNo);
			stmt.setInt(6, rewardNo);
			stmt.setInt(7, cardNo);
			stmt.executeUpdate(); 
			
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
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(stmt, con);
		}
	}
	public static void main(String[] args) {
		OrderDAOOracle dao= OrderDAOOracle.getInstance();
		List<Order> o = new ArrayList<>();
		try {
			o = dao.findByUserNo(1);
			for(Order a: o) {
				System.out.println(a.getPaymentNo());
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	
