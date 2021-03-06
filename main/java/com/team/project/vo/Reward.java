package com.team.project.vo;

/*
	`reward_no`	NUMBER(8)	NOT NULL,
	`project_no`	NUMBER(8)	NOT NULL,
	`reward_price`	NUMBER(8)	NULL,
	`reward_name`	VARCHAR2(200)	NULL,
	`deliver_date`	DATE->NUMBER(4)	NULL,
	`reward_num`	NUMBER(4)	NULL,
	`reward_sales_cnt`	NUMBER(8)	NULL,
	`item_name`	VARCHAR2(300)	NULL,
	`deliver_select`	CHAR(1)	NULL
*/
public class Reward {

	private int	rewardNo          ;
	private Project	projectNo     ;
	private int	rewardPrice       ;
	private String	rewardName    ;
	private int	deliverDate       ;
	private int	rewardNum         ;
	private int	rewardSalesCnt    ;
	private String	itemName      ;
	private String	deliverSelect ;
	public Reward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reward(int rewardNo, Project projectNo, int rewardPrice, String rewardName, int deliverDate, int rewardNum,
			int rewardSalesCnt, String itemName, String deliverSelect) {
		super();
		this.rewardNo = rewardNo;
		this.projectNo = projectNo;
		this.rewardPrice = rewardPrice;
		this.rewardName = rewardName;
		this.deliverDate = deliverDate;
		this.rewardNum = rewardNum;
		this.rewardSalesCnt = rewardSalesCnt;
		this.itemName = itemName;
		this.deliverSelect = deliverSelect;
	}
	
	public int getRewardNo() {
		return rewardNo;
	}
	public void setRewardNo(int rewardNo) {
		this.rewardNo = rewardNo;
	}
	public Project getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Project projectNo) {
		this.projectNo = projectNo;
	}
	public int getRewardPrice() {
		return rewardPrice;
	}
	public void setRewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}
	public String getRewardName() {
		return rewardName;
	}
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	public int getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(int deliverDate) {
		this.deliverDate = deliverDate;
	}
	public int getRewardNum() {
		return rewardNum;
	}
	public void setRewardNum(int rewardNum) {
		this.rewardNum = rewardNum;
	}
	public int getRewardSalesCnt() {
		return rewardSalesCnt;
	}
	public void setRewardSalesCnt(int rewardSalesCnt) {
		this.rewardSalesCnt = rewardSalesCnt;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDeliverSelect() {
		return deliverSelect;
	}
	public void setDeliverSelect(String deliverSelect) {
		this.deliverSelect = deliverSelect;
	}
	

	
	
}
