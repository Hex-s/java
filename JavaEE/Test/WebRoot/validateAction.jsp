<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'validateAction.jsp' starting page</title>
    
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
    	String code=session.getAttribute("code").toString();
    	System.out.println(code);
    	String inputCode=request.getParameter("inputCode");
    	System.out.println(inputCode);
    	if(inputCode.equalsIgnoreCase(code))
    	{
    		request.setAttribute("msg","输入正确");
    		request.getRequestDispatcher("index.jsp").forward(request,response);
    	}
    	else
    	{
    		request.setAttribute("msg","输入错误");
    		request.getRequestDispatcher("index.jsp").forward(request,response);
    	}
     %>
  </body>
</html>
