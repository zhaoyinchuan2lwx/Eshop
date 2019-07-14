<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/base.css">
<link type="text/css" rel="stylesheet" href="./css/cartList.css">
<script type="text/javascript">
function confirmCart(){
	location.href="cart_confirm.jsp";
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
	                   <td><div class="now">查看购物车物品</div> </td>
	                   <td><img alt="" src="images/Car_15.gif"> </td>
	                   <td><img alt="" src="images/Car_09.gif"> </td>
	                   <td><div class="next">确认订单信息</div> </td>
	                   <td><img alt="" src="images/Car_15.gif"> </td>
	                   <td><img alt="" src="images/Car_11.gif"> </td>
	                   <td><div class="next">订单提交成功</div> </td>
	                   <td><img alt="" src="images/Car_15.gif"> </td>
	               </tr>
	           </table>
	        </div>
	        <div id="cartMerchandiseList">
	            <table>
	                <tr class="table_bg">
	                   <th>商品名称</th>
	                   <th>市场价</th>
	                   <th>会员价</th>
	                   <th>数量</th>
	                   <th>金额</th>
	                   <th>删除</th>
	                </tr>
	                <c:forEach items="${cartSelectedMerList}" var="car">
	                <tr>
	                   <td>${car.merName}</td>
	                   <td>&#165;${car.merPrice}</td>
	                   <td>&#165;${car.price}</td>
	                   <td><input type="text" value="${car.number}"></td>
	                   <td>&#165;${car.money}</td>
	                   <td><img alt="" src="images/delete_01.gif"> </td>
	                </tr>
	                </c:forEach>
	            
	                <tr class="table_bg">
	                   <td colspan="6"><div>总价格：${cartPO.money}元（不包含配送费用）</div> </td>
	                </tr>
	            </table>
	        </div>
	        <div id="cartButton">
	            <img alt="" src="images/Car_icon_01.gif">
	           <a href="index.jsp"> <img alt="" src="images/Car_icon_02.gif"></a>
	            <a href="nextstep.jsp"><img alt="" src="images/Car_icon_03.gif" onclick="confirmCart()"></a>
	        </div>
	    </div>
	    <%@include file="/jsp/comm/footer.jsp" %>
	    </div>
</body>
</html>