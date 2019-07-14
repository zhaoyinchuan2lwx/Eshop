package com.ccuix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ccuix.eshop.po.LeavewordPO;
import com.ccuix.eshop.util.DBManagerConnection;

public class LeavewordDAO {
	public List<LeavewordPO> findLeaveword() {
		List<LeavewordPO> leavewordList= new ArrayList<LeavewordPO>();
		try {
			Connection Zhao = DBManagerConnection.getConnection();
			String sql="select leaveword.id,member,admin,title,context,leaveDate,answerContext," +
					"answerDate,member.memberName from leaveword,member where member.id=leaveword.member";
			PreparedStatement preparedStatement = Zhao.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()){
				LeavewordPO leavewordPO = new LeavewordPO(set.getInt("id"),
						set.getInt("member"),set.getInt("admin"),
						set.getString("title"),set.getString("context"),
						set.getDate("leaveDate"),set.getString("answerContext"),
						set.getString("answerDate"),set.getString("memberName"));
				leavewordList.add(leavewordPO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leavewordList;
	}
	 public boolean insertConten(LeavewordPO po ){
		
					try {
						Connection Zhao = DBManagerConnection.getConnection();
						String sql="insert into leaveword(id,member,admin,title,context,leaveDate,answerContext," +
								"answerDate) values ("+po.getId()+","+po.getMember()+","+po.getAdmin()+"," +
										"'"+po.getTitle()+"','"+po.getContext()+"','"+new java.sql.Date(po.getLeaveDate().getTime())
+"','"+po.getAnswerContext()+"'," +
												"'"+new java.sql.Date(po.getLeaveDate().getTime())+"')";
						java.sql.PreparedStatement preparedStatement = Zhao.prepareStatement(sql);
						
						int row = preparedStatement.executeUpdate(sql);
						System.out.println("受影响的行: "+row);
						return true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return false;
				}

	
	
	
   }
