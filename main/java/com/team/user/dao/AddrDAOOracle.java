package com.team.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.sql.MyConnection;
import com.team.user.vo.Address;
import com.team.user.vo.Users;

public class AddrDAOOracle implements AddrDAOInterface {
	private static AddrDAOOracle dao = new AddrDAOOracle();
	private AddrDAOOracle() {}
	public static AddrDAOOracle getInstance() {
		return dao;
	}
	private UserDAOOracle userDao = UserDAOOracle.getInstance();
	
	@Override
	public List<Address> findByUserNo(int userNo) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSQL ="SELECT * FROM address WHERE user_no=?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			List<Address> addrs = new ArrayList<>();
			while(rs.next()) {
				int addressNo = rs.getInt("address_no");
				String receiverName = rs.getString("receiver_name");
				int receiverZipcode = rs.getInt("receiver_zipcode");
				String receiverAddress = rs.getString("receiver_address");
				String receiverAddressDetailed = rs.getString("receiver_address_detailed");
				String receiverPhone = rs.getString("receiver_phone");
				String defaultAddress = rs.getString("default_address");
				
				Users u = userDao.findByUserNo(userNo);
				Address a = new Address(addressNo, u, receiverName, receiverZipcode, receiverAddress,
						receiverAddressDetailed, receiverPhone, defaultAddress);
				addrs.add(a);
			}
			if(addrs.size()==0) {
				return null;
			}
			return addrs;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		
		
	}

	@Override
	public Address findByAddressNo(int addressNo) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSQL ="SELECT * FROM address WHERE address_no=?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, addressNo);
			rs = pstmt.executeQuery();

			rs.next();
			int userNo = rs.getInt("user_no");
			String receiverName = rs.getString("receiver_name");
			int receiverZipcode = rs.getInt("receiver_zipcode");
			String receiverAddress = rs.getString("receiver_address");
			String receiverAddressDetailed = rs.getString("receiver_address_detailed");
			String receiverPhone = rs.getString("receiver_phone");
			String defaultAddress = rs.getString("default_address");
			
			Users u = userDao.findByUserNo(userNo);
			Address a = new Address(addressNo, u, receiverName, receiverZipcode, receiverAddress,
					receiverAddressDetailed, receiverPhone, defaultAddress);
			
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException("???????????? ?????? ???????????????");
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		
	}

	@Override
	public void addAddress(Address address) throws AddException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertDML = "INSERT INTO address (user_no, receiver_name,"
				+ " receiver_zipcode, receiver_address, receiver_address_detailed,"
				+ " receiver_phone, default_address) VALUES (?,?,?,?,?,?,?)";
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(insertDML);
			pstmt.setInt(1, address.getUser().getUserNo());
			pstmt.setString(2, address.getReceiverName());
			pstmt.setInt(3, address.getReceiverZipcode());
			pstmt.setString(4, address.getReceiverAddress());
			pstmt.setString(5, address.getReceiverAddressDetailed());
			pstmt.setString(6, address.getReceiverPhone());
			pstmt.setString(7, address.getDefaultAddress());
			pstmt.executeUpdate();
			if(address.getDefaultAddress().equals("1")) {
				dao.modifyDefaultAddress(address);
			}
			con.commit();
		} catch (SQLException | ModifyException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new AddException("?????? ????????? ??????????????????");
		} finally {
			MyConnection.close(pstmt, con);
		}

	}

	@Override
	public void modifyDefaultAddress(Address address) throws ModifyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		List<Address> addrs = new ArrayList<>();
		String selectSQL = "SELECT * FROM address WHERE user_no=?";
		String zeroUpdateDML ="UPDATE address SET default_address='0' WHERE user_no=?";
		String defaultUpdateDML = "UPDATE address SET default_address='1' WHERE address_no=?";
		try {
			con = MyConnection.getConnection();
			//????????? ???????????? ????????? ???????????? ???????????? ??????
			con.setAutoCommit(false);
			//userNo?????? ????????? ???????????? addrs ???????????? ??????
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, address.getUser().getUserNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String defaultAddress = rs.getString("default_address");
				Address a = new Address(address.getAddressNo(), defaultAddress);
				addrs.add(a);
			}
			//userNo?????? ????????? ????????? ????????? ??????
			if(addrs.size() == 0) {
				return;
			}
			//???????????? ????????? ??????????????? ?????????????????? defaultAddress ?????? 0?????? ??????
			pstmt2 = con.prepareStatement(zeroUpdateDML);
			pstmt2.setInt(1, address.getUser().getUserNo());
			pstmt2.executeUpdate();
			
			//?????????????????? ????????? ???????????? defaultCard 1??? ??????
			pstmt3 = con.prepareStatement(defaultUpdateDML);
			pstmt3.setInt(1, address.getAddressNo());
			pstmt3.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			MyConnection.close(pstmt, pstmt2, pstmt3, rs, con);
		}
		

	}

	@Override
	public void modifyAddress(Address address) throws ModifyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String infoUpdateDML = "UPDATE address SET receiver_name=?,"
				+ " receiver_zipcode=?, receiver_address=?,"
				+ " receiver_address_detailed=?, receiver_phone=?,"
				+ " default_address=? WHERE address_no=?";
		
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(infoUpdateDML);
			pstmt.setString(1, address.getReceiverName());
			pstmt.setInt(2, address.getReceiverZipcode());
			pstmt.setString(3, address.getReceiverAddress());
			pstmt.setString(4, address.getReceiverAddressDetailed());
			pstmt.setString(5, address.getReceiverPhone());
			pstmt.setString(6, address.getDefaultAddress());
			pstmt.setInt(7, address.getAddressNo());
			pstmt.executeUpdate();
			if(address.getDefaultAddress().equals("1")) {
				dao.modifyDefaultAddress(address);
			}
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			MyConnection.close(pstmt, con);
		}

	}

	@Override
	public void removeAddress(Address address) throws RemoveException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String deleteDML= "DELETE FROM address WHERE address_no=?";
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(deleteDML);
			pstmt.setInt(1, address.getAddressNo());
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			MyConnection.close(pstmt, con);
		}
		

	}

}
