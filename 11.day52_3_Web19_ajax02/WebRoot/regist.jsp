<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<style>
			.tips{
				color:red;
			}
		</style>

		<script type="text/javascript" src="js/my.js"></script>
		<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>	
		<script type="text/javascript">
			// sync version
			function check_username() {
				// check if is null username
				$('username_msg').innerHTML = '';
				if($F('username').strip().length == 0){
					// username is null
					$('username_msg').innerHTML='You need an username';
					return false;
				}
				
				/**
				check if username is taken, 
				*/
				var flag = false;
				
				var xhr = getXhr();
				var uri = 'check_username.do?username='+$F('username');
				xhr.open('get',encodeURI(uri) , false); // encode chinese by utf-8, first you need to change to utf-8 in server.xml
				xhr.onreadystatechange = function(){
					// only readyState equals 4, can a server return all data
					if(xhr.readyState == 4){
						// query the data from server if is correct
						if(xhr.status==200){
							var txt = xhr.responseText;
							if(txt == 'ok'){
								$('username_msg').innerHTML = 'username is approved';
								flag = true;
							}else{
								${'username_msg'}.innerHTML = 'username is taken';									
								flag = false;
							}
						}else {
							${'username_msg'}.innerHTML = 'We got a problem verifying this username';
						}
					}
				};
				${'username_msg'}.innerHTML = 'Verifying...';		
				xhr.send(null); 
				// you need response from server side here
				// you are sending a synchronized request, browser will wait here for our server side
				return flag;				
			}
			
			// sync version 
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
			
			
			function beforeSubmit() {
				var flag = check_username();
				return flag;
			}
		</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="regist.do" method="post" onsubmit="return beforeSubmit();">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username"  id="username" onblur="check_username();"/>

									 <span class="tips" id="username_msg"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="gender" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="gender" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
	
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" id="number" onblur="check_number();" />
									<img src="checkcode" onclick="this.src='checkcode?'+Math.random();" />

									 <span class="tips" id="checkcode_msg"></span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="提交" />
						</p>
					</form>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
