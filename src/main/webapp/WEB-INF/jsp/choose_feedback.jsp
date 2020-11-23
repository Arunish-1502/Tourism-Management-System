<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #EAE7DC;
}

.container {
	margin-top: 2%;
	width: 30%;
	height: 30%;
	border: 3px solid black;
	padding: 20px;
}

button {
	width: 90px;
	font-size: 20px;
}

h1 {
	margin-left: 40%;
	margin-top: 7%;
}

a {
	font-size: 20px;
	font-weight: bold;
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

<body onload="myFunction()">
<div class="topNavigation">
  <a class="home" href="/showHome">Home</a>
  </div>
	<font color="green" size="6px">${success}</font>
	<h1>Feedback Form</h1>
	<div class="container">
		<font color="red">${error}</font>
		<form method="POST" >
					<center><b>Choose Your Feedback Form:</b>      <select name="options">
						<c:forEach items="${options}" var="options">
							<option value="${options}">${options}</option>
						</c:forEach>
					</select>
					<br><br><br><br><br><br>					
				<button type="submit" class="btn btn-success">Login</button></center>
		</form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>