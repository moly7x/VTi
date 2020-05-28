<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	First name is
	<%=request.getParameter("fname")%>
	<br> Last name is ${param.lname}
	<br> Your country is ${param.country}
	
	<br> Your name is ${param.lang}
</body>
</html>