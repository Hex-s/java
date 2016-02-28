<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'times.jsp' starting page</title>
    
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
    <% 
    	//如果application没有count，即第一次访问
    	if(application.getAttribute("count") == null){
    		int count = 0;
    		//将访问量存入application
    		application.setAttribute("count",count);
    	}
    	//获取上一次页面中累加的访问量
    	int count = (Integer)application.getAttribute("count");
    	//累加当前的访问量
    	count++;
    	//将访问量存入application
    	application.setAttribute("count",count);
    	
    	//允许在页面访问的作用域 pageContext,request,session,application
    %>
    当前访问量：<%=count %>
  </body>
</html>
