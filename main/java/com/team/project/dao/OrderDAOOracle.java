package com.team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team.exception.FindException;
import com.team.order.vo.Order;
import com.team.project.vo.Category;
import com.team.project.vo.Project;
import com.team.project.vo.ProjectChange;
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
		
		String selectSQL = "SELECT o.payment_result\r\n"
				+ "    ,o.payment_date\r\n"
				+ "    ,p.end_date\r\n"
				+ "    ,o.payment_no\r\n"
				+ "    ,p.project_image\r\n"
				+ "    ,p.long_title\r\n"
				+ "    ,r.deliver_select\r\n"
				+ "    ,r.reward_name\r\n"
				+ "    ,r.item_name\r\n"
				+ "    ,r.deliver_date\r\n"
				+ "    ,o.total_price\r\n"
				+ "    ,p.project_url\r\n"
				+ "FROM orders o JOIN project p ON o.project_no=p.project_no\r\n"
				+ "            JOIN reward r ON r.reward_no=o.reward_no\r\n"
				+ "WHERE o.user_no=?";
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
	
				//Orders Table
				String paymentResult = rs.getString("payment_result");
				Date paymentDate = rs.getDate("payment_date");
				int paymentNo = rs.getInt("payment_no");
				int totalPrice = rs.getInt("total_price");
				Order o = new Order();

				o.setPaymentResult(paymentResult);
				o.setPaymentDate(paymentDate);
				o.setPaymentNo(paymentNo);
				o.setTotalPrice(totalPrice);
				
				
				//[JOIN]Project Table
				Date endDate = rs.getDate("end_date");
				String projectImage = rs.getString("project_image");
				String longTitle = rs.getString("long_title"); 
				String projectUrl = rs.getString("project_url");

				Project project = new Project();
				project.setEndDate(endDate);
				project.setProjectImage(projectImage);
				project.setLongTitle(longTitle);
				project.setProjectUrl(projectUrl);
				
				o.setProject(project);
				
			
				//[JOIN] Reward Table
				String deliverSelect = rs.getString("deliver_select");
				String rewardName = rs.getString("reward_name");
				String itemName = rs.getString("item_name");
				int deliverDate = rs.getInt("deliver_date");
				
				Reward reward = new Reward();
				reward.setDeliverSelect(deliverSelect);
				reward.setRewardName(rewardName);
				reward.setItemName(itemName);
				reward.setDeliverDate(deliverDate);
				o.setReward(reward);
				
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
	
	public Order findByPaymentNo(int payment_no) throws FindException {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		Order o = new Order();
		
		String selectSQL = "SELECT o.payment_result\r\n"
				+ "    ,o.payment_date\r\n"
				+ "    ,p.end_date\r\n"
				+ "    ,o.payment_no\r\n"
				+ "    ,p.project_image\r\n"
				+ "    ,p.long_title\r\n"
				+ "    ,r.deliver_select\r\n"
				+ "    ,r.reward_name\r\n"
				+ "    ,r.item_name\r\n"
				+ "    ,r.deliver_date\r\n"
				+ "    ,o.total_price\r\n"
				+ "    ,p.project_url\r\n"
				+ "    ,c.card_num\r\n"
				+ "    ,a.receiver_name\r\n"
				+ "    ,a.receiver_phone\r\n"
				+ "    ,a.receiver_zipcode\r\n"
				+ "    ,a.receiver_address\r\n"
				+ "    ,a.receiver_address_detailed\r\n"
				+ "    ,cate.category_name\r\n"
				+ "    ,u.user_name\r\n"
				+ "    ,pc.sum_price\r\n"
				+ "    ,p.target_price\r\n"
				+ "FROM orders o JOIN project p ON o.project_no=p.project_no\r\n"
				+ "            JOIN reward r ON r.reward_no=o.reward_no\r\n"
				+ "            JOIN card c ON o.card_no = c.card_no\r\n"
				+ "            JOIN address a ON o.address_no = a.address_no\r\n"
				+ "            JOIN category cate ON cate.category_no = p.category_no\r\n"
				+ "            JOIN users u ON p.user_no = u.user_no\r\n"
				+ "            JOIN project_change pc ON p.project_no = pc.project_no\r\n"
				+ "WHERE o.payment_no=?";
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, payment_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
	
				//Orders Table
				String paymentResult = rs.getString("payment_result");
				Date paymentDate = rs.getDate("payment_date");
				int paymentNo = payment_no;
				int totalPrice = rs.getInt("total_price");

				o.setPaymentResult(paymentResult);
				o.setPaymentDate(paymentDate);
				o.setPaymentNo(paymentNo);
				o.setTotalPrice(totalPrice);
				
				//[JOIN]Category Table
				String categoryName = rs.getString("category_name");
				
				Category cate = new Category();
				cate.setCategoryName(categoryName);
				
				//[JOIN]Users Table
				String userName = rs.getString("user_name");
				
				Users user = new Users();
				user.setUserName(userName);
				
				//[JOIN]Project Change Table
				int sumPrice = rs.getInt("sum_price");
				
				ProjectChange pc = new ProjectChange();
				pc.setSumPrice(sumPrice);
				
				//[JOIN]Project Table
				Date endDate = rs.getDate("end_date");
				String projectImage = rs.getString("project_image");
				String longTitle = rs.getString("long_title"); 
				String projectUrl = rs.getString("project_url");
				int targetPrice = rs.getInt("target_price");

				Project project = new Project();
				project.setEndDate(endDate);
				project.setProjectImage(projectImage);
				project.setLongTitle(longTitle);
				project.setProjectUrl(projectUrl);
				project.setTargetPrice(targetPrice);
				
				project.setCategory(cate);
				project.setMaker(user);
				project.setProjectChange(pc);
				o.setProject(project);
				
			
				//[JOIN] Reward Table
				String deliverSelect = rs.getString("deliver_select");
				String rewardName = rs.getString("reward_name");
				String itemName = rs.getString("item_name");
				int deliverDate = rs.getInt("deliver_date");
				
				Reward reward = new Reward();
				reward.setDeliverSelect(deliverSelect);
				reward.setRewardName(rewardName);
				reward.setItemName(itemName);
				reward.setDeliverDate(deliverDate);
				o.setReward(reward);
				
				//[JOIN] Card Table
				String cardNum = rs.getString("card_num");
				
				Card card = new Card();
				card.setCardNum(cardNum);
				o.setCard(card);
				
				//[JOIN] Address Table
				String receiverName = rs.getString("receiver_name");
				String receiverPhone = rs.getString("receiver_phone");
				int receiverZipcode = rs.getInt("receiver_zipcode");
				String receiverAddress = rs.getString("receiver_address");
				String receiverAddressDetailed = rs.getString("receiver_address_detailed");
				
				Address address = new Address();
				address.setReceiverName(receiverName);
				address.setReceiverPhone(receiverPhone);
				address.setReceiverZipcode(receiverZipcode);
				address.setReceiverAddress(receiverAddress);
				address.setReceiverAddressDetailed(receiverAddressDetailed);
				o.setAddress(address);
			}
			return o;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
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
//	public static void main(String[] args) {
//		OrderDAOOracle dao= OrderDAOOracle.getInstance();
//		Order o = new Order();
//		try {
//			o = dao.findByPaymentNo(1);
//			System.out.println(o.getPaymentResult());
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
	
