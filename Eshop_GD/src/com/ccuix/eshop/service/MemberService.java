package com.ccuix.eshop.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ccuix.eshop.dao.MemberDAO;
import com.ccuix.eshop.po.MemberPO;

public class MemberService {
    public boolean regedit(String memberlevel, String memberName,
				String loginName, String pass, String phone, String address,
				String zip, String email) {
			int memberLevel = Integer.parseInt(memberlevel);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String regDate = sdf.format(date);
			MemberDAO memberDAO = new MemberDAO();
			return memberDAO.insertMember(memberLevel, memberName, loginName, pass, phone, address, zip, email,regDate);
		}

	public MemberPO login(String loginName, String loginPwd) {
		MemberDAO memberDAO = new MemberDAO();		
		return memberDAO.findmemberByLogin(loginName,loginPwd);
	}

	public boolean update(String id,String memberlevel,String memberName,String loginName, String pass,
			  String phone, String address,String zip, String email) {
		int int_id = Integer.parseInt(id);
		int memberLevel = Integer.parseInt(memberlevel);
		MemberDAO memberDAO = new MemberDAO();
		return memberDAO.updateMember(int_id, memberLevel,loginName,pass,memberName,phone,address,zip,email);
	
	}
}
