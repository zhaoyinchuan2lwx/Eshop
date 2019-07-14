package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.LeavewordPO;
import com.ccuix.eshop.po.MemberPO;
import com.ccuix.eshop.service.MemberleavewordService;

public class MemberLeaveconentController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MemberleavewordService word = new MemberleavewordService();
		LeavewordPO leavewordPO = new LeavewordPO();
		leavewordPO.setTitle(title);
		leavewordPO.setContext(content);
		leavewordPO.setMember(1);
		leavewordPO.setAdmin(1);
	    Date date = new Date();
	    leavewordPO.setLeaveDate(date);
		boolean w = word.insertContent(leavewordPO);
		if(w==true){
			request.setAttribute("true","留言成功");
		}
		else{request.setAttribute("false", "留言失败");
		}
		request.getRequestDispatcher("cusLeaveword").forward(request, response);
	}
}
