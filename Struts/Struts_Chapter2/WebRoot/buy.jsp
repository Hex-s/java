<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 使用转换器进行表单对象的转换需要将表单元素的name设为action中的对象名 -->
    <form action="buy.action" method="post">
	    商品编号:<input type="text" name="ware"><br/>
	    商品名称：<input type="text" name="ware"/><br/>
	    价格：<input type="text" name="ware"/><br/>
	    购买数量：<input type="text" name="ware"/><br/>
    <input type="submit" value="购买"/>
    </form>
  </body>
</html>
