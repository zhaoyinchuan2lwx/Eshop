<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/base.css">
<link type="text/css" rel="stylesheet" href="./css/cus_tomers.css">
</head>
<body>
  <div id="box">
   <%@include file="/jsp/comm/header.jsp" %>
  <div id="content">
	        <div class="leave_word">
	            <img alt="" src="images/icon_liuyan.gif">
	        </div>
	        <c:forEach items="${leaveword }" var="lea" begin="0" end="2">
	        <table>
	          <tr class="top">
	            <td><div class="fly_left"><span>留言标题：</span>${lea.title }</div>
	            <div class="fly_right"><span>顾客姓名：</span>${lea.memberName }<span>留言时间：</span>${lea.leaveDate }</div></td></tr>
	        <tr> <td>${lea.context }</td></tr>
             
	           <tr class="top">
	            <td><div class="fly_left"><span>管理员回复：</span></div></td>
	          </tr>
	         <tr> <td>${lea.answerContext }</td></tr>
	        </table>
	        </c:forEach>
	        <div class="leave_word">
	           <img alt="" src="images/icon_LeaveWord.gif">
	        </div>
	        <form action="Leaveconent" method="post">
	    <div id="leave_s">
	   <div id="words">  留言标题：<input type="text" size="100" value="" name="title"></div>
	   <div id="stup">  留言内容：   <textarea cols="100" rows="5" value="" name="content"></textarea></div>
	     <div id="wordButton"> <input type="submit" value="提交留言"></div>
	     </div>
	     </form>
	    </div>
	    <%@include file="/jsp/comm/footer.jsp" %>
	    </div>
</body>
</html>