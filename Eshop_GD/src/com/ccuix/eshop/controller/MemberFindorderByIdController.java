package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.CartSelectedMerPO;
import com.ccuix.eshop.po.OrderPO;
import com.ccuix.eshop.service.CartManegeService;
import com.ccuix.eshop.service.OrderManagerService;

public class MemberFindorderByIdController extends HttpServlet{
     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("查看订单信息");
    	String id = request.getParameter("id");
    	System.out.println("订单号是："+id);
    	OrderManagerService orderManagerService = new OrderManagerService();
    	OrderPO orderPO = orderManagerService.findOrderById(id);
    	CartManegeService cartManegeService = new CartManegeService();
    	List<CartSelectedMerPO> cartSelectedMerList = cartManegeService.findCartSelectedMerListByCart(orderPO.getCart());
    	request.setAttribute("orderPO",orderPO);
		request.setAttribute("cartSelectedMerList",cartSelectedMerList);
		request.getRequestDispatcher("orderdetail.jsp").forward(request, response);
    }
}
