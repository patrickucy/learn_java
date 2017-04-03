<i><%@page import="entity.Employee"%>
<%@page import="dao.EmployeeDAO"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
  	<style type="text/css">
  		.row1{
  			background-color:#fff8dc;
  		}
  		.row2{
  			background-color:yellow;
  		}
  	</style>
   </head>
  
  <body style="font-size:30px;font-style:italic">
  <table width="60%" border="1" cellpadding="0" cellspacing="0">
  	<tr>
  		<td>ID</td><td>Name</td><td>Salary</td><td>Age</td>
  	</tr>
   <%
   	EmployeeDAO dao = new EmployeeDAO();
   	List<Employee> employees = dao.findAll();
   	for(int i=0; i<employees.size(); i++){
   		Employee e = employees.get(i);
   		%>
   		<tr class="row<%=(i % 2 +1) %>">
  			<td><%=e.getId()%></td>
  			<td><%=e.getName() %></td>
  			<td><%=e.getSalary() %></td>
  			<td><%=e.getAge() %></td>
  		</tr>
   		<% 
   	}
 
   
    %>
    
	</table>
    
  </body>
</html>
</i>