
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="../style.css">

<meta charset="ISO-8859-1">
<title>Records</title>
</head>
<body>


	<h1 id="header">Library Management System</h1>
	
	<h2 align="center" style="color: gray;">Filter</h2>
	<form action="<%=request.getContextPath()%>/student/search" class="filter">
		<input type="text" name="name" placeholder="student name"> 
		<input type="submit" value="Go">
	</form>

	<br>
	<br>
	
	
	<table class="center">
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
			<td><a
				href="../student/updatedStudent?id=<%out.print((s.getId()));%>"><input
					type="button" value="update" class="btn btn-warning" /></a></td>
			<td><a
				href="../student/deleteStudent?id=<%out.print((s.getId()));%>"><input
					type="button" value="Delete" class="btn btn-danger"/></a></td>
			<td><a href="../createBook.jsp?id=<%out.print((s.getId()));%>"><input
					type="button" value="AddBook" class="btn btn-success" /></a></td>

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
						<td><a
							href="../book/updatedBook?bid=<%out.print((b.getBid()));%>"><input
								type="button" value="Update" class="btn btn-warning" /></a></td>
						<td><a
							href="../book/deleteBook?bid=<%out.print((b.getBid()));%>"><input
								type="button" value="Delete" class="btn btn-danger" /></a></td>
					</tr>
					<%
					}
					%>
				</table>
			</td>

		</tr>
		<%
		}
		%>
	</table>


	
	
	<div class="center">
	<a href="/lib"><input type="button" value="Home" class="btn btn-primary"></a>
	</div>
</body>
</html>