package com.ccuix.eshop.service;

import com.ccuix.eshop.dao.StudentDataAccessObject;
import com.ccuix.eshop.po.StudentPO;



public class StudentManagerService {

	public boolean addStudent(String sno,String name, String sex,String age,String money){
		int int_age = Integer.parseInt(age);
		double double_money = Double.parseDouble(money);
		StudentDataAccessObject studentDataAccessObject = new StudentDataAccessObject();
		boolean b = studentDataAccessObject.addStudent(sno, name, sex, int_age, double_money);
		return b;
	}
	public StudentPO selectStudentBySno(String sno){
		StudentDataAccessObject studentDataAccessObject = new StudentDataAccessObject();
		return studentDataAccessObject.selectStudentBySno(sno);
	}
	
}
