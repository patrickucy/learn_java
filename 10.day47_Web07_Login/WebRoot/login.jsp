<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>

	<head>
	</head>
	
	<body style="font-size:40px;">
		<form action="login.do" method="post">
		
			<fieldset>
			<legend>登录</legend>
			用户:<input name="username"/> 
			<%
				String errorMsg = (String)request.getAttribute("login_error");
			 %>
			<span style="color:red; font-size:30px;"><%=errorMsg==null ? "":errorMsg %></span>
			<br/>
			密码:<input type="password" name="pwd"/> <br/>
			<input type="submit" value="提交">
			
		</fieldset>
		
		</form>
	
	</body>

</html>

