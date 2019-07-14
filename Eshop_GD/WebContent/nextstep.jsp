<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"href="./css/base.css">
<link type="text/css" rel="stylesheet"href="./css/next_step.css">
<link type="text/css" rel="stylesheet"href="./css/cartList.css">
<script type="text/javascript">
function confirmCart(){
	location.href="confirmCart.html";
}
function submitCart(){
	location.href="submitCart";
}
</script>
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
	                   <td><div class="now">确认订单信息</div> </td>
	                   <td><img alt="" src="images/Car_15.gif"> </td>
	                   <td><img alt="" src="images/Car_11.gif"> </td>
	                   <td><div class="next">订单提交成功</div> </td>
	                   <td><img alt="" src="images/Car_15.gif"> </td>
	               </tr>
	           </table>
	        </div>
	 <div id="order">
	     <table>
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
	            <td><input type="text" value="${memberPO.memberName }"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">收货人联系方式</td>
	            <td><input type="text" value="${memberPO.phone }"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">收货人邮编</td>
	            <td><input type="text" value="${memberPO.zip }"></td>
	        </tr>
	        <tr class="table_bg">
	            <td class="order_col">收货人详细地址</td>
	            <td><input type="text" value="${memberPO.address }"></td>
	        </tr>
	     </table>       
	 </div>
	  <div id="submitorder">
	            <img alt="" src="images/Car_icon_back.gif" onclick="javascript:location.href='browseIdex'">
	            <img alt="" src="images/Car_icon_06.gif" onclick="submitCart()">
	        </div>
	    
</div>
 <%@include file="/jsp/comm/footer.jsp" %>
</div>
</body>
</html>