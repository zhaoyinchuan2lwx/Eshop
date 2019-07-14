package com.ccuix.eshop.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.MerchandisePO;
import com.ccuix.eshop.service.MerchandiseManageService;

public class MemberbrowseDetialController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		MerchandiseManageService merchandiseManageService = new MerchandiseManageService();
		
		MerchandisePO merchandisePO = merchandiseManageService.Allmerchandise(id);
		request.setAttribute("merchandisePO", merchandisePO);
		request.getRequestDispatcher("what.jsp").forward(request, response);
	}
}
