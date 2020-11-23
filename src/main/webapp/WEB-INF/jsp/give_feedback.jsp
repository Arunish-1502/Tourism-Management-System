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
.topNavigation .leftNavigation a {
  float:right;
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
  <a class="home" href="/showHome">Home</a>
  </div>
	<h1>Give FeedBack</h1>
	<div class="container">
		<font color="red">${error}</font>
		<font color="red">${dberror}</font>
		<f:form method="POST" modelAttribute="feedback" action="/feedback">
			<table style="border-collapse: separate; border-spacing: 0 15px;">
			<tr>
					<td><b>Name:</b> <f:input style="width: 350px;"
							type="text" name="name" path="name" value="${feedback1.name}"
							class="form-control" required="required" /></td>
				</tr>
				<tr>
					<td><b>${feedback1.question1}:</b><f:input style="width: 350px;"
							type="text" name="feedback1" path="question1" 
							class="form-control" required="required" /></td>
				</tr>
				<tr>
					<td><b>${feedback1.question2}:</b> <f:input style="width: 350px;"
							type="text" name="feedback2" path="question2" class="form-control"
							required="required" /></td>
				</tr>
				<tr>
					<td><b>${feedback1.question3}:</b> <f:input style="width: 350px;"
							type="tel" name="feedback3" path="question3" class="form-control"
							required="required" /></td>
				<tr>
					<td><b>${feedback1.question4}:</b> <f:input style="width: 350px;"
							type="text" name="feedback4" path="question4" class="form-control"
							required="required" /></td>
				</tr>
				<tr>
					<td><b>${feedback1.question5}:</b> <f:input style="width: 350px;" type="text" name="feedback5"
							path="question5" class="form-control" required="required" /></td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-success">ADD</button></td>
					<td><button type="reset" class="btn btn-danger" value="Clear">Reset</button></td>
			</table>
		</f:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
	</script>
</body>