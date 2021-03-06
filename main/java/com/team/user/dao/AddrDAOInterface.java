package com.team.user.dao;

import java.util.List;

import com.team.exception.AddException;
import com.team.exception.FindException;
import com.team.exception.ModifyException;
import com.team.exception.RemoveException;
import com.team.user.vo.Address;

public interface AddrDAOInterface {
	/**
	 * 회원번호에 해당하는 고객이 등록한 배송지 리스트를 반환한다
	 * @param userNo
	 * @return
	 * @throws FindException
	 */
	public List<Address> findByUserNo(int userNo) throws FindException;
	
	/**
	 * 배송지번호에 해당하는 배송지 객체를 반환한다
	 * @param addressNo
	 * @return
	 * @throws FindException
	 */
	public Address findByAddressNo(int addressNo) throws FindException;
	
	/**
	 * 배송지를 추가한다
	 * @param address
	 * @throws AddException
	 */
	public void addAddress(Address address) throws AddException;
	
	/**
	 * 선택한 배송지를 기본배송지로 바꾸고 나머지는 기본배송지에서 제외한다
	 * @param address
	 * @throws ModifyException
	 */
	public void modifyDefaultAddress(Address address) throws ModifyException;
	
	/**
	 * 등록한 배송지 정보를 수정한다
	 * @param address
	 * @throws ModifyException
	 */
	public void modifyAddress(Address address) throws ModifyException;
	
	/**
	 * 등록한 배송지를 삭제한다
	 * @param address
	 * @throws RemoveException
	 */
	public void removeAddress(Address address) throws RemoveException;
}
