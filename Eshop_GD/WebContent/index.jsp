<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"href="./css/base.css">
<link type="text/css" rel="stylesheet"href="./css/suiyiba.css">
<script type="text/javascript">
function checkmerdise(id){
	alert(id);
	location.href="browseDetial?id="+id;
}
function moreDetail(special){
	location.href="moreMerdise?special="+special+"";
}
function addCart(merchandise,price,sprice){
	alert(merchandise);
	location.href="addCart?merchandise="+merchandise+"&price="+price+"&sprice="+sprice;
}
function selectMerchandise(category){
	alert(category);
	location.href="selctMerdiseBycategory?category="+category;
}
</script>
</head>
<body>

   <div id="box">
   <%@include file="/jsp/comm/header.jsp" %>
    <div id="content">
     <div id="cont_left">
     
     <c:if test="${memberPO eq null}">
     <div id="left_login">
      <form action="memberLogin" method="post">
     <h3>会员登录</h3>
     <div class="login_infor">
                登录账号：<input name="loginName">
     </div>
     <div class="login_infor">
        登录密码：<input type="password" name="loginPwd">
     </div>
     <div id="confrimbutton">
        <input type="submit" value="登录"id="uername">
        <a href="login.jsp"><input type="button" value="注册" id="password"></a>
     </div>
     </form>
     </div>
     </c:if>
     <c:if test="${memberPO ne null}">
     <div id="left_login">
      <form action="memberLogin" method="post">
     <div class="login_infor">
               欢迎：${memberPO.memberName}
     </div>
     <div class="login_infor">
                 会员级别：${memberPO.levelName}
     </div>
     <div id="confrimbutton">
        <a href="logOut">安全退出</a>
     </div>
     </form>
     </div>
     </c:if>
     <div id="left_up">
          <h3>商品类别</h3>
          <ul id="up_ul">
          <c:forEach items="${cateList }" var="cate">
             <li onclick="selectMerchandise(${cate.id })">${cate.cateName } </li>
             </c:forEach>
          </ul>
     </div>
 </div>
 <div id="cont_right">
     <div class="right_special">
       <div class="special_show">
       <img alt="" src="images/Icon_TeJia.gif" class="special_area">
 	    <img alt="" src="images/icon_more.gif" class="special_more" onclick="moreDetail(1)">
       </div>
       <div class="special_over"></div>
       <div class="specialMer">
       <c:forEach items="${specialMerList }" var="mer" begin="0" end="2">
       <div class="specialMerContent">
          <p>
 	        <img alt="" src="Picture/${mer.picture }">
 	     </p>
 	     <p>${mer.merName }</p>
 	     <p>市场价：${mer.price }</p>
 	     <p>特价：${mer.sprice }</p>
 	      <p>
 	           <input type="button" class="detailSpecialMer" onclick="checkmerdise(${mer.id })">
 	         <input type="button" class="buySpecialMer" onclick="addCart(${mer.id},${mer.price },${mer.sprice })">
 	      </p> 
     </div>
     </c:forEach>
 </div>
 
 </div>
 <div class="right_special">
       <div class="special_show">
       <img alt="" src="images/NewGoods_03.gif" class="special_area">
 	 <img alt="" src="images/icon_more.gif" class="special_more" onclick="moreDetail(0)">
       </div>
       <div class="special_over"></div>
       <div class="specialMer">
       <c:forEach items="${newMerList }" var="mer" begin="0" end="2">
       <div class="specialMerContent">
           <p>
 	        <img alt="" src="Picture/${mer.picture }">
 	     </p>
 	     <p>${mer.merName }</p>
 	     <p>市场价：${mer.price }</p>
 	      <p>
 	       <input type="button" class="detailSpecialMer"onclick="checkmerdise(${mer.id })">
 	       <input type="button" class="buySpecialMer">
 	      </p> 
     </div>
     </c:forEach>

 </div>
 </div>
 </div>
 </div>
   <%@include file="/jsp/comm/footer.jsp" %>
 </div>
</body>
</html>