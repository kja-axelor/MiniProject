<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="../banana/updateBook">
	<h2>Data Updation </h2>
	<label for = "id">ID:</label>
	<input type = "text" name = "id" value ="<%out.print(request.getAttribute("bid")); %>"><br>
	<label for = "name">Name:</label>
	<input type = "text" name = "name"><br>
	<input type = "submit" value = "update">
	</form>
	
</body>
</html>