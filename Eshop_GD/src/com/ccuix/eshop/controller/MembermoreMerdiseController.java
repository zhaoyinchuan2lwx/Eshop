package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.MerchandisePO;
import com.ccuix.eshop.service.MerchandiseManageService;

public class MembermoreMerdiseController extends HttpServlet{
     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	 String special = request.getParameter("special");
    	 System.out.println("更多商品");
    	 System.out.println(special);
    	 MerchandiseManageService merchandiseManageService = new MerchandiseManageService();
 		
    	 List<MerchandisePO> merchandiseList = merchandiseManageService.findAllspecial(Integer.parseInt(special));
 		request.setAttribute("merchandiseList", merchandiseList);
 		request.getRequestDispatcher("detail.jsp").forward(request, response);
    }
}
