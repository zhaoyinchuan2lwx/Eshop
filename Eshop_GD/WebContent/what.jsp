<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"href="./css/base.css">
<link type="text/css" rel="stylesheet"href="./css/What.css">
</head>
<body>
<div id="box">
  <%@include file="/jsp/comm/header.jsp" %>
<div id="content">
<div id="lala"> <img alt="" src="Picture/${merchandisePO.picture }"></div>
        <p>商品类别：${merchandisePO.cateName }</p>
        <p>商品型号：${merchandisePO.merModel }</p>
        <p>商品名称：${merchandisePO.merName }</p>
        <p>市场价：${merchandisePO.price }</p>
        <c:if test="${merchandisePO.sprice eq 1}">
        <p>特价：${merchandisePO.sprice }</p>
        </c:if>
        <p>出厂日期：${merchandisePO.leaveFactoryDate }</p>
        <p>生产厂家：${merchandisePO.manufacturer }</p>
  <p>商品描述：${merchandisePO.merDesc }</p>
</div>
<div id="buygood"><input type="submit" value="购买"></div>

<%@include file="/jsp/comm/footer.jsp" %>
</div>
</body>
</html>