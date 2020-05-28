<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Student</title>
<!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- /CSS -->
</head>
<body>
	<!-- header -->
	<jsp:include page="html/header.html" />

	<!-- Input Student -->
	<c:if test="${listStudents != null}">
		<form action="update" class="container" method="post">
	</c:if>
	<c:if test="${listStudents == null}">
		<form action="insert" class="container" method="post">
	</c:if>
	<div class="row justify-content-md-center">
		<h1>
			<c:if test="${listStudents != null}">
                   Edit Student's Information
            </c:if>
			<c:if test="${listStudents == null}">
                  Add Student's Information
            </c:if>
		</h1>
		<c:if test="${listStudents != null}">
			<input type="hidden" name="id"
				value="<c:out value='${listStudents.getID()}' />" />
		</c:if>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-4">
			<div class="form-group">
				<label>Full Name</label> <input type="text" class="form-control"
					name="name" placeholder="Full name"
					value="${listStudents.getName()}">
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-4">
			<div class="form-group">
				<label>Age</label> <input type="number" class="form-control" min="1"
					max="80" name="age" placeholder="Age"
					value="${listStudents.getAge()}">
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-4">
			<div class="form-group">
				<label>Gender</label> <select class="form-control" name="gender">
					<option>Male</option>
					<option>Female</option>
					<option>Unknow</option>
				</select>
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-4">
			<div class="form-group">
				<label>School</label> <input type="text" class="form-control"
					name="school" placeholder="School"
					value="${listStudents.getSchool()}">
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-4">
			<div class="form-group">
				<label>Phone Number</label> <input type="text" class="form-control"
					name="phoneNumber" placeholder="Phone Number"
					value="${listStudents.getPhoneNumber()}">
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-4">
			<div class="form-group">
				<label>Address</label> <input type="text" class="form-control"
					name="address" placeholder="Address"
					value="${listStudents.getAddress()}">
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<button class="btn btn-primary my-2 my-sm-0 justify-content-md-center"
			type="submit">Submit</button>
	</div>
	</form>

	<!-- Script -->
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
	<!-- End My Script -->

	<!-- My Script-->
	<script>
		$(document).ready(function() {
			$(".navbar-nav li").removeClass("active"); //this will remove the active class from  

			//active menu items has that id 
			$('#create').addClass('active');
		});
	</script>
	<!-- End My Script -->
	<!-- /Script -->
</body>
</html>