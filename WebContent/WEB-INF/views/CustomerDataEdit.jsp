<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<center>
		<h1>welcome to Customer EditPage!!</h1>
		<form action="updateCust" method="post">
			<pre>
ID  : <input type="text" name="custId" value="${custs.custId}"
					readonly="readonly" /><br>
NAME: <input type="text" name="custName" value="${custs.custName}" /><br>
EMAIL: <input type="text" name="custEmail" value="${custs.custEmail}" /><br>
TYPE:<c:choose>
					<c:when test="${'Consumer' eq custs.custType}"> <input
							type="radio" name="custType" value="Consumer" checked="checked">Consumer<input
							type="radio" name="custType" value="Seller">Seller </c:when>
					<c:otherwise>
 <input type="radio" name="custType" value="Consumer">Consumer <input
							type="radio" name="custType" value="Seller" checked="checked">Seller
 </c:otherwise>
				</c:choose> 
ADDRESS:<textarea name="custAddr">${custs.custAddr}</textarea>
				<br>
PASSWORD  : <input type="text" name="password" value="${custs.password}" /><br>
TOKEN  : <input type="text" name="accToken" value="${custs.accToken}" /><br><br>
<input type="submit" value="UPDATE" />
</pre>
		</form>
	</center>
</body>
</html>

