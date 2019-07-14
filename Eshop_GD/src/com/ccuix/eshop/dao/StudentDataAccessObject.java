package com.ccuix.eshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ccuix.eshop.po.StudentPO;
import com.ccuix.eshop.util.DBManagerConnection;

public class StudentDataAccessObject {
 public boolean addStudent(String sno,String name,String sex,int age,double money){
	//l����ݿ�   jdbc
			try {
				
				Connection Zhao = DBManagerConnection.getConnection();
				//׼��sql���
				String sql="insert into student(sno,name,sex,age,money) values ('"+sno+"','"+name+"','"+sex+"',"+age+","+money+")";
				//����һ���ѯ���� statement
				Statement statement = Zhao.createStatement();
				//���� ��Ӱ�����: 1
				int row = statement.executeUpdate(sql);
				System.out.println("受影响的行: "+row);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return false;
		}

public boolean updateStudent(String sno,String name,String sex,int age,double money){
	try {
		Connection Zhao = DBManagerConnection.getConnection();
		//׼��sql���
		String sql="update student set sno='"+sno+"',name='"+name+"',sex='"+sex+"',age="+age+",money="+money+" where sno='"+sno+"'";
		//����һ���ѯ���� statement
		Statement statement = Zhao.createStatement();
		//���� ��Ӱ�����: 1
		int row = statement.executeUpdate(sql);
		System.out.println("��Ӱ�����: "+row);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
     return false;
	}
public boolean deleteStudent(String sno){
	try {
		Connection Zhao = DBManagerConnection.getConnection();
		//׼��sql���
		String sql="delete from student where sno= '"+sno+"'";
		//����һ���ѯ���� statement
		Statement statement = Zhao.createStatement();
		//���� ��Ӱ�����: 1
		int row = statement.executeUpdate(sql);
		System.out.println("��Ӱ�����: "+row);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return false;
	}
public List<StudentPO> selectStudent(){
	List<StudentPO> stuList = new ArrayList<StudentPO>();
	try {
		Connection Zhao = DBManagerConnection.getConnection();
		//׼��sql���
		String sql="select sno,name,sex,age,money from student";
		//����һ���ѯ���� statement
		Statement statement = Zhao.createStatement();
		//���� ��Ӱ�����: 1
		ResultSet set = statement.executeQuery(sql);
		while(set.next()){
		StudentPO student = new StudentPO(set.getString("sno"),set.getString("name"),set.getString("sex"),set.getInt("age"),set.getDouble("money"));
		stuList.add(student);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
    return stuList;
	}
public StudentPO selectStudentBySno(String sno){
	StudentPO student = null;
	try {
		Connection Zhao = DBManagerConnection.getConnection();
		//׼��sql���
		String sql="select sno,name,sex,age,money from student where sno='"+sno+"'";
		//����һ���ѯ���� statement
		Statement statement = Zhao.createStatement();
		//���� ��Ӱ�����: 1
		ResultSet set = statement.executeQuery(sql);
		if(set.next()){
			student = new StudentPO(set.getString("sno"),set.getString("name"),set.getString("sex"),set.getInt("age"),set.getDouble("money"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
     return student;
	}
}
