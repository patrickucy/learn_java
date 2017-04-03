<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

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
	<div id="navigation"></div>
</div>