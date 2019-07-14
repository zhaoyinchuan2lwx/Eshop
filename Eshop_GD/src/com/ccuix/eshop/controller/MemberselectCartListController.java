package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.CartPO;
import com.ccuix.eshop.po.CartSelectedMerPO;
import com.ccuix.eshop.service.CartManegeService;

public class MemberselectCartListController extends HttpServlet {
     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("购物车查询。。。");
    	//判断是否登陆 没有登陆跳转错误页面
		if(request.getSession().getAttribute("memberPO")==null){
			request.getRequestDispatcher("/jsp/commtLogin.jsp").forward(request, response);
			return;
		}
		CartPO cartPO = (CartPO)request.getSession().getAttribute("cartPO");
		//封装数据
		CartManegeService cartManegeService = new CartManegeService();
		List<CartSelectedMerPO> cartSelectedMerList = cartManegeService.findCartSelectedMerListByCart(cartPO.getId());
		request.setAttribute("cartSelectedMerList", cartSelectedMerList);
		//需要改变购物车值
		System.out.println("拿到多少商品项"+cartSelectedMerList.size());
		request.getRequestDispatcher("cart_list.jsp").forward(request, response);
    }
}
