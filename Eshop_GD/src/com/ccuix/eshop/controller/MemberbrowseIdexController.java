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

public class MemberbrowseIdexController extends  HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	System.out.println("客户端浏览商品");
	//组装商品类别
	//调用service
	MerchandiseManageService mService = new MerchandiseManageService();
	List<CategoryPO> cateList = mService.findAllCategory();
	request.setAttribute("cateList", cateList);
	//组装特价商品
	List<MerchandisePO> specialMerList = mService.findAllspecial(1);
	request.setAttribute("specialMerList", specialMerList);
	//组装新品
	List<MerchandisePO> newMerList = mService.findAllspecial(0);
	request.setAttribute("newMerList", newMerList);
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
}
