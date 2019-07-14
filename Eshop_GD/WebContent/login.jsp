<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/base.css">
<link type="text/css" rel="stylesheet" href="./css/re_login.css">
</head>
<body>
<div id="box">
  <%@include file="/jsp/comm/header.jsp" %>
<div id="content">
    <div id="detailMerchandise">
	     <img alt="" src="images/icon_regster.gif">
	 </div>
	 <div id="order">
	 <form action="login" method="post">
	     <table>
	        <tr class="table_bg">
	            <td class="order_col">会员级别</td>
	            <td><input type="text" value="1" name="memberlevel"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">真实姓名</td>
	            <td><input type="text" value="张三" name="memberName"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">登录账号</td>
	            <td><input type="text" value="zhngsan" name="loginName"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">登录密码</td>
	            <td><input type="password" name="pass1"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">核对密码</td>
	            <td><input type="password" name="pass2"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">联系电话</td>
	            <td><input type="text" value="1563829078" name="phone"></td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">联系地址</td>
	            <td><input type="text" value="天南地北" name="address"></td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">邮政编码</td>
	            <td><input type="text" value="130000"name="zip"></td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">电子邮箱</td>
	            <td><input type="text" value="235@qq.com" name="email"></td>
	        </tr>
	        <tr id="submitButton">
	           <td colspan="2"align="center"> <input type="submit" value="保存"></td>
	        </tr>
	     </table> 
	     </form>      
	 </div>
	    
</div>
 <%@include file="/jsp/comm/footer.jsp" %>
</div>
</body>
</html>