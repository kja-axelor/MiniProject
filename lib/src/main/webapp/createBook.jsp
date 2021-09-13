<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../lib/book/createBook" method = "post"> 
	<h1>Add a new Book</h1>
	
	<label>Name:</label> <input type = "text" maxlength = 20 name = "name" required><br><br>
	<input type="hidden" name="sid" value="<%=request.getParameter("id")%>"/>
	<input type = "submit" value = "create">
	<a href="/lib"><input type = "button" value = "Home"/></a>
</form>
</body>
</html>