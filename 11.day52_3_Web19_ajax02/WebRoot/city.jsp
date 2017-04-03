<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>City</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="js/my.js"></script>
	<script type="text/javascript">
		function getCity(v1) {
			var xhr = getXhr();
			xhr.open('get', 'getCity.do?name='+v1, true);
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4){
					var txt = xhr.responseText;
					// split txt from server side 
					// wh,wuhan;hs,huangshi;jz,jizhou
					var arr = txt.split(';');
					
					// clear all old data from in this menu
					$('s2').innerHTML='';
					for(var i=0;i<arr.length;i++){
						var str = arr[i];
						var arr1 = str.split(',');
						// create an option object(text,value)
						var op = new Option(arr1[1], arr1[0]);						
						$('s2').options[i] = op;
					}
				}
			};
			xhr.send(null);
		}
	
	</script>
  </head>
  
  <body style="font-size: 30px; font-style: italic;">
  
  	<select id="s1" style="width: 150px;" onchange="getCity(this.value);">
  		<option value="bj">Beijing</option>
  		<option value="hb">Hubei</option>
  		<option value="sd">Shandong</option>
  	
  	</select>
	  
	  
	<select id="s2" style="width: 150px;">
  		
  	
  	</select>


  </body>
</html>
