package com.team.user.service;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.user.dao.AddrDAOOracle;
import com.team.user.dao.UserDAOOracle;
import com.team.user.vo.Address;
import com.team.user.vo.Users;

public class AddrService {
	private AddrDAOOracle dao = AddrDAOOracle.getInstance();
	private static AddrService service = new AddrService();
	private AddrService() {}
	public static AddrService getInstance() {
		return service;
	}
	private UserDAOOracle userDao = UserDAOOracle.getInstance();
	
	
	public List<Address> findByUserNo(int userNo) throws FindException {
		List<Address> addrs = dao.findByUserNo(userNo);
		return addrs;
	}
	
	
	public void addAddrService(int userNo, String receiverName, int receiverZipcode, 
			String receiverAddress, String receiverAddressDetailed, String receiverPhone,
			String defaultAddress) throws AddException {
		try {
			Users u = userDao.findByUserNo(userNo);
			Address a = new Address(u, receiverName, receiverZipcode, receiverAddress,
					receiverAddressDetailed, receiverPhone, defaultAddress);
			dao.addAddress(a);
		} catch (FindException e) {
			e.printStackTrace();
		}

	}
	
	
	public void modifyAddrService(int addressNo, int userNo, String receiverName, int receiverZipcode, 
			String receiverAddress, String receiverAddressDetailed, String receiverPhone,
			String defaultAddress ) throws ModifyException {
		Users u;
		try {
			u = userDao.findByUserNo(userNo);
			Address a = new Address(addressNo, u, receiverName, receiverZipcode, receiverAddress,
					receiverAddressDetailed, receiverPhone, defaultAddress);
			dao.modifyAddress(a);
		} catch (FindException e) {
			e.printStackTrace();
		}

	}
	
	
	public void removeAddrService(int addressNo) throws RemoveException {
		try {
			Address a = dao.findByAddressNo(addressNo);
			dao.removeAddress(a);
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//addAddrService test
//		try {
//			service.addAddrService(11, "test", 54321, "지구", "서울", "01055550000", "0");
//		} catch (AddException e) {
//			e.printStackTrace();
//		}
		
		//modifyAddrService test
//		try {
//			service.modifyAddrService(5, 7, "다나가", 77777, "광화문", "광장", "01054549871", "0");
//		} catch (ModifyException e) {
//			e.printStackTrace();
//		}
		
		//removeAddrService test
//		try {
//			service.removeAddrService(6);
//		} catch (RemoveException e) {
//			e.printStackTrace();
//		}
	}
}
