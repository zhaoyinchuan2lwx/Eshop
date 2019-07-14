package com.ccuix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ccuix.eshop.po.CartPO;
import com.ccuix.eshop.po.OrderPO;
import com.ccuix.eshop.util.DBManagerConnection;

public class OrderDAO {

	public List<OrderPO> findOrdersListByMember(int member) {
		List<OrderPO> ordersList = new ArrayList<OrderPO>();
			try {
				Connection connection = DBManagerConnection.getConnection();
				// 准备sql语句 预编译sql
				String sql = "select orders.id,orders.member,cart,orderNo,DATE_FORMAT(orderDate,'%Y-%m-%d') orderDate,"
						+ "orderStatus,Cart.money from orders,cart where orders.Cart=Cart.ID and orders.member=?";
				// 创建一个查询窗口 statement
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql);
				// 对？进行赋值
				preparedStatement.setInt(1, member);
				// 运行 受影响的行: 1
				ResultSet set = preparedStatement.executeQuery();
				while (set.next()) {
					OrderPO orderPO = new OrderPO(set.getInt("id"),
							set.getInt("member"), set.getInt("cart"),
							set.getString("orderNo"), set.getString("orderDate"),
							set.getInt("orderStatus"), set.getDouble("money"));
					ordersList.add(orderPO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ordersList;
	}

	public OrderPO findOrderById(int id) {
		OrderPO orderPO = null;
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "select orders.id,orders.member,cart,orderNo,DATE_FORMAT(orderDate,'%Y-%m-%d') orderDate,"
					+ "orderStatus,Cart.money from orders,cart where orders.Cart=Cart.ID and orders.id=?";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, id);
			// 运行 受影响的行: 1
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {
			    orderPO = new OrderPO(set.getInt("id"),
						set.getInt("member"), set.getInt("cart"),
						set.getString("orderNo"), set.getString("orderDate"),
						set.getInt("orderStatus"), set.getDouble("money"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderPO;
	}


}
