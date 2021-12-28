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
		
		String selectSQL = "SELECT o.payment_date"
				+ "    ,o.payment_no "
				+ "    ,p.project_image "
				+ "    ,o.project_no "
				+ "    ,p.long_title "
				+ "    ,p.project_url "
				+ "    ,p.end_date "
				+ "    ,r.reward_no "
				+ "    ,r.deliver_date "
				+ "    ,o.total_price "
				+ "    ,o.payment_result "
				+ " FROM orders o "
				+ " JOIN project p "
				+ "    ON o.project_no=p.project_no "
				+ " JOIN reward r "
				+ "    ON r.reward_no=o.reward_no "
				+ " WHERE o.user_no=?";
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery(); 
		    System.out.println("1");
			while(rs.next()) {
				
	
				System.out.println(111111);
				//Orders Table
				Date paymentDate = rs.getDate("payment_date");
				System.out.println(111111);
				int paymentNo = rs.getInt("payment_no");
				System.out.println(111111);
				int totalPrice = rs.getInt("total_price");
				System.out.println(111111);
				String paymentResult = rs.getString("payment_result");
				System.out.println(111111);
				Order o = new Order();
				
				o.setPaymentDate(paymentDate);
				o.setPaymentNo(paymentNo);
				o.setTotalPrice(totalPrice);
				o.setPaymentResult(paymentResult);
				
				
				//[JOIN]Project Table
				String projectImage = rs.getString("project_image");
				String longTitle = rs.getString("long_title"); 
				String projectUrl = rs.getString("project_url");
				int	projectNo = rs.getInt("project_no");
				Date endDate = rs.getDate("end_date");
				
				System.out.println(22222222);
				Project joinedP = new Project();
				joinedP.setProjectImage(projectImage);
				joinedP.setLongTitle(longTitle);
				joinedP.setProjectUrl(projectUrl);
				joinedP.setEndDate(endDate);
				joinedP.setProjectNo(projectNo);
				
				o.setProject(joinedP);
				
			
				//[JOIN] Reward Table
				int rewardNo = rs.getInt("reward_no");
				int deliverDate = rs.getInt("deliver_date");
				System.out.println(333333333);
				
				Reward joinedR = new Reward();
				joinedR.setRewardNo(rewardNo);
				joinedR.setDeliverDate(deliverDate);
				o.setReward(joinedR);
				
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
	
