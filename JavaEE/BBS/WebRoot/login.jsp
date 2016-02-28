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
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">
	
  </head>
  <script type="text/javascript" src="js/jquery-1.6.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
  	$("#loginBtn").click(function(){
  		$("#loginForm").submit();
  	})
  })
  </script>
  <body>
    <div id="body">
  	<!-- 页眉 -->
  	<div id="head">
  		<div id="title">
  			<span style="padding-left: 20px; font-size: 30px; font-weight: bold;">NIIT</span>
  			<span style="font-size:30px; font-weight: bold;">BBS</span>
  		</div>
  	</div>
  	<div>
  		<form action="loginAction.jsp" method="post" id="loginForm">
	  		<table border="0" cellspacing="0" align="center" style="margin-top: 50px; margin-bottom: 50px" width="500">
	  			<tr height="40">
	  				<td width="80">用户名:</td>
	  				<td width="220"><input type="text" name="userName" style="width: 200px"/></td>
	  				<td width="200" style="color: red">
	  				<% 
	  					if(request.getAttribute("nameError") != null){
	  						out.print(request.getAttribute("nameError"));
	  					}
	  				%>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>密码：</td>
	  				<td><input type="password" name="password" style="width: 200px"/></td>
	  				<td style="color: red">
	  				<% 
	  					if(request.getAttribute("pwdError") != null){
	  						out.print(request.getAttribute("pwdError"));
	  					}
	  				%>
	  				</td>
	  			</tr>
	  			<tr height="40">
	  				<td colspan="2" align="center">
	  					<input value="登陆" type="button" id="loginBtn"/>
	  					<input value="忘记密码" type="button" id="forgetPwdBtn"/>
	  				</td>
	  				<td></td>
	  			</tr>
	  		</table>
  		</form>
  	</div>
  	<!-- 页脚 -->
  	<div style="text-align: center;">
  		CopyRight2014 NIIT
  	</div>
  </div>
  </body>
</html>
