package com.ccuix.eshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.CartPO;
import com.ccuix.eshop.po.MemberPO;
import com.ccuix.eshop.service.CartManegeService;

public class MemberSubmitCartController  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("购物车提交");
		//调用业务层
		CartManegeService cartManagerService = new CartManegeService();
		//默认你已经等了了 
		MemberPO memberPO =(MemberPO) request.getSession().getAttribute("memberPO");
		CartPO cartPO =(CartPO) request.getSession().getAttribute("cartPO");
		//会员的id   购物的id
		boolean b = cartManagerService.submitCart(memberPO.getId(),cartPO.getId());
		if(b){
			System.out.println("提交成功");
			//继续向order表读取数据   根据购物id  orderPO
			com.ccuix.eshop.po.OrderPO orderPO = cartManagerService.findOrdersBySubmitCart(cartPO.getId());
			request.getSession().setAttribute("orderPO",orderPO);
			//把提交前的购物车金额  要保存
			request.setAttribute("cartMoney",cartPO.getMoney());
			//再给给购物车重新创建一个
			System.out.println("再重新创建一个购物车");
			boolean bb = cartManagerService.insertCart(memberPO.getId());//只需要出入会员的id
			if(bb==true){
				//再查出来
				cartPO = cartManagerService.findCartByMemberId(memberPO.getId());
				request.getSession().setAttribute("cartPO", cartPO);
			}
			
			request.getRequestDispatcher("ordersubmit.jsp").forward(request, response);
		}else{
			System.out.println("提交失败");
		}
	}
}
