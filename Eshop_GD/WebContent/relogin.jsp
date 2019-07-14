<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"href="./css/base.css">
<link type="text/css" rel="stylesheet"href="./css/re_login.css">
</head>
<body>

<div id="box">
  <%@include file="/jsp/comm/header.jsp" %>
<div id="content">
    <div id="detailMerchandise">
	     <img alt="" src="images/EditUser_01.gif">
	 </div>
	 <div id="order">
	 <form action="updateLogin" method="post">
	     <table>
	        <tr class="table_bg">
	            <td class="order_col">会员级别
	            <input type="hidden" value="${memberPO.id}" name="id">
	            </td>
	            <td>
	            <select name="memberlevel">
	            <c:if test="${memberPO.memberlevel eq 1 }">
		                                <option value="1">普通会员</option>
		                            </c:if>
		                            <c:if test="${memberPO.memberlevel eq 2 }">
		                                <option value="2">黄金会员</option>
		                            </c:if>
		                            <c:if test="${memberPO.memberlevel eq 3 }">
		                                <option value="3">白金会员</option>
		                            </c:if>
		                            <c:if test="${memberPO.memberlevel eq 4 }">
		                                <option value="4">钻石会员</option>
		                            </c:if>
	            </select>
	            </td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">真实姓名</td>
	            <td><input type="text" value="${memberPO.memberName}" name="memberName"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">登录账号</td>
	            <td><input type="text" value="${memberPO.loginName}" name="loginName"></td>
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
	            <td><input type="text" value="${memberPO.phone}" name="phone"></td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">联系地址</td>
	            <td><input type="text" value="${memberPO.address}" name="address"></td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">邮政编码</td>
	            <td><input type="text" value="${memberPO.zip}"name="zip"></td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">电子邮箱</td>
	            <td><input type="text" value="${memberPO.email}" name="email"></td>
	        </tr>
	        <tr class="table_bg">
	            <c:if test="${info eq '修改成功'}">
	            <td colspan="2"align="center"><font size="4" color="green">${info}</font></td>
	             </c:if>
	             <c:if test="${info ne '修改成功'}">
	            <td colspan="2"align="center"><font size="4" color="red">${info}</font></td>
	             </c:if>
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