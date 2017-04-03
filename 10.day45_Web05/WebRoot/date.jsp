<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
	<head>
	</head>
	<body style="font-size:30px;">
		<%
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			out.println(sdf.format(date));
		 %>
	</body>
</html>