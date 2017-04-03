<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.tips{
			color:red;
		}
	</style>

	<script type="text/javascript" src="js/my.js"></script>
	<script type="text/javascript">
		function check_username() {
			// get ajax object
			var xhr = getXhr();
			// send request using this object
			var uri = 'check_username.do?username='+$F('username');
			xhr.open('get',encodeURI(uri) , true); // encode chinese by utf-8, first you need to change to utf-8 in server.xml
			xhr.onreadystatechange = function(){
				// only readyState equals 4, can a server return all data
				if(xhr.readyState == 4){
					// query the data from server if is correct
					if(xhr.status==200){
						var txt = xhr.responseText;
						${'username_msg'}.innerHTML = txt;
					}else {
						${'username_msg'}.innerHTML = 'We got a problem verifying this username';
						
					}
				}
			};
			${'username_msg'}.innerHTML = 'Verifying...';		
			xhr.send(null);
		}
		
		function check_number(){
			var xhr = getXhr();
			xhr.open('get', 'check_number.do?number='+$F('number'), true);
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					var txt = xhr.responseText;
					${'checkcode_msg'}.innerHTML = txt;
				}
				
			};
			xhr.send(null);	
		}
		
		function check_username_post() {
			var xhr = getXhr();
			xhr.open('post','check_username.do',true);
			xhr.setRequestHeader('content-type','application/x-www-form-unlencoded');
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						var txt = xhr.responseText;
						${'username_msg2'}.innerHTML = txt;
					}else {
						${'username_msg2'}.innerHTML = 'We got a problem verifying this username';	
					}
				}	
			};
			${'username_msg2'}.innerHTML = 'Verifying...';		
			xhr.send('username='+$F('username'));
			
		}
		
	</script>
  </head>
  
  <body style="font-size: 30px; font-style: italic">
  	<fieldset>
  		<legend>regist</legend>
  		Username(get):  <input name="username" id="username" onblur="check_username();">  <span class="tips" id="username_msg"></span>   <br/>
  		Username(post):  <input name="username" id="username" onblur="check_username_post();">  <span class="tips" id="username_msg2"></span>   <br/>
  		
  		Realname:  <input name="realname"> <br/>
  		Checkcode: <input name="number" id="number" onblur="check_number();"/> 
  		<img src="checkcode" onclick="this.src='checkcode?'+Math.random();"/>  
  		<span class="tips" id="checkcode_msg"></span><br/>
  		
  		<input type="button" value="Submit">
  	</fieldset>
	    

  </body>
</html>
