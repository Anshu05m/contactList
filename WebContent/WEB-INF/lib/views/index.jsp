<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ContactManager</title>
</head>
<body>

<div align="center">
	<h1>Contact Manager</h1>
	<h3><a href="new">Add a new contact</a></h3>
	<table border = "1" cellpadding = "5">
	<tr>
		<th>No.</th>
		<th>Name</th>
		<th>Email</th>
		<th>Address</th>
		<th>Telephone</th>
		<th>Action</th>
		
	</tr>
	
	<c:forEach var="contact" items="${listContact}" varStatus="status">
	<tr>
		<td>${status.index + 1}</td>
		<td>${contact.name}</td>
		<td>${contact.email}</td>
		<td>${contact.address}</td>
		<td>${contact.telephone}</td>
		
		 <td>
         	  <a href="Edit?id=${contact.id}">Edit</a>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="Delete?id=${contact.id}">Delete</a>
         </td>
	
	</tr>
	</c:forEach>     
	</table>        
	

</div>


</body>

</html>