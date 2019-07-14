package com.ccuix.eshop.po;

public class MerchandisePO {
    
	private int id;
	private int category;
	private String merName;
	private double price;
	private double sprice;
	private String merModel;
	private String picture;
	private String merDesc;
	private String manufacturer;
	private String leaveFactoryDate;
	private int special;
	private String cateName;
	public MerchandisePO(){}
	public MerchandisePO(int id, int category, String merName, double price,
			double sprice, String merModel, String picture, String merDesc,
			String manufacturer, String leaveFactoryDate, int special,String cateName) {
		this.id = id;
		this.category = category;
		this.merName = merName;
		this.price = price;
		this.sprice = sprice;
		this.merModel = merModel;
		this.picture = picture;
		this.merDesc = merDesc;
		this.manufacturer = manufacturer;
		this.leaveFactoryDate = leaveFactoryDate;
		this.special = special;
		this.cateName = cateName;
	}
	public MerchandisePO(int id, int category, String merName, double price,
			double sprice, String merModel, String picture, String merDesc,
			String manufacturer, String leaveFactoryDate, int special) {
		this.id = id;
		this.category = category;
		this.merName = merName;
		this.price = price;
		this.sprice = sprice;
		this.merModel = merModel;
		this.picture = picture;
		this.merDesc = merDesc;
		this.manufacturer = manufacturer;
		this.leaveFactoryDate = leaveFactoryDate;
		this.special = special;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSprice() {
		return sprice;
	}
	public void setSprice(double sprice) {
		this.sprice = sprice;
	}
	public String getMerModel() {
		return merModel;
	}
	public void setMerModel(String merModel) {
		this.merModel = merModel;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getMerDesc() {
		return merDesc;
	}
	public void setMerDesc(String merDesc) {
		this.merDesc = merDesc;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getLeaveFactoryDate() {
		return leaveFactoryDate;
	}
	public void setLeaveFactoryDate(String leaveFactoryDate) {
		this.leaveFactoryDate = leaveFactoryDate;
	}
	public int getSpecial() {
		return special;
	}
	public void setSpecial(int special) {
		this.special = special;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
}
