<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/base.css">
<link type="text/css" rel="stylesheet" href="./css/cartList.css">
<link type="text/css" rel="stylesheet" href="./css/order_submit.css">
</head>
<body>
<div id="box">
	    <%@include file="/jsp/comm/header.jsp" %>
	    <div id="content">
	        <div id="detailMerchandise">
	            <img alt="" src="images/icon_goods.gif">
	        </div>
	        <div id="cartStatus">
	           <table>
	               <tr>
	                   <td><img alt="" src="images/Car_07.gif"> </td>
	                   <td><div class="next">查看购物车物品</div> </td>
	                   <td><img alt="" src="images/Car_15.gif"> </td>
	                   <td><img alt="" src="images/Car_09.gif"> </td>
	                   <td><div class="next">确认订单信息</div> </td>
	                   <td><img alt="" src="images/Car_15.gif"> </td>
	                   <td><img alt="" src="images/Car_11.gif"> </td>
	                   <td><div class="now">订单提交成功</div> </td>
	                   <td><img alt="" src="images/Car_15.gif"> </td>
	               </tr>
	           </table>
	        </div>
	        <div id="orderdetail">
	            <table>
	                <tr>
	                  <td rowspan="4" align="center" width="300"><img alt="" src="images/Car_icon_10.gif" id="order_picture"> </td>
	                 <td  class="table_bg">恭喜您，订单提交成功</td> 
	                </tr>  
	                <tr> 
	                 <td  class="table_bg">订单编号：${orderPO.orderNO }</td></tr>
	                <tr> <td  class="table_bg">总金额：￥${cartMoney}</td></tr>
	                 <tr><td  class="table_bg">下单日期：${orderPO.orderDate }</td></tr>
	            
	            </table>
	        </div>
	    
	    </div>
	   <%@include file="/jsp/comm/footer.jsp" %>
	</div>
</body>
</html>