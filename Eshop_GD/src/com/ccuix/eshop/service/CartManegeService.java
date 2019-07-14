package com.ccuix.eshop.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ccuix.eshop.dao.CartDAO;
import com.ccuix.eshop.po.CartPO;
import com.ccuix.eshop.po.CartSelectedMerPO;
import com.ccuix.eshop.po.OrderPO;


public class CartManegeService {

	public CartPO findCartByMemberId(int member) {
		CartDAO cartDAO = new CartDAO();
		return cartDAO.findCartByMemberId(member);
	}

	public boolean insertCart(int member) {
		CartDAO cartDAO = new CartDAO();
		return cartDAO.insertCart(member);
	}
		

	public boolean addCart(String merchandise, String price, String sprice,int cart,int favourable) {
		//清洗数据
		int int_merchandise = Integer.parseInt(merchandise);
		double double_price = Double.parseDouble(price);
		double double_sprice = Double.parseDouble(sprice);
		//业务分析  查购物详情中  是否存在该商品
		CartDAO cartDAO = new CartDAO();
		boolean b = cartDAO.findMerIsExist(cart,int_merchandise);//该购物车中  是否存在这个商品		
		if(b==true){
			//1-如果购物车详情表中  存在该商品   那么就需要进行更新update	
			System.out.println("1-如果购物车详情表中  存在该商品   那么就需要进行更新update");
			cartDAO.updateCartSelectedMerByAddCart(int_merchandise,cart);	
		}else{
			//2-如果购物车详情表中  不存在该商品  那么就需要进行插入insert
			//处理会员的价格
			//double_sprice=0就是新品   >0是特价
			System.out.println("2-如果购物车详情表中  不存在该商品  那么就需要进行插入insert");
			double pp = 0;//代表需要支付多少钱			
			if(double_sprice>0){
				//是特价
				double p1 = double_price*favourable*0.01;
				//比较  如果p1 和 double_sprice  谁小  我就用谁
				pp = p1<double_sprice?p1:double_sprice;//三目运算符
			}else{
				pp = double_price*favourable*0.01;
			}		
			System.out.println("应该按照"+pp+"金额进行购买");
			cartDAO.addCartSelectedMerByAddCart(int_merchandise,cart,pp);
		}		
		return true;
	}
	
	public List<CartSelectedMerPO> findCartSelectedMerListByCart(int cart) {
		CartDAO cartDAO = new CartDAO();
		return cartDAO.findCartSelectedMerListByCart(cart);
	}
	public boolean submitCart(int member, int cart) {
		// 数据库进行组装
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderDate=sdf.format(date);
		
		//订单号
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderNO=sdf1.format(date);
		
		//调用dao
		CartDAO cartDAO = new CartDAO();
		return cartDAO.submitCart(member,cart,orderDate,orderNO);
	}

	public OrderPO findOrdersBySubmitCart(int cart) {
		//调用dao
		CartDAO cartDAO = new CartDAO();
		return cartDAO.findOrdersBySubmitCart(cart);
	}
}