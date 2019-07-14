package com.ccuix.eshop.po;

public class CartSelectedMerPO {

	private int id;
	private int cart;
	private int merchandise;
	private int number;
	private double price;
	private double money;
	private String merName;
	private double merPrice;
	public CartSelectedMerPO(){}
	public CartSelectedMerPO(int id, int cart, int merchandise, int number,
			double price, double money, String merName, double merPrice) {
		super();
		this.id = id;
		this.cart = cart;
		this.merchandise = merchandise;
		this.number = number;
		this.price = price;
		this.money = money;
		this.merName = merName;
		this.merPrice = merPrice;
	}

	public CartSelectedMerPO(int id, int cart, int merchandise, int number,
			double price, double money) {
		super();
		this.id = id;
		this.cart = cart;
		this.merchandise = merchandise;
		this.number = number;
		this.price = price;
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCart() {
		return cart;
	}
	public void setCart(int cart) {
		this.cart = cart;
	}
	public int getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(int merchandise) {
		this.merchandise = merchandise;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public double getMerPrice() {
		return merPrice;
	}
	public void setMerPrice(double merPrice) {
		this.merPrice = merPrice;
	}
	
}
