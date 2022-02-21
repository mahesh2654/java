<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class='container col-4 p-2 mt-5'  style='border:solid 2px;'>
		<h3>Emp Details</h3>
		<div class='display'>
			<table class='table table-striped'>
				<tr>
					<td>Employee Id</td>
					<td>${emp.empId}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${emp.name}</td>
				</tr>

				<tr>
					<td>Salary</td>
					<td>${emp.salary}</td>
				</tr>
			</table>
		</div>
		<div class='mx-auto' style='width:300px;text-align:center;'>
			<a href='index.html'  class='btn btn-primary'>Back</a>
		</div>
	</div>
</body>
</html>