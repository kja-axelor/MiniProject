<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>


	<form action="../book/updateBook">
	<h2>Data Updation </h2>
	<label for = "id">ID:</label>
	<input type = "text" name = "id" value ="<%out.print(request.getParameter("bid")); %>"><br>
	<label for = "name">Name:</label>
	<input type = "text" name = "bname"><br>
	<input type = "submit" value = "update">
	</form>
	
</body>
</html>