<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
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
<font color="red" size="6px">${transactionFailure}</font>
<br>
<br>
<center>
<div class="container">
 <h2>Enter the Details For Transaction:</h2>
	<f:form method="POST" modelAttribute="TransactionDetails">
			<table style="border-collapse: separate; border-spacing: 0 15px;">
			<tr>
					<td><b>Card Number:</b> <f:input style="width: 200px;"
							type="text" name="cardNumber" path="cardNumber" class="form-control" placeholder="0000-0000-0000-0000"
							required="required" /></td>
					<td><f:errors path="cardNumber" cssClass="text-warning" /></td></tr>
			<tr>
				<td><b>Card Type: </b><f:select style="width: 200px;"
							name="cardType" path="cardType" items="${cardList}" class="form-control"
							required="required" /></td>
					<td><f:errors path="cardType" cssClass="text-warning" /></td>
					<td><b>Name on Card: </b> <f:input style="width: 150px;"
							type="text" name="nameOnCard" path="nameOnCard" class="form-control"
							required="required" /></td>
					<td><f:errors path="nameOnCard" cssClass="text-warning" /></td>
					</tr>
					<tr>
					<td><b>Card Expiration:</b> <f:input style="width: 75px;"
							type="text" name="expirationDetails" path="expirationDetails" class="form-control" placeholder="mm/yy"
							required="required"  /></td>
					<td><f:errors path="expirationDetails" cssClass="text-warning" /></td>
					<td><b>CVV:</b> <f:input style="width: 60px;"
							type="text" name="CVV" path="CVV" class="form-control" required="required" /></td>
					<td><f:errors path="CVV" cssClass="text-warning" /></td>
				</tr>
					<tr>
					<td><button type="submit" class="btn btn-success">Make Payment</button></td>
					<td><button type="reset" class="btn btn-danger" value="Clear">Reset</button></td>
					</tr>
			</table>
		</f:form> 
		</div>
</center>
</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>