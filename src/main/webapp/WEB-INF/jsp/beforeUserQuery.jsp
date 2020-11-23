<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form method="POST" >
<table style="border-collapse: separate; border-spacing: 0 15px;">
				<tr>
					<td><b>Enter your Email:</b> <f:input style="width: 350px;"
							type="text" name="email" path="email"
							class="form-control" required="required" placeholder="Enter your email" /></td>
					<td><f:errors path="email" cssClass="text-warning" /></td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-success" href="/userViewQuery?">Submit</button></td>
				</tr>
				</table>
				</f:form>
</body>
</html>