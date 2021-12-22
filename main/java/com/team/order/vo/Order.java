package com.team.order.vo;




import java.util.Date;

import com.team.project.vo.Project;
import com.team.project.vo.Reward;
import com.team.user.vo.Address;
import com.team.user.vo.Card;
import com.team.user.vo.Users;

/*
	`payment_no`	NUMBER(8)	NOT NULL,
	`user_no`	NUMBER(8)	NOT NULL,
	`payment_date`	DATE	NULL,
	`extra_price`	NUMBER(8)	NULL,
	`total_price`	NUMBER(8)	NULL,
	`payment_result`	VARCHAR2(10)	NULL,
	`address_no`	NUMBER(8)	NOT NULL,
	`card_no`	NUMBER(8)	NOT NULL,
	`reward_no`	NUMBER(8)	NOT NULL,
	`project_no`	NUMBER(8)	NOT NULL

*/

public class Order {                ;
	private int	paymentNo           ;
	private Users	userNo          ;
	private Date	paymentDate     ;
	private int	extraPrice          ;
	private int	totalPrice          ;
	private String	paymentResult   ;
	private Address	addressNo       ;
	private Reward	rewardNo		;
	private Project	projectNo       ;
	private Card	cardNo          ;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int paymentNo, Users userNo, Date paymentDate, int extraPrice, int totalPrice, String paymentResult,
			Address addressNo, Reward rewardNo, Project projectNo, Card cardNo) {
		super();
		this.paymentNo = paymentNo;
		this.userNo = userNo;
		this.paymentDate = paymentDate;
		this.extraPrice = extraPrice;
		this.totalPrice = totalPrice;
		this.paymentResult = paymentResult;
		this.addressNo = addressNo;
		this.rewardNo = rewardNo;
		this.projectNo = projectNo;
		this.cardNo = cardNo;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public Users getUserNo() {
		return userNo;
	}
	public void setUserNo(Users userNo) {
		this.userNo = userNo;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getExtraPrice() {
		return extraPrice;
	}
	public void setExtraPrice(int extraPrice) {
		this.extraPrice = extraPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPaymentResult() {
		return paymentResult;
	}
	public void setPaymentResult(String paymentResult) {
		this.paymentResult = paymentResult;
	}
	public Address getAddressNo() {
		return addressNo;
	}
	public void setAddressNo(Address addressNo) {
		this.addressNo = addressNo;
	}
	public Reward getRewardNo() {
		return rewardNo;
	}
	public void setRewardNo(Reward rewardNo) {
		this.rewardNo = rewardNo;
	}
	public Project getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Project projectNo) {
		this.projectNo = projectNo;
	}
	public Card getCardNo() {
		return cardNo;
	}
	public void setCardNo(Card cardNo) {
		this.cardNo = cardNo;
	}
	
	

	
	 
}
