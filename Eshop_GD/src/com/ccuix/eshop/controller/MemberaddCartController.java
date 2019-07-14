package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.CartPO;
import com.ccuix.eshop.po.CartSelectedMerPO;
import com.ccuix.eshop.po.MemberPO;
import com.ccuix.eshop.service.CartManegeService;

/**
 * 这是一个查询商品的controller
 */
public class MemberaddCartController extends HttpServlet{
       @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	   String merchandise = request.getParameter("merchandise");
   		String price = request.getParameter("price");
   		String sprice =request.getParameter("sprice");
   		System.out.println("商品id:"+merchandise+",商品价格"+price+",商品特价:"+sprice);
   		CartManegeService cartManegeService = new CartManegeService();
		//在session中取cartPO信息  为了把购物车id拿出来
   		Object obj_cart = request.getSession().getAttribute("cartPO");
		Object obj_member = request.getSession().getAttribute("memberPO");
		if(obj_cart==null){
			response.sendRedirect("Nologin.jsp");
			System.out.println("没有登录,请进行登陆");
			
		}else{
			CartPO cartPO = (CartPO)obj_cart;
			MemberPO memberPO = (MemberPO)obj_member;
			boolean b = cartManegeService.addCart(merchandise,price,sprice,cartPO.getId(),memberPO.getFavourable());
			if(b){
				//跳转到购物车管理页面
				//封装数据  购物车选项中的集合信息  根据购物车查询
				List<CartSelectedMerPO> cartSelectedMerList = cartManegeService.findCartSelectedMerListByCart(cartPO.getId());
				request.setAttribute("cartSelectedMerList", cartSelectedMerList);
				//需要改变购物车值
				CartPO cartPO2 = cartManegeService.findCartByMemberId(memberPO.getId());
				request.getSession().setAttribute("cartPO", cartPO2);//绑定的name值 key   一定要一致
				System.out.println("拿到多少商品项"+cartSelectedMerList.size());
				request.getRequestDispatcher("cart_list.jsp").forward(request, response);
			}else{
				System.out.println("我错了......");
			}
			
		}
         
    }
}
