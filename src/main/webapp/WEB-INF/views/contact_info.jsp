<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contact_info</title>
</head>
<body bgcolor="black">


	<form:form action="saveContact" method="POST" modelAttribute="contact">
		
		<form:hidden path="contactId" />
		
			
		<h1 style="color: red;text-align: center;">Contact info</h1>	
		
		<h2 style="color: lime;text-align: center;"> ${sucessResut}</h2>
		<h2 style="color: red;text-align: center;"> ${errorResult}</h2>
		
		<table border="5" style="border-color:yellow;background-color: red;" align="center">	
			<tr>
				<td><b>Contact Name :</b></td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td><b>Contact Email :</b></td>
				<td><form:input path="contactEmail" type="email"/></td>
			</tr>
			<tr>
				<td><b>Phnone Number :</b></td>
				<td><form:input  path="phNo" type="number" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="viewContact">
				<b style="color: lime;text-align: center;">View All Contact</b></a></td>
			</tr>
		</table>
	</form:form>
	
	
</body>
</html>