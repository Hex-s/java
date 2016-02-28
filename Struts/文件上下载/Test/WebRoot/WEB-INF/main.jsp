<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
  function parsePath(fileName){
  	fileName = encodeURI(encodeURI(fileName));
  	location.href = "download?path="+fileName;
  }
  </script>
  <body>
    Download<hr/>
    <c:forEach items="${files}" var="fileName">
    	<div><a href="javascript:parsePath('data/${fileName }')">${fileName }</a></div>
    </c:forEach>
	 <hr/>
	 Upload<hr/>
	  <!-- 数据上传表单提交方式必须为post且 表单类型为multipart/form-data -->
	 <form method="post" action="upload" enctype="multipart/form-data">
	  	<input type="file" name="file1"/><br/>
	  	<input type="text" name="txt" value="tom"><br/>
	  	<input type="submit" value="upload"/>
  	 </form>
  </body>
</html>
