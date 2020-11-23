<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Home</title>
<style>
.container{
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

</style>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="topNavigation">
  <a class="home" href="#home">Queries</a>
  <a href="/ViewComplaints">View Complaints</a>
  <a href="/create_feedback_manager1">Create FeedBack</a>
  <a href="/managerGenerateReport1">Generate Report</a>
  <div class="leftNavigation">
<a href="/logout">Log Out</a>
</div>
</div>
<font color="green" size="6px">${replyPosted}</font>
<center><h2>Queries</h2></center>
<div class="container">
<table class=" table table-striped">
	<tr>
		<th>Complaint Id</th>
		<th>Package Id</th>
		<th>Email Id</th>
		<th>Complaint</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${list}" var="details1">
		<tr>
			<td>${details1.enquiryId}</td>
			<td>${details1.packageId}</td>
			<td>${details1.email}</td>
			<td>${details1.enquiry}</td>
			<td><a button type="submit" class="btn btn-success" href="/managerEnquiryReply?id=${details1.enquiryId}">Reply</a></td>
		</tr>
	</c:forEach>
</table>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>