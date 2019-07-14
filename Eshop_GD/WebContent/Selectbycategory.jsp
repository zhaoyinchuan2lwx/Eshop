<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet"href="./css/xiangqing.css">
</head>
<body>
<div id="box">
   <%@include file="/jsp/comm/header.jsp" %>
  <div id="content">
    <div id="special_show">
    <c:if test="${mer.special eq 1}">
    <img alt="" src="images/NewGoods_05.gif" id="special_area">
    </c:if>
    <c:if test="${mer.special ne 1}">
    <img alt="" src="images/NewGoods_03.gif" id="special_area">
    </c:if>
    </div>
    <div id="table_detail">
    <table >
      <c:forEach items="${merchandiseList}" var="mer">
      <tr>
      <td align="center"><img alt="" src="Picture/${mer.picture }">
      </td>
      <td class="detail_b">
        <p>${mer.merName }</p>
        <p>市场价：￥${mer.price }</p>
        <c:if test="${mer.special eq 1}">
        <p>特价：￥${mer.sprice}</p>
        </c:if>
        <p>生产厂家：${mer.manufacturer }</p>
      </td>
      <td class="detail_b"><p>${mer.merDesc}</p></td>
      <td><p>
	         <a href="what.jsp"><input type="button" class="detailSpecialMer"></a>
	         <input type="button" class="buySpecialMer">
	      </p> </td>
      </tr>
      <tr class="detail_a">
       <td colspan="4"></td>
      </tr>
      </c:forEach>
    </table>
    </div>
  </div>
  <%@include file="/jsp/comm/footer.jsp" %>
  </div>
</body>
</html>