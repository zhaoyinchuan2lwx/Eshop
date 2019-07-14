package com.ccuix.eshop.po;


public class MemberPO {
	private int id;
	private int memberlevel;
	private String loginName;
	private String loginPwd;
	private  String memberName;
	private  String phone;
	private String address;
	private String zip;
	private String regDate;
	private String lastDate;
	private int loginTimes;
	private String email;
	private String levelName;
	private int favourable;
	public MemberPO(){}
	
	
	public MemberPO(int id, int memberlevel, String loginName, String loginPwd,
			String memberName, String phone, String address, String zip,
			String regDate, String lastDate, int loginTimes, String email,
			String levelName, int favourable) {
		super();
		this.id = id;
		this.memberlevel = memberlevel;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.memberName = memberName;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.regDate = regDate;
		this.lastDate = lastDate;
		this.loginTimes = loginTimes;
		this.email = email;
		this.levelName = levelName;
		this.favourable = favourable;
	}

	public MemberPO(int id ,int memberlevel,String loginName, String loginPwd,String memberName, String phone,
	String address,String zip, String regDate,String lastDate, int loginTimes,String email){
		this.id = id;
		this.memberlevel = memberlevel;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.memberName = memberName;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.regDate = regDate;
		this.lastDate = lastDate;
		this.loginTimes = loginTimes;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getMemberlevel() {
		return memberlevel;
	}


	public void setMemberlevel(int memberlevel) {
		this.memberlevel = memberlevel;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getLoginPwd() {
		return loginPwd;
	}


	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getLastDate() {
		return lastDate;
	}


	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}


	public int getLoginTimes() {
		return loginTimes;
	}


	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}


	public int getFavourable() {
		return favourable;
	}


	public void setFavourable(int favourable) {
		this.favourable = favourable;
	}


}
