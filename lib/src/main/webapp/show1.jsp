
<%@page import="Database.Books"%>
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
	<h1>Library Management System</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Updation</th>
			<th>Deletion</th>
			<th>Books</th>
			<th>Issued Book</th>

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
			<td><a href="../student/updatedStudent?id=<% out.print((s.getId()));%>"><input type="button" value="update" /></a></td>
			<td><a href="../student/deleteStudent?id=<% out.print((s.getId()));%>"><input type="button" value="Delete" /></a></td>
			<td><a href="../createBook.jsp?id=<% out.print((s.getId()));%>"><input type="button" value="AddBook" /></a></td>
			
			<td>
			<table>
			<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Update</th>
			<th>Delete</th>
			
			<th></th>
				
			
			</tr>
			<%
			for (Books b : s.getBook()) {
			%>
				
				<tr>
				<td>
				<%
				out.print(b.getBid());
				%>
				</td>
				<td>
				<%
				out.print(b.getBname());
				%>
				</td>
				<td><a href="../book/updatedBook?bid=<% out.print((b.getBid())); %>"><input type="button" value="Update" /></a></td>
				<td><a href="../book/deleteBook?bid=<% out.print((b.getBid()));%>"><input type="button" value="Delete" /></a></td>
				</tr>
			<%} %>
			</table>
			</td>

		</tr>
		<%} %>
	</table>
	

	
	
		<a href="/lib"><input type = "button" value = "Home"></a>
</body>
</html>