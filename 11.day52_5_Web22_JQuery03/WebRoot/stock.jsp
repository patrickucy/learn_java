<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stock.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		#d1{
			width:500px;
			height:300px;
			border:1px solid read;
			background-color: black;
			margin-left: 350px;
			margin-top: 40;
			
		}
		
		#d2{
			color:white;
			background-color: red;
			height:40px;
			
		}
		table{
			color:white;
		}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
		$(function() {
			setInterval(f1, 2000);
			
		});
		
		
		function f1() {
			$.post('quoto.do',function(data){
				// data here from server side, if this is a json string, it will convert it to javascript object automatically
				$('#tb1').empty();
				for(var i=0;i<data.length;i++){
					var s = data[i];
					$('#tb1').append('<tr>  <td>'+s.code+'</td> <td>'+s.name+'</td> <td>'+s.price+'</td>  </tr>');
				}	
			},'json');
		}
	
	</script>
	
  </head>
  
  <body style="font-size: 30px; font-style: italic">
  
  	<div id="d1">
  		<div id="d2">Stock real-time info panel</div>
	    <div>
	    	<table width="100%" cellpadding="0" cellspacing="0">
	    		<thead>
	    			<tr>
	    				<td>Code</td>
	    				<td>Name</td>
	    				<td>Price</td>
	    			</tr>
	    		
	    		</thead>
	    		<tbody id="tb1">
	    		
	    		</tbody>
	    	
	    	</table>
	    
	    </div>
  	</div>
    
  </body>
</html>
