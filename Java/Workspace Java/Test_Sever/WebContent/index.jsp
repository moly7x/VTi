<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is test sever</title>
</head>
<body>
	<form action="index.jsp" method="GET">
		Add new items: <input type="text" name="items"> <input
			type="submit" value="Submit">
	</form>
	<br>
	<%
		List<String> temp = (List<String>) session.getAttribute("item");
	if (temp == null) {
		temp = new ArrayList<String>();
		session.setAttribute("item", temp);
	}
	if (request.getParameter("items") != null  && request.getParameter("items") != "") {
		if (temp.size() == 0 || !temp.get(temp.size() - 1).equals(request.getParameter("items"))) {
			((List<String>) session.getAttribute("item")).add(request.getParameter("items"));
			temp = (List<String>) session.getAttribute("item");
		}
	}
	if (temp.size() > 0) {
		out.println("Last element: " + temp.get(temp.size() - 1) + "<br>");
		for (int i = 0; i < temp.size(); ++i) {
			out.print(i + 1 + ". " + temp.get(i) + "<br>");
		}
	}
	%>
</body>
</html>