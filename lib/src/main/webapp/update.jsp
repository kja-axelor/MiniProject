<%@page import="javax.ws.rs.Path"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" java.util.*" %>
   <%@page import =  "javax.servlet.*" %>
   <%@page import = "javax.servlet.http.*" %>
   <%@page import = "java.io.*" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>

	<form action="../apple/updateStudent" method = "get">
	<h2>Add ID and change name </h2>
	<label for = "id">ID:</label>
	<input type = "text" name = "id" value ="<%out.print(request.getAttribute("id")); %>"><br>
	<label for = "name">Name:</label>
	<input type = "text" name = "name"><br>
	<input type = "submit" value = "update">
	</form>
	
</body>
</html>
