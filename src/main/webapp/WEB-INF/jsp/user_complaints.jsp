<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>User Complaints Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body{
	background-color: #EAE7DC;
}
.container {
	margin-top: 2%;
	width: 35%;
	height: 45%;
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
<div class="leftNavigation">
<a href="/showHome">Home</a>
</div>
<font color="green" size="6px">${success}</font>
	<h1>Complaint Issue</h1>
	<div class="container">
		<f:form method="POST" modelAttribute="Complaints">
			<table style="border-collapse: separate; border-spacing: 0 15px;">
				<tr>
					<td><b>Complaint:</b> <f:textarea rows="6" cols="10" style="width: 350px" type="text"
							name="complaint" path="complaint" class="form-control" /></td>
					<td><f:errors path="complaint" cssClass="text-warning" /></td>
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