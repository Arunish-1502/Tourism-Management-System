<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Query</title>
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

h1{
padding-left: 38%;
}
</style>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="topNavigation">
  <a class="home" href="/showHome">Home</a>
  <div class="leftNavigation">
<a href="/logout">Log Out</a>
</div>
</div>
<br><br>
<h1>Search your Query</h1>
<form>
  <input type="text" id="searchInput" name="search" placeholder="Enter your Email or query for specific result..." onkeyup="searchFunc()">
</form>
<br>
<center><h2>Queries</h2></center>
<div class="container">
<table class=" table table-striped" id="myTable">
	<tr>
		<th>Query Id</th>
		<th>Package Id</th>
		<th>Email Id</th>
		<th>Query Raised</th>
		<th>Reply</th>
	</tr>
	<c:forEach items="${list}" var="details1">
		<tr>
			<td>${details1.enquiryId}</td>
			<td>${details1.packageId}</td>
			<td>${details1.email}</td>
			<td>${details1.enquiry}</td>
			<td>${details1.enquiryReply} </td>
		</tr>
	</c:forEach>
</table>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script>
 function searchFunc(){
	 let filter= document.getElementById("searchInput").value.toUpperCase();
	 let myTable= document.getElementById("myTable");
	 let tr=myTable.getElementsByTagName("tr");
	 
	 for(var i=0; i<tr.length; i++){
		 let td3=tr[i].getElementsByTagName("td")[1];
		 let td1=tr[i].getElementsByTagName("td")[2];
		 let td2=tr[i].getElementsByTagName("td")[3];
		 //let td3=tr[i].getElementsByTagName("td")[3];

		 if(td1 || td2){
		 	let textValue=td1.textContent || td1.innerHTML;
			let textValue1=td2.textContent || td2.innerHTML
			let textValue2=td3.textContent || td3.innerHTML
		 	if(textValue.toUpperCase().indexOf(filter) > -1 || textValue1.toUpperCase().indexOf(filter) > -1 || textValue2.toUpperCase().indexOf(filter) > -1){
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