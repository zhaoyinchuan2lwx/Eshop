package com.ccuix.eshop.service;

import java.util.List;

import com.ccuix.eshop.dao.LeavewordDAO;
import com.ccuix.eshop.po.LeavewordPO;

public class MemberleavewordService {

	public List<LeavewordPO> findLeaveword() {
		LeavewordDAO leavewordDAO = new LeavewordDAO();
		return leavewordDAO.findLeaveword();
	}
    public boolean insertContent(LeavewordPO po){
    	LeavewordDAO dao = new LeavewordDAO();
    	return dao.insertConten(po);
    }
}
