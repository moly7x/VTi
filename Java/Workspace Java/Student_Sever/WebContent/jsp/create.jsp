<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Import myself -->
<%@ page import="java.util.List"%>
<%@ page import="datalayer.StudentDAO"%>
<%@ page import="main.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Create Students</title>
<!-- CSS Defaut-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- /CSS -->
</head>

<body>
	<!-- Header -->
	<c:import url="../html/header.html" />

	<!-- Add students -->
	<%
		StudentDAO.createStudent(request.getParameter("name"), request.getParameter("age"), request.getParameter("gender"),
			request.getParameter("schools"), request.getParameter("phoneNumber"), request.getParameter("address"));
	%>

	<!-- Print results -->
	<div class="container-fluid mt-5" style="width: 95%">
		<table id="students" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Gender</th>
					<th scope="col">School</th>
					<th scope="col">Phone Number</th>
					<th scope="col">Address</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="students"
					value="${StudentDAO.searchStudent(param.name)}" />
				<c:forEach items="${students}" var="index">
					<tr>
						<td><c:out value="${index.getName()}" /></td>
						<td><c:out value="${index.getAge()}" /></td>
						<td><c:out value="${index.getGender()}" /></td>
						<td><c:out value="${index.getSchool()}" /></td>
						<td><c:out value="${index.getPhoneNumber()}" /></td>
						<td><c:out value="${index.getAddress()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Script default-->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous">
		
	</script>
	<!-- End Script default-->

	<!-- My Script-->
	<script>
		$(document).ready(function() {
			$(".navbar-nav li").removeClass("active"); //this will remove the active class from  

			//active menu items has that id 
			$('#create').addClass('active');
		});
	</script>
	<!-- End My Script -->
</body>

</html>