<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin's Portal</title>
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
	width: 50%;
	height: 50%;
	border: 3px solid black;
	background-color: #EAE7DC;
	padding-left: 25%;
	padding-right: 0px;

}

input {
	margin-left: 15%;
}

b {
	margin-left: 10%;
}

button {
	width: 90px;
	font-size: 20px;
	margin-left: 9%;
}
</style>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="topNavigation">
  <a class="home" href="#home">Hi Admin</a>
</div>
<div class="container">
		<f:form method="POST" modelAttribute="packageDetails">
			<table style="border-collapse: separate; border-spacing: 0 15px;">
				<tr>
					<td><b>Package Name:</b> <f:input style="width: 350px;"
							type="text" name="packageName" path="packageName" class="form-control"
							required="required" /></td>
					<td><f:errors path="packageName" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Location:</b> <f:input style="width: 350px;"
							type="text" name="location" path="location" class="form-control"
							required="required" /></td>
					<td><f:errors path="location" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Duration:</b> <f:input style="width: 350px;"
							type="text" name="duration" path="duration" class="form-control"
							required="required" /></td>
					<td><f:errors path="duration" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Cost per Person:</b> <f:input style="width: 350px;" type="text" name="packageCost"
							path="packageCost" class="form-control" required="required" /></td>
					<td><f:errors path="packageCost" cssClass="text-warning" /></td>
				</tr>
					<tr>
					<td><button type="submit" class="btn btn-success">Save</button></td>
					<td><button type="reset" class="btn btn-danger" value="Clear">Reset</button></td>
			</table>
		</f:form>
	</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>