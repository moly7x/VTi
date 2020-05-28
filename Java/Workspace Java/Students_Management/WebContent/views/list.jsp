<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Import myself -->
<%@ page import="java.util.List"%>
<%@ page import="studentManagement.entity.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Student</title>
<!-- CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<!-- /CSS -->
</head>

<body>
	<!-- header --> 
	<jsp:include page="html/header.html"/>
	
	<div class="container-fluid mt-5" style="width: 95%">
		<form class="mb-5" action="new">
			<button class="btn btn-primary" type="submit">Add student</button>
		</form>
		<table id="students" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Gender</th>
					<th scope="col">School</th>
					<th scope="col">Phone Number</th>
					<th scope="col">Address</th>
					<th scope="col">Modify</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.listStudents}" var="index">
					<tr>
						<td><c:out value="${index.getID()}" /></td>
						<td><c:out value="${index.getName()}" /></td>
						<td><c:out value="${index.getAge()}" /></td>
						<td><c:out value="${index.getGender()}" /></td>
						<td><c:out value="${index.getSchool()}" /></td>
						<td><c:out value="${index.getPhoneNumber()}" /></td>
						<td><c:out value="${index.getAddress()}" /></td>
						<td><a href="edit?id=<c:out value="${index.getID()}" />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete?id=<c:out value="${index.getID()}" />">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Script -->
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#students').DataTable();
		});
	</script>
	<!-- /Script -->
</body>

</html>