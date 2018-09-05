<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<center>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Customer Registration</title>
</head>
<body>
	<form action="insertCust" method="post">
		<pre>

ID    : <input type="text" name="custId" />
NAME  : <input type="text" name="custName" />
EMAIL   : <input type="text" name="custEmail" />
TYPE    : <select name="custType">
              <option value="seller">Seller</option>
              <option value="consumer">Consumer</option>
		      </select>
ADDRESS : <textarea name="custAddr"></textarea>
PASSWORD: <input type="password" name="password" />
TOKEN: <input type="text" name="accToken" />

<input type="submit" value="Insert" />		
</pre>
	</form>
${msg}<br><a href="viewAllCusts">VIEWALL</a>
</center>
</body>
</html>



