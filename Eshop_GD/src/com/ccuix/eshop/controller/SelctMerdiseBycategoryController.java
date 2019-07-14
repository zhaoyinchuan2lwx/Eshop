package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.MerchandisePO;
import com.ccuix.eshop.service.MerchandiseManageService;

public class SelctMerdiseBycategoryController extends HttpServlet {

	 protected void service(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {
	    	 String category = request.getParameter("category");
	    	 System.out.println("按类别查询");
	    	 System.out.println(category);
	    	 MerchandiseManageService merchandiseManageService = new MerchandiseManageService();
	 		
	    	 List<MerchandisePO> merchandiseList = merchandiseManageService.findMerbyCategory(Integer.parseInt(category));
	 		request.setAttribute("merchandiseList", merchandiseList);
	 		request.getRequestDispatcher("detail.jsp").forward(request, response);
	    }
}
