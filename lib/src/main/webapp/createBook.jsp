<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Book</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<style type="text/css">

.center{
	text-align: center;
	margin-top:5px;
	margin-bottom: 10px;
}

#insider
{
margin-top: 30px;
}
</style>
</head>
<body>
<div class="center">
	<h1 style="color: orange; background-color:black; margin-top: 10px;margin-bottom: 10px;">Add a new book</h1>
</div>


<div id="insider"style="margin-left: 10px">
	<label style="margin-left: 3px;color: gray;">Name:</label> 
	<form action="../lib/book/createBook" method = "post"> 
	<input type = "text" maxlength = 20 name = "name" class="form-control" required><br><br>
	<input type="hidden" name="sid" value="<%=request.getParameter("id")%>"/>
	<input type = "submit" value = "Add" class="btn btn-warning">
	<a href="../lib/student/showStudent"><input type = "button" value = "Back" class="btn btn-danger"/></a>
	</form>
</div>

</body>
</html>