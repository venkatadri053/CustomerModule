<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table tr th {
	color: white;
	background-color: black;
}
</style>
</head>
<body>
	<center>
		<h1>welcome to Customer Data Page!!!</h1>
		<a href="custExcelExport">EXPORT TO EXCEL</a>|<a href="custPdfExport">EXPORT
			TO PDF</a>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>TYPE</th>
				<th>ADDRESS</th>
				<th>PASSWORD</th>
				<th>TOKEN</th>
			</tr>
			<c:forEach items="${customers}" var="cust">
				<tr>
					<td><c:out value="${cust.custId}" /></td>
					<td><c:out value="${cust.custName}" /></td>
					<td><c:out value="${cust.custEmail}" /></td>
					<td><c:out value="${cust.custType}" /></td>
					<td><c:out value="${cust.custAddr}" /></td>
					<td><c:out value="${cust.password}" /></td>
					<td><c:out value="${cust.accToken}" /></td>
					<td><a href="deleteCust?custId=${cust.custId}">DELETE</a>
					<td><a href="editCust?custId=${cust.custId}">EDIT</a>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<br> <a href="regCust">HOME</a>
</center>
</body>
</html>