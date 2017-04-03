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
    
    <title>JSTL01</title>
    
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
    	Employee1 e = new Employee1();
        	e.setGender("m");
        	request.setAttribute("e", e);
    %>
    
    Gender: ${e.gender } <br/>
   
    ---------------------------------<br/> 
    Gender: <c:if test="${e.gender == 'm'}">Male</c:if>  <c:if test="${e.gender == 'f'}">Female</c:if>  <br/>
    
    
    ---------------------------------<br/> <!-- the if else pattern is as follow  -->
   	Gender: <c:if test="${e.gender == 'm'}" var="rs" scope="request">Male</c:if>  <!-- here means request.setAttribute("rs", resultOfTest) -->
   	  <c:if test="${!rs}">Female</c:if>  <br/>
    
    
    
    
    
  </body>
</html>









