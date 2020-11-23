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
	width: 40%;
	height: 50%;
	border: 3px solid black;
	padding: 20px;
}

button {
	margin-top: 8%;
	width: 300px;
	font-size: 20px;
	margin-left: 20%;
}
h1{
	margin-left: 40%;
	margin-top: 7%;
	size: 100px;
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
<h1>Select your Login</h1>
	<div class="container">
		<button type="button" onclick="window.location.href='/user_login1'"
			class="btn btn-primary">User Login</button>
		<button type="button" onclick="window.location.href='/manager_login1'"
			class="btn btn-warning">Manager Login</button>
		<button type="button" onclick="window.location.href='/admin_login'"
			class="btn btn-danger">Admin Login</button>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>