<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
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

.split_left{
	height: 100%;
  width: 50%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}

.left {
  float:left;
  width:50%;
  padding-left:10%;
  padding-top:10%;
}

/* Control the right side */
.right {
  width:1%;
  padding-top:5%;
  padding-left:5%;
}

.container {
	height: 50%;
	border: 3px solid black;
	padding: 20px;
}
</style>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="topNavigation">
  <a class="home" href="/showHome">Back</a>
</div>
<div class="split left">
<div class="centered">
<h2>Here is your Package Details:</h2>
<table style="border-collapse: separate; border-spacing: 0 15px;">
<tr>
<td>Package ID:</td><td>${packageDetails.packageId}</td>
</tr>
<tr>
<td>Package Name:</td><td>${packageDetails.packageName}</td>
</tr>
<tr>
<td>Location:</td><td>${packageDetails.location}</td>
</tr>
<tr>
<td>Cost/Person:</td><td>${packageDetails.packageCost}</td>
</tr>
</table>
</div>
</div>
<div class="split right">
<div class="centered">
<div class="container">
	<h3>Enter the Details:</h3>
		<f:form method="POST" modelAttribute="bookingDetails">
			<table style="border-collapse: separate; border-spacing: 0 15px;">
			<tr>
					<td><b>Enter your email: </b><f:input style="width: 150px;"
							type="text" name="userId" path="userId" class="form-control"
							required="required" /></td>
					<td><f:errors path="userId" cssClass="text-warning" /></td>
					<td><f:input style="width: 150px;"
							type="hidden" name="packageId" path="packageId" class="form-control" value="${packageDetails.packageId}"
							required="required" /></td>
					<td><f:errors path="packageId" cssClass="text-warning" /></td>
					</tr>
				<tr>
					<td><b>Number of Persons: </b> <f:input style="width: 150px;"
							type="text" name="numberOfPersons" path="numberOfPersons" class="form-control"
							required="required" /></td>
					<td><f:errors path="numberOfPersons" cssClass="text-warning" /></td>
					</tr>
					<tr>
					<td><b>Number of Rooms required:</b> <f:input style="width: 150px;"
							type="text" name="numberOfRoomsRequired" path="numberOfRoomsRequired" class="form-control"
							required="required" /></td>
					<td><f:errors path="numberOfRoomsRequired" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><b>Mode Of Transport:</b> <f:select style="width: 150px;"
						 name="modeOfTransport" path="modeOfTransport" items="${transportList}" class="form-control"
							required="required" /></td>
					<td><f:errors path="modeOfTransport" cssClass="text-warning" /></td>
					</tr>
					<tr>
					<td><b>Date Of Travel:</b> <f:input style="width: 150px;"
							type="date" name="dateOfTravel" path="dateOfTravel" min="2002-10-31" class="form-control" required="required" /></td>
					<td><f:errors path="dateOfTravel" cssClass="text-warning" /></td>
				</tr>
					<tr>
					<td><button type="submit" class="btn btn-success">Save</button></td>
					<td><button type="reset" class="btn btn-danger" value="Clear">Reset</button></td>
					</tr>
			</table>
		</f:form>
	</div>
	</div>
	</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>