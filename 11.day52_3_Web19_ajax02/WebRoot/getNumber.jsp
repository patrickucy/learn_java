<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getNumber.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript" src="js/my.js"></script>
	<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
	<script type="text/javascript">
		function f1() {
			var xhr = getXhr();
			xhr.open('get', 'getNumber.do', true);
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4){
					var txt = xhr.responseText;
					$('d1').innerHTML = txt;	
				}
			};
	 		xhr.send(null);
	
 		};
		
	</script>
  </head>
  
  <body style="font-size: 30px; font-style: italic;">
  	<a href="javascrip:;" onclick="f1();">Click to generate a random number</a>
    <div id="d1"></div>
  </body>
</html>
