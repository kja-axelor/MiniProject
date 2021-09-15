<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<form action="../book/updateBook">
			<label for = "id" style="margin-left: 3px;color: gray;">ID:</label>
			<input type = "text" name = "id"  class="form-control" value ="<%out.print(request.getParameter("bid")); %>" readonly="readonly"\/><br>
			<label for = "name" style="margin-left: 3px;color: gray;">Name:</label>
			<input type = "text" name = "bname"  class="form-control"/><br>
			<input type = "submit" value = "update" class="btn btn-danger"/>
			<a href="../student/showStudent"><input type = "button" value = "Back" class="btn btn-warning"/></a>
		</form>
	</div>
</body>
</html>