<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Employee"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="java.util.*"%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
 <html>
	<head>
		<title>员工列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
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
						员工列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								姓名
							</td>
							<td>
								薪水
							</td>
							<td>
								年龄
							</td>
							<td>
								操作
							</td>
							<%
								List<Employee> employees = (List<Employee>) request.getAttribute("employees");
								for(int i=0; i<employees.size(); i++){
									Employee e = employees.get(i);
									%>
									
										<tr class="row<%=(i%2 +1) %>">
											<td>
												<%=e.getId() %>
											</td>
											<td>
												<%=e.getName() %>
											</td>
											<td>
												<%=e.getSalary() %>
											</td>
											<td>
												<%=e.getAge() %>
											</td>
											<td>
												<a href="del.do?id=<%=e.getId() %>" onclick="return confirm('确定删除: <%=e.getName()%> ?')">删除</a>&nbsp;<a href="load.do?id=<%=e.getId()%>">更新</a>
											</td>
										</tr>
									<%
								}
							
							 %>
						</tr>
					
						
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='addEmp.jsp'"/>
					</p>
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
