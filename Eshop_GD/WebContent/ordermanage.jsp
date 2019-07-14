<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"href="./css/base.css">
<link type="text/css" rel="stylesheet"href="./css/order_manage.css">
</head>
<body>
<div id="box">
  <%@include file="/jsp/comm/header.jsp" %>
<div id="content">
<div id="ordermana">
	            <img alt="" src="images/icon_goods.gif">
	        </div>
<div id="orderlist">
	            <table>
	                <tr class="table_bg">
	                   <th>订单编号</th>
	                   <th>金额</th>
	                   <th>下单日期</th>
	                   <th>订单状态</th>
	                   <th>编辑</th>
	                </tr>
	                <c:forEach items="${ordersList }"  var="order">
	                <tr>
	                   <td>${order.orderNO }</td>
	                   <td>&#165;${order.money }</td>
	                   <td>${order.orderDate }</td>
	                   <td>
	                   <c:if test="${order.orderStatus eq 1}">
	                                                         已下单，未受理
	                    </c:if>  
	                     <c:if test="${order.orderStatus eq 2}">
	                                                         已发货，未确认订单
	                    </c:if> 
	                     <c:if test="${order.orderStatus eq 3}">
	                                                         已收货，未评价
	                    </c:if> 
	                     <c:if test="${order.orderStatus eq 4}">
	                                                         已收货，已评价
	                    </c:if>                                    
	                    </td>
	                   <td><div id=check><a href="<%=path %>/checkOrderById?id=${order.id }">查看订单 </a> </div>
	                   <c:if test="${order.orderStatus eq 1}">			                   
			                   	   <a href="<%=path %>/checkOrderById?" style="margin-left: 20px;">删除订单</a> 
			                   </c:if>
	                   <c:if test="${order.orderStatus ne 1}">			                   
			                   	   <a href="#?id=${order.id }" style="margin-left: 20px;">申请退款</a> 
			                   </c:if>
	                    </td>
	                </tr>
	                </c:forEach>
	            </table>
	        </div>

</div>
<%@include file="/jsp/comm/footer.jsp" %>
</div>
</body>
</html>