<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
   String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   function clearKey(t){
	  t.value="";
   }
   function setKey(t){
	   if(t.value=""){
	   t.value="商品关键字";
	   }
   }
</script>
</head>
<body>
<div id="header">
       <div id="searchMer">
       <form action="<%=path %>/findMerByCateAndLikeName" method="post">
        <img alt="" src="images/icon_login.gif">
        <input value="商品关键字" onclick="clearKey(this)" onblur="setKey(this)" name="nameKey">
        <select name="category">
        <option value="-1">选择商品类别</option>
         <c:forEach items="${cateList }" var="cate">
         <option value="${cate.id }">${cate.cateName }</option>
      </c:forEach>
       </select>
       <input type="image" src="images/icon_search.gif">
</form>
 </div>
 </div>
 <div id="menu">
     <ul id="menu_ul">
     <li><a href="<%=path %>/browseIdex">商城首页</a></li>
     <li><a href="<%=path %>/selectCartList">购物车管理</a></li>
     <li><a href="<%=path %>/orderList">订单管理</a></li>
     <li><a href="cusLeaveword">顾客留言</a></li>
     <li><a href="relogin.jsp">修改注册资料</a></li>
 </ul>
 </div>
</body>
</html>