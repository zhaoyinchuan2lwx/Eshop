<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/base.css">
<style type="text/css">
#sorry_left{
   width: 400px;
   height: 200px;
   float: left;
   text-align: right;
}
#sorry_right{
   width: 500px;
   height: 200px;
   float: left;
   font-weight: bold;
   color: red;
}

</style>
</head>
<body>
	<div id="box">
		<%@include file="/jsp/comm/header.jsp"%>
		<div id="content">
		   <div id="sorry_left">		   
		      <img alt="" src="<%=path %>/images/sorry.gif">
		   </div>
		   <div id="sorry_right">
		     	<p>对不起，资源找不到！</p>
				<p>请联系管理员！</p>
				<p>谢谢合作！</p>
		   </div>
		</div>
		<%@include file="/jsp/comm/footer.jsp"%>
	</div>
</body>
</html>