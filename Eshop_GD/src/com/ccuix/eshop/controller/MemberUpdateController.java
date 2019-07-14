package com.ccuix.eshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccuix.eshop.service.MemberService;

public class MemberUpdateController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse responese)
			throws ServletException, IOException {
		System.out.println("用户修改成功");
	     request.setCharacterEncoding("UTF-8");
	     String memberlevel = request.getParameter("memberlevel");
	     String memberName = request.getParameter("memberName");
	     String loginName = request.getParameter("loginName");
	     String pass1 = request.getParameter("pass1");
	     String pass2 = request.getParameter("pass2");
	     if("".equals(pass1) || pass1==null || "".equals(pass2) || pass2==null){
	    	 System.out.println("密码为空"); 
	     }else if(pass1.equals(pass2)){
	    	 System.out.println("可以正常执行");
	    	 String id = request.getParameter("id");
	    	 String phone = request.getParameter("phone");
		     String address = request.getParameter("address");
		     String zip = request.getParameter("zip");
		     String email = request.getParameter("email");
	    	 System.out.println("memberlevel"+memberlevel);
			 System.out.println("memberName"+memberName);
	    	 System.out.println("loginName"+loginName);
	    	 System.out.println("pass1"+pass1);
	    	 System.out.println("phone"+phone);
	    	 System.out.println("address"+address);
	    	 System.out.println("zip"+zip);
	    	 System.out.println("email"+email);
	    	 MemberService memberService = new MemberService();
	    	 boolean b = memberService.update(id ,memberlevel, memberName, loginName, pass1, phone, address, zip, email);
	          if(b==true){
	        	  System.out.println("修改成功");
	        	  //responese.getWriter().write("<font color = 'green'>success</font>");
	         //request.setAttribute("info","欢迎你" );
	         //HttpSession session = request.getSession();
	         request.setAttribute("info", "修改成功");
	         request.getRequestDispatcher("relogin.jsp").forward(request, responese);
	        // session.setAttribute("memberPO", null);
	        // session.setAttribute("relogin.jsp", "欢迎你");
	         
	         //responese.sendRedirect("relogin.jsp");
	          }else{
	        	  System.out.println("修改失败");
	        	  HttpSession session = request.getSession();
	        	  request.setAttribute("info", "修改失败");
	 	        responese.sendRedirect("relogin.jsp");
	          }
	     }
	}
}
