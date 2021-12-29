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
import com.team.project.vo.Project;
import com.team.project.vo.Reward;
import com.team.sql.MyConnection;
import com.team.user.vo.Address;
import com.team.user.vo.Card;

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
				+ "    ,c.card_num\r\n"
				+ "    ,a.receiver_name\r\n"
				+ "    ,a.receiver_phone\r\n"
				+ "    ,a.receiver_zipcode\r\n"
				+ "    ,a.receiver_address\r\n"
				+ "    ,a.receiver_address_detailed\r\n"
				+ "FROM orders o JOIN project p ON o.project_no=p.project_no\r\n"
				+ "            JOIN reward r ON r.reward_no=o.reward_no\r\n"
				+ "            JOIN card c ON o.card_no = c.card_no\r\n"
				+ "            JOIN address a ON o.address_no = a.address_no\r\n"
				+ "WHERE o.user_no=?";
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery(); 
		    System.out.println("1");
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
		
		String insertSQL = 
				" INSERT INTO orders(user_no, extra_price, total_price, payment_result, address_no, card_no, reward_no, project_no ) "
						+ " VALUES(?,?,?,?,?,?,?,?) ";
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
	
		
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(insertSQL);	
			//오토커밋해제
			con.setAutoCommit(false);
			
			int userNo = order.getOrderUser().getUserNo();
			System.out.println(userNo);
			int extraPrice = order.getExtraPrice();
			System.out.println(extraPrice);
			int totalPrice = order.getTotalPrice();
			System.out.println(totalPrice);
			String paymentResult = order.getPaymentResult();
			System.out.println(paymentResult);
			int addressNo = order.getAddress().getAddressNo();
			System.out.println(addressNo);
			int rewardNo = order.getReward().getRewardNo();
			System.out.println(rewardNo);
			int cardNo = order.getCard().getCardNo();
			System.out.println(cardNo);
			int ProjectNo = order.getProject().getProjectNo();
			System.out.println(ProjectNo);

			pstmt.setInt(1, userNo);
			pstmt.setInt(2, extraPrice);
			pstmt.setInt(3, totalPrice);
			pstmt.setString(4, paymentResult);
			pstmt.setInt(5, addressNo);
			pstmt.setInt(6, cardNo);
			pstmt.setInt(7, rewardNo);
			pstmt.setInt(8, ProjectNo);
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
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(pstmt, con);
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
	
