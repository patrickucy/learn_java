<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'e3.jsp' starting page</title>
    
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
  	arithm
    : ${1+1}   <br/><br/>
    <%-- ${"abc" + "bcd"} --%>
    : ${"123"+"321" }  <br/><br/>
    : ${1>0}  <br/><br/>
    
    association<br/><br/>
    <% 
    	request.setAttribute("str1", "abc");
    %>
    
    :${"abc" == requestScope.str1 } <br/><br/>
    
    logic 
    :${ 1>0 && 2<1 } <br/><br/>
    
    empry operation<br/><br/>
    <%
    	request.setAttribute("str2", "");
     %>
     empty string will be true here :${empty str2 } <br/> <br/>
    
    <%
    	List<String> list = new ArrayList<String>();
    	list.add("abc");
    	request.setAttribute("list", list);
    
     %>
     
     empty set: ${empty list} <br/><br/>
     null value is also true
     
     <%
     	request.setAttribute("obj", null);
      %>
      null value:${empty obj}
     
    
    
    
  </body>
</html>










