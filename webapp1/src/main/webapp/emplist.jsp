<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>


<style>
.outerdiv {
	width: 600px;
	text-align: center;
}

#emptbl {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 60%;
	margin: auto;
}

#emptbl td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#emptbl tr:nth-child(even) {
	background-color: #f2f2f2;
}

#emptbl tr:hover {
	background-color: #ddd;
}

#emptbl th {
	padding-top: 5px;
	padding-bottom: 5px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}

a:link, a:visited {
	background-color: lightblue; color : white;
	padding: 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	margin-top: 15px;
	width: 50%;
	color: white;
}

a:hover, a:active {
	background-color: blue;
}
</style>
</head>
<body>
	<div class='outerdiv'>
		<h3 style='color: red;'>Employee List</h3>
		<table id='emptbl'>
			<tr>
				<th>EmpId</th>
				<th>Name</th>
				<th>Salary</th>
			</tr>
			<c:forEach var="e" items="${emps}">
				<tr>
					<td>${e.empId}</td>
					<td>${e.name}</td>
					<td>${e.salary}</td>
				</tr>
			</c:forEach>
		</table>
		<a href='index.html'>Back</a>
	</div>
</body>
</html>