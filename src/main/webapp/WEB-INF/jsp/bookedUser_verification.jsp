<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Booking Verification Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body{
	background-color: #EAE7DC;
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

.container {
	margin-top: 2%;
	width: 35%;
	height: 25%;
	border: 3px solid black;
	padding: 20px;
}

button {
	width: 70px;
	font-size: 20px;
}
h1{
	margin-left: 40%;
	margin-top: 7%;
}
a{
font-size: 20px;
font-weight: bold;
}

</style>

</head>
<body>
<div class="topNavigation">
  <a class="home" href="/showHome">back</a>
</div>
<font color="green" size="6px">${success}</font>
	<h1>Booking Verification</h1>
	<div class="container">
		<font color="red">${error}</font>
		<f:form method="POST" modelAttribute="bookingDetails">
			<table style="border-collapse: separate; border-spacing: 0 15px;">
				<tr>
					<td><b>Booking Id:</b> <f:input style="width: 350px;" type="number"
							name="bookingId" path="bookingId" class="form-control" /></td>
					<td><f:errors path="bookingId" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><button  type="submit" class="btn btn-success">Submit</button></td>
					<td><button type="reset" class="btn btn-danger" value="Clear">Reset</button></td>
				</tr>
			</table>
			</f:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>