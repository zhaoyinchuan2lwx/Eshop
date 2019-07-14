package com.ccuix.eshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
//��ݿ�l�ӷ���
public class DBManagerConnection {
	public static Connection getConnection(){
		Connection Zhao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();// ������ݿ�����
			// connection �൱��navicat��l�Ӷ���
			Zhao = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_eshop", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Zhao;
	}
}
