package com.ccuix.eshop.po;

public class StudentPO {
private String sno;
private String name;
private String sex;
private int age;
private double money;

public StudentPO(String sno, String name, String sex, int age, double money) {
	super();
	this.sno = sno;
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.money = money;
}
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double getMoney() {
	return money;
}
public void setMoney(double money) {
	this.money = money;
}

}
