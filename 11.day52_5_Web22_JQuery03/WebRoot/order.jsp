<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
		$(function() {
			$('a.s1').toggle(function() {
				
				// ajax in jquery
				var flight = $(this).parent().siblings().eq(0).text();
				$(this).next().load('price.do','flight='+flight);
				$(this).html('show economy price');
			},function(){
				$(this).html('show all prices');
				$(this).next().empty();
			});
		});
	
	</script>
  </head>
  
  <body>
    <table width="80%" border="1" cellpadding="0" cellspacing="0" >
    	<tr>
    		<td>airline</td>
    		<td>airplane</td>
    		<td>departure time</td>
    		<td>arrival time</td>
    		<td>&nbsp;</td>
    		<td>economy</td>
    		<td>&nbsp;</td>
    	</tr>
    	<tr>
    		<td>CA1898</td>
    		<td> <a href="#" >boe787</a></td>
    		<td> 8:00 </td>
    		<td> 22:00</td>
    		<td> <a href="javascrip:;" class="s1"> check price</a> <div></div> </td>
    		
    		<td> $1200 </td>
    		<td> <button> buy ticket </button> </td>
    	</tr>
    	<tr>
    		<td>MU2318</td>
    		<td> <a href="#" >AB380</a></td>
    		<td> 11:00 </td>
    		<td> 16:00</td>
    		<td> <a href="javascrip:;" class="s1"> check price</a> <div></div> </td>
    		
    		<td> $800 </td>
    		<td> <button> buy ticket </button> </td>
    	</tr>
    
    </table>
  </body>
</html>
