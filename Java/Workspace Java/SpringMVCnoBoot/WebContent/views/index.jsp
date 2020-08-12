<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addAilen" method="get">
		<label for="fnum">Enter your id: </label> 
			<input type="text" name="aid"><br> <br>
		<label for="fnum">Enter your name: </label> 
			<input type="text" name="aname"><br> <br>
		<input type="submit" value="Submit"><br> <br>
	</form>
	<hr>
	<form action="getAilen" method="get">
		<label for="fnum">Enter your id: </label> 
			<input type="text" name="aid">
		<input type="submit" value="Submit"><br> <br>
	</form>
</body>
</html>