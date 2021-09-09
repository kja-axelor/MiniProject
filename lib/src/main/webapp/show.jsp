<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Database.Student"%>
<%@page import="java.util.List"%>
<%@page import = "javax.servlet.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Records</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		
		<% 
		
		for(Student s: (List<Student>)request.getAttribute("list") ) {%>
			<tr>
			<td><% out.print(s.getId()); %>></td>
			<td><% out.print(s.getName()); %>></td>
			</tr>
			<% }%>
	</table>
</body>
</html>
