<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body{
	background-color: #EAE7DC;
}
.container {
	margin-top: 2%;
	width: 50%;
	height: 80%;
	border: 3px solid black;
	padding: 20px;
}

input {
	margin-left: 15%;
}
f:error{
font-size: 50px;
}
b {
	margin-left: 15%;
}

button {
	width: 90px;
	font-size: 20px;
	margin-left: 9%;
}

h1 {
	margin-left: 40%;
}
td{
width:650px;
}
.topNavigation {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topNavigation a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topNavigation a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topNavigation a.home {
  background-color: #3333ff;
  color: white;
}
</style>
</head>
<body>
<div class="topNavigation">
  <a class="home">TOURISM MANAGEMENT SYSTEM</a>
  </div>
	<h1>User Registration</h1>
	<div class="container">
		<font color="red">${error}</font>
		<font color="red">${dberror}</font>
		<f:form method="POST" modelAttribute="user">
			<table style="border-collapse: separate; border-spacing: 0 15px;">
				<tr>
					<td><b>First Name:</b> <f:input style="width: 350px;"
							type="text" name="firstName" path="firstName"
							class="form-control" required="required" /></td>
					<td><f:errors path="firstName" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Last Name:</b> <f:input style="width: 350px;"
							type="text" name="lastName" path="lastName" class="form-control"
							required="required" /></td>
					<td><f:errors path="lastName" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Contact Number:</b> <f:input style="width: 350px;"
							type="tel" name="contactNo" path="contactNo" class="form-control"
							required="required" /></td>
					<td><f:errors path="contactNo" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Email Id:</b> <f:input style="width: 350px;"
							type="text" name="email" path="email" class="form-control"
							required="required" /></td>
					<td><f:errors path="email" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Password:</b> <f:input style="width: 350px;" type="password" name="password"
							path="password" class="form-control" required="required" /></td>
					<td><f:errors path="password" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Date Of Birth:</b> <f:input style="width: 350px;"
							type="date" name="dob" path="dob" max="2020-11-06" class="form-control" required="required" /></td>
					<td><f:errors path="dob" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-success">Register</button></td>
					<td><button type="reset" class="btn btn-danger" value="Clear">Reset</button></td>
			</table>
		</f:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
	</script>
</body>