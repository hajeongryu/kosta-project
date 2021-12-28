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
	private Users	orderUser       ;
	private Date	paymentDate     ;
	private int	extraPrice          ;
	private int	totalPrice          ;
	private String	paymentResult   ;
	private Address	address         ;
	private Card	card            ;
	
	//JOINED TALBLE
	private Project project			;
	private Reward	reward		    ;
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int paymentNo, Users orderUser, Date paymentDate, int extraPrice, int totalPrice, String paymentResult,
			Address address, Reward reward, Card card) {
		super();
		this.paymentNo = paymentNo;
		this.orderUser = orderUser;
		this.paymentDate = paymentDate;
		this.extraPrice = extraPrice;
		this.totalPrice = totalPrice;
		this.paymentResult = paymentResult;
		this.address = address;
		this.reward = reward;
		this.card = card;
	}
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public Users getOrderUser() {
		return orderUser;
	}
	public void setOrderUser(Users userNo) {
		this.orderUser = userNo;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Reward getReward() {
		return reward;
	}
	public void setReward(Reward reward) {
		this.reward = reward;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	

	
	 
}
