package com.ccuix.eshop.po;

import java.util.Date;

public class LeavewordPO {

	private int id;
	private int member;
	private int admin;
	private String title;
	private String context;
	private Date leaveDate;
	private String answerContext;
	private String answerDate;
	private String memberName;
	public LeavewordPO (){}
	
	public LeavewordPO(int id, int member, int admin, String title,
			String context, Date leaveDate, String answerContext,
			String answerDate, String memberName) {
		super();
		this.id = id;
		this.member = member;
		this.admin = admin;
		this.title = title;
		this.context = context;
		this.leaveDate = leaveDate;
		this.answerContext = answerContext;
		this.answerDate = answerDate;
		this.memberName = memberName;
	}

	public LeavewordPO(int id, int member, int admin, String title,
			String context, Date leaveDate, String answerContext,
			String answerDate) {
		super();
		this.id = id;
		this.member = member;
		this.admin = admin;
		this.title = title;
		this.context = context;
		this.leaveDate = leaveDate;
		this.answerContext = answerContext;
		this.answerDate = answerDate;
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
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getAnswerContext() {
		return answerContext;
	}
	public void setAnswerContext(String answerContext) {
		this.answerContext = answerContext;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
