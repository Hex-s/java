<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'calculator.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function cal(opt){
  	var frm = document.getElementById("calFrm");
  	switch(opt){
  	case "+":
  		frm.action = "add.action";
  		break;
  	case "-":
  		frm.action = "sub.action";
  		break;
  	case "/":
  		frm.action = "div.action";
  		break;
  	}
  	frm.submit();
  }
  </script>
  <body>
    <form id="calFrm"  method="post">
    num1:<input type="text" name="num1"/><br/>
    num2:<input type="text" name="num2"/><br/>
    <input type="button" value="+" onclick="cal('+')"/>
    <input type="button" value="-" onclick="cal('-')"/>
    <input type="button" value="*"/>
    <input type="button" value="/" onclick="cal('/')"/>
    </form>
  </body>
</html>
