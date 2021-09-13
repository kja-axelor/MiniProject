
<%@page import="Database.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import=" java.util.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Records</title>
</head>
<body>
	<h1>List of Students</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Updation</th>
			<th>Deletion</th>

		</tr>
		<%
		for (Student s : (List<Student>) request.getAttribute("list")) {
		%>
		<tr>
			<td>
				<%
				out.print(s.getId());
				%>
			</td>
			<td>
				<%
				out.print(s.getName());
				%>
			</td>
			<td><a href="../apple/updatedStudent?id=<% out.print((s.getId()));%>"><input type="button" value="update" /></a></td>
			<td><a href="../apple/deleteStudent?id=<% out.print((s.getId()));%>"><input type="button" value="Delete" /></a></td>

		</tr>
		<%}%>
	</table>
	<a href="/lib"><input type = "button" value = "Home"></a>
</body>
</html>