package com.ccuix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ccuix.eshop.po.CartPO;
import com.ccuix.eshop.po.CartSelectedMerPO;
import com.ccuix.eshop.po.OrderPO;
import com.ccuix.eshop.util.DBManagerConnection;


public class CartDAO {

	public CartPO findCartByMemberId(int member) {
		CartPO cartPO = null;
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "select id,member,money,cartStatus from cart where member=? and cartStatus=0";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, member);

			// 运行 受影响的行: 1
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {
				cartPO = new CartPO(set.getInt("id"), set.getInt("member"),
						set.getDouble("money"), set.getInt("cartStatus"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartPO;
	}

	public boolean insertCart(int member) {
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "insert into cart(member,money,cartStatus) values (?,0,0)";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, member);
			// 运行 受影响的行: 1
			int row = preparedStatement.executeUpdate();
			System.out.println("受影响的行: " + row);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean findMerIsExist(int cart, int merchandise) {
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "select id from cartselectedmer where cart=? and merchandise=?";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, cart);
			preparedStatement.setInt(2, merchandise);
			// 运行 受影响的行: 1
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	// 更新购物车详情 更新操作 添加购物车 +1
	public boolean updateCartSelectedMerByAddCart(int merchandise, int cart) {
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "update cartselectedmer set number=number+1,money=money+price where cart=? and merchandise=?";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, cart);
			preparedStatement.setInt(2, merchandise);
			// 运行 受影响的行: 1
			int row = preparedStatement.executeUpdate();
			System.out.println("cartselectedmer更新数据受影响的行: " + row);

			// 了解业务
			String cart_sql = "update cart set money=(select sum(money) "
					+ " from cartselectedmer where cart=? group by cart) where id=?";
			PreparedStatement preparedStatement2 = connection
					.prepareStatement(cart_sql);
			preparedStatement2.setInt(1, cart);
			preparedStatement2.setInt(2, cart);
			int row2 = preparedStatement2.executeUpdate();
			System.out.println("cart购物车更新数据受影响的行: " + row2);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean addCartSelectedMerByAddCart(int merchandise, int cart,
			double price) {
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "insert cartselectedmer(cart,merchandise,number,price,money) values (?,?,?,?,?)";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, cart);
			preparedStatement.setInt(2, merchandise);
			preparedStatement.setInt(3, 1);
			preparedStatement.setDouble(4, price);
			preparedStatement.setDouble(5, price);
			// 运行 受影响的行: 1
			int row = preparedStatement.executeUpdate();
			System.out.println("cartselectedmer插入数据受影响的行: " + row);

			// 了解业务
			String cart_sql = "update cart set money=(select sum(money) "
					+ " from cartselectedmer where cart=? group by cart) where id=?";
			PreparedStatement preparedStatement2 = connection
					.prepareStatement(cart_sql);
			preparedStatement2.setInt(1, cart);
			preparedStatement2.setInt(2, cart);
			int row2 = preparedStatement2.executeUpdate();
			System.out.println("cart购物车更新数据受影响的行: " + row2);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
    //根据购物车id查找  购物详情
	public List<CartSelectedMerPO> findCartSelectedMerListByCart(int cart) {
		List<CartSelectedMerPO> cartSelectedMerList = new ArrayList<CartSelectedMerPO>();
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "select cartselectedmer.id,cart,merchandise,number,cartselectedmer.price,"
					+ "money,merName,cartselectedmer.Price merPrice from cartselectedmer,merchandise "
					+ "where cartselectedmer.merchandise=merchandise.id and cart=?";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, cart);
			// 运行 受影响的行: 1
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				CartSelectedMerPO cartSelectedMerPO = new CartSelectedMerPO(
						set.getInt("id"), set.getInt("cart"),
						set.getInt("merchandise"), set.getInt("number"),
						set.getDouble("price"), set.getDouble("money"),
						set.getString("merName"), set.getDouble("merPrice"));
				cartSelectedMerList.add(cartSelectedMerPO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cartSelectedMerList;
	}
	
	public boolean submitCart(int member, int cart, String orderDate,
			String orderNO) {
		// 向订单表中插入数据

		// 向购物车表做更新操作 cartStatus=1
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "insert orders(member,cart,orderNO,orderDate,orderStatus) values (?,?,?,?,?)";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, member);
			preparedStatement.setInt(2, cart);
			preparedStatement.setString(3, orderNO);
			preparedStatement.setString(4, orderDate);
			preparedStatement.setInt(5, 1);
			// 运行 受影响的行: 1
			int row = preparedStatement.executeUpdate();
			System.out.println("orders插入数据受影响的行: " + row);

			// 了解业务
			String cart_sql = "update cart set cartStatus=1 where id=?";
			PreparedStatement preparedStatement2 = connection
					.prepareStatement(cart_sql);
			preparedStatement2.setInt(1, cart);
			int row2 = preparedStatement2.executeUpdate();
			System.out.println("cart购物车更新数据受影响的行: " + row2);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
    //查找提交购物车的那个订单
	public OrderPO findOrdersBySubmitCart(int cart) {
		OrderPO orderPO = null;
		try {
			Connection connection = DBManagerConnection.getConnection();
			// 准备sql语句 预编译sql
			String sql = "select id,member,cart,orderNO,orderDate,orderStatus from orders where cart=?";
			// 创建一个查询窗口 statement
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			// 对？进行赋值
			preparedStatement.setInt(1, cart);
			// 运行 受影响的行: 1
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {
				orderPO = new OrderPO(set.getInt("id"), set.getInt("member"),
						set.getInt("cart"), set.getString("orderNo"),
						set.getString("orderDate"), set.getInt("orderStatus"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderPO;
	}

	public static void main(String[] args) {
		System.out.println(new CartDAO().findCartSelectedMerListByCart(23).get(1).getMerName());
		System.out.println(new CartDAO().findCartSelectedMerListByCart(23).get(1).getMerPrice());
	}
}