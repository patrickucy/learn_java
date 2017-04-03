<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
		<style>
			.tips{
				color:red;
			}
		</style>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
			
					<%@include file="header.jsp" %>
					
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						登录
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
									<%
										String errorMsg = (String)request.getAttribute("login_error");
										String numberMsg = (String)request.getAttribute("number_error");
									%>
									<span class="tips"><%=errorMsg==null ? "":errorMsg %></span>
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
									验证码:
								</td>
								<td valign="middle" align="left">
									
									<input class="inputgri" name="number"/> 
									<img src="checkcode" onclick="this.src='checkcode?'+Math.random()"/>
									<span class="tips"><%=numberMsg==null ? "":numberMsg %></span>
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
