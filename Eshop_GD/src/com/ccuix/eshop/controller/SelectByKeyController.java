package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.CategoryPO;
import com.ccuix.eshop.po.MerchandisePO;
import com.ccuix.eshop.service.MerchandiseManageService;

public class SelectByKeyController  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("按关键字查询");
		request.setCharacterEncoding("UTF-8");
		 String nameKey = request.getParameter("nameKey");
		 String category = request.getParameter("category");
		 
		 System.out.println(nameKey);
		System.out.println(category);
    	 MerchandiseManageService merchandiseManageService = new MerchandiseManageService();
    	 List<MerchandisePO> merchandiseList = merchandiseManageService.findMerbykey(nameKey,category);
 		request.setAttribute("merchandiseList", merchandiseList);
 		List<CategoryPO> cateList = merchandiseManageService.findAllCategory();
 		request.setAttribute("cateList", cateList);
 		request.getRequestDispatcher("detail.jsp").forward(request, response);

    	}
}
