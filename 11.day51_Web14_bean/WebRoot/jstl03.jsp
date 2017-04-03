<%@page import="bean.Employee1"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSTL03</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.row1{
			background-color: #fff8dc;
		}
		.row2{
			background-color: yellow;
		}
		
	</style>

  </head>
  
  <body>
    
     <table width="60%" border="1" cellpadding="0" cellspacing="0">
     	<tr>
     		<td>Name</td> <td>Age</td> <td>Index</td> <td>Count</td>
     	</tr>
     
     	<c:forEach items="${employees}" var="e" varStatus="s">
     		<tr class="row${s.index % 2 + 1}"> <td>${e.name}</td> <td>${e.age}</td>  <td>${s.index}</td>  <td>${s.count}</td> </tr>
     	</c:forEach>
     </table>
     
  </body>
</html>








