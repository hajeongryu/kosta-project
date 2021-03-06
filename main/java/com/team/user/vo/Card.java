package com.team.user.vo;

import java.sql.Date;

/*
	`card_no`	NUMBER(8)	NOT NULL,
	`user_no2`	NUMBER(8)	NOT NULL,
	`card_num`	VARCHAR2(20)	NULL,
	`card_valid_date`	DATE	NULL,
	`card_pwd`	VARCHAR2(4)	NULL,
	`card_owner_birth`	VARCHAR2(20)	NULL,
	`default_card`	CHAR(1)	NULL
*/

public class Card {
	private int	cardNo            ;
	private Users	user        ;
	private String	cardNum           ;
	private Date	cardValidDate ;
	private String	cardPwd       ;
	private String	cardOwnerBirth;
	private String	defaultCard   ;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int cardNo, Users user, String cardNum, Date cardValidDate, String cardPwd, String cardOwnerBirth,
			String defaultCard) {
		super();
		this.cardNo = cardNo;
		this.user = user;
		this.cardNum = cardNum;
		this.cardValidDate = cardValidDate;
		this.cardPwd = cardPwd;
		this.cardOwnerBirth = cardOwnerBirth;
		this.defaultCard = defaultCard;
	}
	public Card(Users user, String cardNum, Date cardValidDate, String cardPwd, String cardOwnerBirth,
			String defaultCard) {
		super();
		this.user = user;
		this.cardNum = cardNum;
		this.cardValidDate = cardValidDate;
		this.cardPwd = cardPwd;
		this.cardOwnerBirth = cardOwnerBirth;
		this.defaultCard = defaultCard;
	}
	public Card(int cardNo, String defaultCard) {
		super();
		this.cardNo = cardNo;
		this.defaultCard = defaultCard;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Date getCardValidDate() {
		return cardValidDate;
	}
	public void setCardValidDate(Date cardValidDate) {
		this.cardValidDate = cardValidDate;
	}
	public String getCardPwd() {
		return cardPwd;
	}
	public void setCardPwd(String cardPwd) {
		this.cardPwd = cardPwd;
	}
	public String getCardOwnerBirth() {
		return cardOwnerBirth;
	}
	public void setCardOwnerBirth(String cardOwnerBirth) {
		this.cardOwnerBirth = cardOwnerBirth;
	}
	public String getDefaultCard() {
		return defaultCard;
	}
	public void setDefaultCard(String defaultCard) {
		this.defaultCard = defaultCard;
	}
	
	
}                                 
