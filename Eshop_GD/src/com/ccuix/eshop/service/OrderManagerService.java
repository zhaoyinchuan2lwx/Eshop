package com.ccuix.eshop.service;

import java.util.List;

import com.ccuix.eshop.dao.OrderDAO;
import com.ccuix.eshop.po.OrderPO;


public class OrderManagerService {

	public List<OrderPO> findOrdersListByMember(int member) {
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.findOrdersListByMember(member);
	}

	public OrderPO findOrderById(String id) {
		int int_id = Integer.parseInt(id);
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.findOrderById(int_id);
	}

}