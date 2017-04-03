<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entity.Employee"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>更新员工信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								登录时间:<%
										Date date = new Date();
										SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  hh:mm");
										out.println(sdf.format(date));
									%>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">员工管理系统</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						更新员工信息:
						<%
							Employee e = (Employee)request.getAttribute("e");
						 %>
					</h1>
					<form action="update.do?id=<%=e.getId()%>" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									ID:
								</td>
								<td valign="middle" align="left">
									<%=e.getId()%>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="<%=e.getName()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="<%=e.getSalary()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="<%=e.getAge()%>"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="提交" />
						</p>
					</form>
				</div>
			</div>
				<div id="footer">
				<div id="footer_bg">
					版权声明:鱼畅游
					changyou@gmail.com
				</div>
			</div>
				
		</div>
	</body>
</html>

