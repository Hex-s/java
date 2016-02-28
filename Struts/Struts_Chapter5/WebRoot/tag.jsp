<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ognl.Ognl"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tag.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <SCRIPT type="text/javascript">
  var str = "alert(1)";
  window.eval(str);
  </SCRIPT>
  <body>
    <!-- struts2的标签库都是基于OGNL表达式获取数据的 -->
    <!-- property标签用来呈现OGNL表达式运行的结果 -->
    <s:property value="userName"/>
    <!-- 访问ActionContext中的数据通过#访问 -->
    <s:property value="#action.userName"/>
    <!-- 访问session中的数据 -->
    <s:property value="#session.loginUser"/>
    <!-- 判断用户是否登陆 -->
    <s:if test="#session.loginUser == null">
    	<a href="#">登陆</a>
    </s:if>
    <s:else>
    	欢迎<a href="#"><s:property value="#session.loginUser"/></a>回来
    </s:else><br/>
    <!-- set标签用来在ActionContext中添加一个键值对 -->
    <s:set var="str" value="'niit'"></s:set>
    <s:set var="list" value="{'a','b','c','d'}"></s:set>
    <!-- 迭代集合或数组 -->
    <table border="1">
    	<tr>
    		<td>值</td>
    		<td>索引</td>
    		<td>当前读取的个数</td>
    		<td>是否是奇数</td>
    		<td>是否是偶数</td>
    		<td>是否是第一个元素</td>
    		<td>是否是最后个元素</td>
    	</tr>
    <s:iterator value="#list" var="element" status="status">
    	<tr>
    		<td>${element }</td>
    		<td>${status.index }</td>
    		<td>${status.count }</td>
    		<td>${status.odd }</td>
    		<td><s:property value="#status.even"/> </td>
    		<td><s:property value="#status.first"/> </td>
    		<td><s:property value="#status.last"/> </td>
    	</tr>
    </s:iterator>
    </table>
    
    <!-- append标签将多个集合追加在一个迭代器中 -->
    <s:set value="{'a','b','c','g','h','i'}" var="listA"></s:set>
    <s:set value="{'d','e','f'}" var="listB"></s:set>
    <s:append var="newList">
    	<s:param value="#listA"></s:param>
    	<s:param value="#listB"></s:param>
    </s:append>
    <s:property value="#newList"/><br/>
    <s:iterator value="#newList" var="s">
    	<s:property value="#s"/>
    </s:iterator>
   	<br/>
   	
   	<!-- 截取集合 -->
    <s:subset source="#listA" start="1" count="3" var="subList">
    	<s:iterator>
    		<s:property/>
    	</s:iterator>
    </s:subset>
    <br/>
    
    <!-- bean标签用来在ActionContext中创建对象-->
    <s:bean name="com.niit.bean.User" var="user">
    	<s:param name="userName" value="'tony'"></s:param>
    	<s:param name="age" value="21"></s:param>
    </s:bean>
    <s:property value="#user.userName"/><br/>
    
    <!-- date标签用来对时间进行格式化 -->
    <s:bean name="java.util.Date" var="time"></s:bean>
   	<s:date name="#time" format="yyyy-MM-dd" /><br/>
   	
   	<!-- 定义一个URL路径 -->
   	<s:url action="forward.action" var="url"></s:url>
   	<s:a href="%{#url}">forward.action</s:a>
    <!-- 调试标签 -->
    <s:debug></s:debug>
  </body>
</html>
