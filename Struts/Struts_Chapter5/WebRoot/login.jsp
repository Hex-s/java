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
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <!--  <form action="login.action" method="post">
    	userName:<input type="text" name="userName"/><br/>
    	password:<input type="password" name="password"/><br/>
    	<input type="submit" value="login"/>
    </form>-->
    
    <!-- struts的UI标签和后台的Action是绑定的 -->
    <!-- struts的UI必须放入s:form表单中 -->
    <s:form action="login.action" method="post" theme="simple">
    	userName:<s:textfield name="userName" label="name"></s:textfield><br/>
    	password:<s:password name="password" label="pwd"></s:password><br/>
    	<!-- checkboxlist表示一组复选框 -->
    	<!-- listKey表示复选框对应的value属性值，listValue表示页面呈现的文本 -->
    	hobby:<s:checkboxlist list="#{'keyA':'valueA','keyB':'valueB','keyC':'valueC'}" name="hobby" listKey="value" listValue="key"></s:checkboxlist>
    	<s:select list="#{'keyA':'valueA','keyB':'valueB','keyC':'valueC'}"></s:select>
    	<s:submit value="login"></s:submit>
    </s:form>
  </body>
</html>
