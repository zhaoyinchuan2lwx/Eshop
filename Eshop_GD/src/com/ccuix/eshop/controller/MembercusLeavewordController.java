package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.LeavewordPO;
import com.ccuix.eshop.service.MemberleavewordService;

public class MembercusLeavewordController extends HttpServlet{
 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("顾客留言");
		MemberleavewordService memberleavewordService = new MemberleavewordService();
		List<LeavewordPO> leaveword = memberleavewordService.findLeaveword();
		request.setAttribute("leaveword",leaveword);
		request.getRequestDispatcher("customers.jsp").forward(request, response);
	}
}
