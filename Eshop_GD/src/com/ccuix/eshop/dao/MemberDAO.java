package com.ccuix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ccuix.eshop.po.MemberPO;
import com.ccuix.eshop.util.DBManagerConnection;

public class MemberDAO {

	 public boolean insertMember(int memberLevel, String memberName,
			    String loginName,String pass,String phone, String address,
				String zip, String email,String regDate){
		
					try {
						Connection Zhao = DBManagerConnection.getConnection();
						String sql="insert into member(memberlevel,memberName,loginPwd,loginName,phone,address,zip,regDate,email) " +
								"values ("+memberLevel+",'"+memberName+"','"+pass+"','"+loginName+"','"+phone+"','"+address+"','"+zip+"','"+regDate+"','"+email+"')";
						java.sql.PreparedStatement preparedStatement = Zhao.prepareStatement(sql);
						
						int row = preparedStatement.executeUpdate(sql);
						System.out.println("受影响的行: "+row);
						return true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return false;
				}

	public MemberPO findmemberByLogin(String loginName, String loginPwd) {
		MemberPO memberPO = null;
		try {
			Connection Zhao = DBManagerConnection.getConnection();
			String sql="select member.id,memberlevel,memberName,loginName,loginPwd,address,"
					+ "zip,email,regDate,phone,lastDate,loginTimes,levelName,favourable "
					+ "from member,memberlevel where member.memberlevel=memberlevel.id and loginName=? and loginPwd=?";
			PreparedStatement preparedStatement = Zhao.prepareStatement(sql);
			preparedStatement.setString(1, loginName);
			preparedStatement.setString(2, loginPwd);
			ResultSet set = preparedStatement.executeQuery();
			if(set.next()){
				memberPO = new MemberPO(set.getInt("id"),set.getInt("memberlevel"),set.getString("loginName"),
						set.getString("loginPwd"),set.getString("memberName"),
						set.getString("phone"),set.getString("address"),
						set.getString("zip"),set.getString("regDate"),set.getString("lastDate"),
						set.getInt("loginTimes"),set.getString("email"),set.getString("levelName"),set.getInt("favourable"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberPO;
	}

	public static void main(String[] args) {
		MemberPO memberPO = new MemberDAO().findmemberByLogin("huyong", "234");
		System.out.println(memberPO);
		if (memberPO != null) {
			
			System.out.println(memberPO.getLevelName());
			System.out.println(memberPO.getAddress());
			System.out.println(memberPO.getFavourable());
		}
	}
	public boolean updateMember(int id,int memberLevel,String loginName,
			 String loginPwd, String memberName, String phone, String address,
			String zip, String email) {
		try {
			Connection Zhao = DBManagerConnection.getConnection();
			//准备sql语句
			String sql="update member set memberlevel="+memberLevel+",loginPwd='"+loginPwd+"',memberName='"+memberName+"',phone='"+phone+"',address='"+address+"',zip='"+zip+"',email='"+email+"'  where id="+id+"";
			//创建一个查询窗口 statement
			Statement statement = Zhao.createStatement();
			//运行 受影响的行: 1
			int row = statement.executeUpdate(sql);
			System.out.println("受影响的行: "+row);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	     return false;
		}
			}

