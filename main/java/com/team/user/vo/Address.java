package com.team.user.vo;


/*
 	`address_no`	NUMBER(8)	NOT NULL,
	`user_no`	NUMBER(8)	NOT NULL,
	`receiver_name`	VARCHAR2(20)	NULL,
	`receiver_zipcode`	NUMBER(8)	NULL,
	`receiver_address`	VARCHAR2(50)	NULL,
	`receiver_address_detailed`	VARCHAR2(50)	NULL,
	`receiver_phone`	VARCHAR2(20)	NULL,
	`default_address`	CHAR(1)	NULL
*/

public class Address {
	
	private int addressNo;
	private Users user;
	private String receverName;
	private int receverZipcode;
	private String receverAddress;
	private String receverAddressDetailed;
	private int receiverPhone;
	private String defualtAddress;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(int addressNo, Users user, String receverName, int receverZipcode, String receverAddress,
			String receverAddressDetailed, int receiverPhone, String defualtAddress) {
		super();
		this.addressNo = addressNo;
		this.user = user;
		this.receverName = receverName;
		this.receverZipcode = receverZipcode;
		this.receverAddress = receverAddress;
		this.receverAddressDetailed = receverAddressDetailed;
		this.receiverPhone = receiverPhone;
		this.defualtAddress = defualtAddress;
	}
	
	public int getAddressNo() {
		return addressNo;
	}
	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getReceverName() {
		return receverName;
	}
	public void setReceverName(String receverName) {
		this.receverName = receverName;
	}
	public int getReceverZipcode() {
		return receverZipcode;
	}
	public void setReceverZipcode(int receverZipcode) {
		this.receverZipcode = receverZipcode;
	}
	public String getReceverAddress() {
		return receverAddress;
	}
	public void setReceverAddress(String receverAddress) {
		this.receverAddress = receverAddress;
	}
	public String getReceverAddressDetailed() {
		return receverAddressDetailed;
	}
	public void setReceverAddressDetailed(String receverAddressDetailed) {
		this.receverAddressDetailed = receverAddressDetailed;
	}
	public int getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(int receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getDefualtAddress() {
		return defualtAddress;
	}
	public void setDefualtAddress(String defualtAddress) {
		this.defualtAddress = defualtAddress;
	}
	
	
	
}
