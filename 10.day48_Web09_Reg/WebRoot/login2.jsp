<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>

	<head>
		<style>
			.tips{
				color: red; font-size: 30px;
			}
		
		</style>
	</head>
	
	<body style="font-size:40px;">
		<form action="login.do" method="post">
		
			<fieldset>
			<legend>登录</legend>
			用户:<input name="username"/> 
			<%
				String errorMsg = (String)request.getAttribute("login_error");
				String numberMsg = (String)request.getAttribute("number_error");
			 %>
			<span class="tips"><%=errorMsg==null ? "":errorMsg %></span>
			<br/>
			密码:<input type="password" name="pwd"/> <br/>
			验证码:<input name="number"/> <img src="checkcode" onclick="this.src='checkcode?'+Math.random()"/>
			<span class="tips"><%=numberMsg==null ? "":numberMsg %></span> <br/>
			<input type="submit" value="提交">
			
		</fieldset>
		
		</form>
	
	</body>

</html>

