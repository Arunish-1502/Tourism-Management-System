<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
.bookingDetailsForTransaction{
	font-size: 20px;
}
</style>
</head>
<body>
<div class="topNavigation">
  <a class="home" href="/showHome">Back</a>
</div>
<br><br>
<h2>
<center>
<br><br><br><br>
<div class="bookingDetailsForTransaction">
${success}
<table>
<tr>
<td><b>Booking Id:</b></td><td></td> <td>${bookingDetails.bookingId}</td></tr>
<tr><td><b>Package Id:</b></td><td></td> <td>${bookingDetails.packageId}</td></tr>
<tr><td><b>Email Id:</b></td><td></td><td>${bookingDetails.userId}</td>
</tr>
</table> 
</div>
<br>
<h2>Note your booking Id for Future Reference
<br>
TotalCost of Package:Rs. ${totalCost}
<br><br>
<div class="container">
<a href="/TransactionDetails">Click here</a> to pay.
</div>
</h2>
</center>
</h2>
</body>
</html>