<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view contact</title>
 
<script type="text/javascript">
	function  deletePopup() {
		return confirm("Are you Sure, Do You want to Delete..?");
	}
</script>


</head>
<body bgcolor="black">
	
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><h2 style="color: red;text-align: center"><i>ALL CONTACT</i></h2>
	
	<table border="5" style="border-color: green; background-color: orange" align="center">
			<tr><th colspan="5" align="left"><b style="color: lime; "><a href="/">+Add New Contact</a></b></th></tr>
			<tr>
				<th style="color: navy;">Sl No.</th>
				<th style="color: navy;">Contact Name</th>
				<th style="color: navy;">Contact Email</th>
				<th style="color: navy;">Phone Number</th>
				<th style="color: navy;">Action</th>
			</tr>
			<c:forEach items="${contactList}" var="contact" varStatus="status">
				<tr>
				<td>${status.index+1}</td>
				<td>${contact.contactName}</td>
				<td>${contact.contactEmail}</td>
				<td>${contact.phNo}</td>
				<td>
					<a href="editContact?contactId=${contact.contactId}">EDIT</a> &nbsp;&nbsp;
					<a href="deletContact?contactId=${contact.contactId}" onclick="return deletePopup()">DELETE</a>
				</td>
			</tr>
			</c:forEach>
	</table>

</body>
</html>