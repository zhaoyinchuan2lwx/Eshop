<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"href="./css/base.css">
<link type="text/css" rel="stylesheet"href="./css/order_detail.css">
</head>
<body>
<div id="box">
   <%@include file="/jsp/comm/header.jsp" %>
<div id="content">
    <div id="detailMerchandise">
	     <img alt="" src="images/icon_goods.gif">
	 </div>
	 <div id="order">
	     <table>
	        <tr class="table_bg">
	            <td class="order_col">订单编号</td>
	            <td>${orderPO.orderNO }</td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">金额</td>
	            <td>￥${orderPO.money }</td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">下单日期</td>
	            <td>${orderPO.orderDate }</td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">会员级别</td>
	            <td>${memberPO.levelName }</td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">会员优惠</td>
	            <td>${memberPO.favourable }折</td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">收货人姓名</td>
	            <td>${memberPO.memberName }</td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">收货人联系电话</td>
	            <td>${memberPO.phone }</td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">收货人邮政编码</td>
	            <td>${memberPO.zip }</td>
	        </tr>
	         <tr class="table_bg">
	            <td class="order_col">收货人详细地址</td>
	            <td>${memberPO.address }</td>
	        </tr>
	     </table> 
	    <div id="from">订单购物明细表</div>
	      <table>
	                <tr class="table_bg">
	                   <th>商品名称</th>
	                   <th>市场价</th>
	                   <th>会员价</th>
	                   <th>数量</th>
	                   <th>金额</th>
	                </tr>
	                <c:forEach items="${cartSelectedMerList}" var="cartSelectMer">
	                <tr >
	                   <td><a href="#">${cartSelectMer.merName }</a></td>
		                   <td>&#165;${cartSelectMer.merPrice }</td>
		                   <td>&#165;${cartSelectMer.price }</td>
		                   <td>${cartSelectMer.number }</td>
		                   <td>&#165;${cartSelectMer.money }</td>
	                 
	                </tr>
	                </c:forEach>
	                </table>      
	 </div>
	  <div id="submitButton">
	           <a href="javascript:history.back(-1)"><input type="button" value="返回"></a>
	        </div>
	    
</div>
<%@include file="/jsp/comm/footer.jsp" %>
</div>
</body>
</html>