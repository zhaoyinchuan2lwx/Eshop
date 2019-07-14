package com.ccuix.eshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccuix.eshop.service.StudentManagerService;
/*
 * 处理jsp 资源请求
 * */
public class StudentAddController extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	System.out.println("你带那");
	
	String sno = request.getParameter("sno");
	String name = request.getParameter("name");
	String sex = request.getParameter("sex");
	String age = request.getParameter("age");
	String money = request.getParameter("money");
	System.out.println("sno="+sno);
	System.out.println("name="+name);
	System.out.println("sex="+sex);
	System.out.println("age="+age);
	System.out.println("money="+money);
	
	
	StudentManagerService studentManagerService = new StudentManagerService();
	
	studentManagerService.addStudent(sno, name, sex, age, money);
}
}
