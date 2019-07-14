package com.ccuix.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.po.CategoryPO;
import com.ccuix.eshop.po.MemberPO;
import com.ccuix.eshop.po.OrderPO;
import com.ccuix.eshop.service.MerchandiseManageService;
import com.ccuix.eshop.service.OrderManagerService;

public class MemberFindorderListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断是否登陆 没有登陆跳转错误页面
		if(request.getSession().getAttribute("memberPO")==null){
			request.getRequestDispatcher("/jsp/commLogin.jsp").forward(request, response);
			return;
		}
		System.out.println("订单管理");
		//获得memberPO对象
				MemberPO memberPO = (MemberPO)request.getSession().getAttribute("memberPO");
				OrderManagerService orderManagerService = new OrderManagerService();
				List<OrderPO> ordersList = orderManagerService.findOrdersListByMember(memberPO.getId());
				request.setAttribute("ordersList", ordersList);
				//获得cateList 商品类别信息
				//查询商品类别
				MerchandiseManageService merchandiseManagerService = new MerchandiseManageService();
				List<CategoryPO> cateList=merchandiseManagerService.findAllCategory();
				request.setAttribute("cateList", cateList);
				System.out.println("组装商品类别数据完毕");
				request.getRequestDispatcher("ordermanage.jsp").forward(request, response);

	}
}
