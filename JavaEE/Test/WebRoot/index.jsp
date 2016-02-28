<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  <style>
  *{font-size:12px};
  </style>
  <script type="text/javascript">
  function refreshCode()
  {
  	var ran=Math.floor(Math.random()*10000);
	document.getElementById("img").src="code.jsp?id="+ran;
  }
  </script>
  <body>
  <form action="validateAction.jsp" method="post">
  <table border="1" width="300" align="center">
  	<tr>
  		<td align="right" width="40%">用户名：</td>
  		<td width="60%"><input type="text"></td>
  	</tr>
  	<tr>
  		<td align="right">密码：</td>
  		<td><input type="password"></td>
  	</tr>
  	<tr>
  		<td align="right">验证码：</td>
  		<td><img id="img" src="code.jsp"><a href="javascript:refreshCode()">刷新</a></td>
  	</tr>
  	<tr>
  		<td align="right">输入验证码：</td>
  		<td><input type="text" name="inputCode"></td>
  	</tr>
  	<tr>
  		<td colspan="2" align="center"><input type="submit" value="登陆"></td>
  	</tr>
  </table>
  </form>
  <div style="color: red; text-align: center;">
  <%
  	if(request.getAttribute("msg")!=null)
  	{
  %>
  <%=request.getAttribute("msg") %>
  <%
  	}
   %>
  </div>
    
  </body>
</html>
