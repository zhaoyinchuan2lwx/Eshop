package com.ccuix.eshop.po;

public class OrderPO {

	private int id;
	private int member;
	private int cart;
	private String orderNO;
	private String orderDate;
	private int orderStatus;
	private double money;
	public OrderPO(){}
	
	public OrderPO(int id, int member, int cart, String orderNO,
			String orderDate, int orderStatus, double money) {
		this.id = id;
		this.member = member;
		this.cart = cart;
		this.orderNO = orderNO;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.money = money;
	}

	public OrderPO(int id, int member, int cart, String orderNO,
			String orderDate, int orderStatus) {
		this.id = id;
		this.member = member;
		this.cart = cart;
		this.orderNO = orderNO;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public int getCart() {
		return cart;
	}
	public void setCart(int cart) {
		this.cart = cart;
	}
	public String getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}
