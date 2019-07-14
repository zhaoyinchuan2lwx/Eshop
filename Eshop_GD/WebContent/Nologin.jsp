<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/base.css">
<link type="text/css" rel="stylesheet" href="./css/Sorry.css">
</head>
<body>
<div id="box">
    <%@include file="/jsp/comm/header.jsp" %>
    <div id="conten">
    <div id="sorry">
    <img alt="" src="images/sorry.gif">
    </div>
    <div id="mesage">
    <p>对不起，您尚未登录</p>
     <p>如果您尚未注册，请先注册后登录</p>
     <p>谢谢合作</p>
    </div>   
     </div>
	    <%@include file="/jsp/comm/footer.jsp" %>
	    </div>
</body>
</html>