<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <form action="login.action" method="post">
    	<s:text name="name">
    		<!-- 注入占位符的数据 -->
    		<s:param>5</s:param>
    		<s:param>10</s:param>
    	</s:text>
    	<input type="text" name="userName"/><br/>
    	<s:text name="pwd"></s:text><input type="password" name="password"><br/>
    	<input type="submit" value="login"/>
    </form>
    <hr/>
   	切换至  <a href="#">中文</a>&nbsp;&nbsp;<a href="#">English</a>
  </body>
</html>
