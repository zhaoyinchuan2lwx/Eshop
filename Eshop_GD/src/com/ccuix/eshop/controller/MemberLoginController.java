package com.ccuix.eshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.CartPO;
import com.ccuix.eshop.po.MemberPO;
import com.ccuix.eshop.service.CartManegeService;
import com.ccuix.eshop.service.MemberService;

public class MemberLoginController extends HttpServlet{

	private static final String CartPO = null;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("你好");
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		System.out.println("loginName="+loginName);
		System.out.println("loginPwd="+loginPwd);
		//调用service、
	    MemberService memberService = new MemberService();
	    MemberPO memberPO = memberService.login(loginName,loginPwd); 
	    if(memberPO==null){
	    	request.getSession().setAttribute("false", "登录失败，用户名密码错误");
	    	response.sendRedirect("false.jsp");
	    }else{
	    	//绑定购物车信息
	    CartManegeService cartManegeService = new CartManegeService();
	    CartPO cartPO = cartManegeService.findCartByMemberId(memberPO.getId());
	    if(CartPO == null){
	    	System.out.println("进行插入");
	    	boolean b = cartManegeService.insertCart(memberPO.getId());
	    if(b==true){
	    	cartPO = cartManegeService.findCartByMemberId(memberPO.getId());
	    }else{
	    	System.out.println("购物车插入失败.................");
	    }
	    }else{
	    	System.out.println("存在该购物车");
	    }
	    request.getSession().setAttribute("cartPO", cartPO);
	    	request.getSession().setAttribute("success", "登录成功");
	    	request.getSession().setAttribute("memberPO", memberPO);
	    	response.sendRedirect("browseIdex");
	    }
	}
}
