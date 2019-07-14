package com.ccuix.eshop.po;

public class CartPO {
	private int id;
	private int member;
	private double money;
	private int cartStatus;
	public  CartPO(){}
	public CartPO(int id, int member, double money, int cartStatus) {
		super();
		this.id = id;
		this.member = member;
		this.money = money;
		this.cartStatus = cartStatus;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(int cartStatus) {
		this.cartStatus = cartStatus;
	}
	
}
