<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<style>
.body{
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

input[type=text] {
  width: 130px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  background-color: white;
  background-position: 10px 10px; 
  background-repeat: no-repeat;
  margin-top: 2px;
  margin-left: 25%;
  padding-top: 2px;
  padding-right: 25%;
  padding-bottom: 5px;
  padding-left: 10px;
  -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out;
}
input[type=text]:focus {
  width: 50%;
}

#search{
margin-left: 25%;
}
</style>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="topNavigation">
  <a class="home" href="#home">Home</a>
  <a href="/bookedUser_verification1">Raise Complaints</a>
  <a href="/ViewReplies">View Replies</a>
  <a href="/give_feedback">User FeedBack</a>
  <a href="/userEnquiry1">Post Enquiry</a>
  <a href="/userViewQuery">View Query</a>
  <div class="leftNavigation">
<a href="/logout">Log Out</a>
</div>
</div>
<font color="green" size="6px">${transactionSuccess}</font>
<div class="body">
<div id="search">
<h2>Search your Favourite Package</h2>
</div>
<form>
  <input type="text" id="searchInput" name="search" placeholder="Enter Package Name, Location...." onkeyup="searchFunc()">
</form>
<br><br>
<center><h2>Select Your Favourite Package</h2></center>
<div class="container">

<table class=" table table-striped" id="myTable">
	<tr>
		<th>Package Id</th>
		<th>Package Name</th>
		<th>Location</th>
		<th>Duration</th>
		<th>Package Cost/Person</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${packageDetails}" var="details">
		<tr>
			<td>${details.packageId}</td>
			<td>${details.packageName}</td>
			<td>${details.location}</td>
			<td>${details.duration}</td>
			<td>${details.packageCost}</td>
			<td><a button type="submit" class="btn btn-success" href="/bookingDetails?id=${details.packageId}">Select</a></td>
		</tr>
	</c:forEach>
</table>
</div>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script>
 function searchFunc(){
	 let filter= document.getElementById("searchInput").value.toUpperCase();
	 let myTable= document.getElementById("myTable");
	 let tr=myTable.getElementsByTagName("tr");
	 
	 for(var i=0; i<tr.length; i++){
		 let td1=tr[i].getElementsByTagName("td")[1];
		 let td2=tr[i].getElementsByTagName("td")[2];
		 //let td3=tr[i].getElementsByTagName("td")[3];

		 if(td1 || td2){
		 	let textValue=td1.textContent || td1.innerHTML;
			let textValue1=td2.textContent || td2.innerHTML
		 	if(textValue.toUpperCase().indexOf(filter) > -1 || textValue1.toUpperCase().indexOf(filter) > -1){
		 		tr[i].style.display="";
		 	} else{
		 		tr[i].style.display="none";
		 	}
		 }
	 }
 }
 </script>
</body>
</html>