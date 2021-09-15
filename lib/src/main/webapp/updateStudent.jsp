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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<style type="text/css">
.center{
	text-align: center;
	margin-top:5px;
	margin-bottom: 10px;
}
#insider{
	margin-top: 30px;
}

</style>
</head>
<body>
	<div class="center">
	<h2 style="color: orange; background-color:black; margin-top: 10px;margin-bottom: 10px;">Data Updation </h2>	
	</div>
	
	<div id="insider" style="margin-left: 10px">
	<form action="../student/updateStudent" method = "get">
		<label for = "id" style="margin-left: 3px;color: gray;">ID:</label>
		<input type = "text" name = "id"  class="form-control" value ="<%out.print(request.getAttribute("id")); %>" readonly="readonly" /><br>
		<label for = "name" style="margin-left: 3px;color: gray;">Name:</label>
		<input type = "text" name = "name"  class="form-control"><br>
		<input type = "submit" value = "update" class="btn btn-danger">
		<a href="../student/showStudent"><input type = "button" value = "Back" class="btn btn-warning"/></a>
	</form>
	</div>
</body>
</html>
