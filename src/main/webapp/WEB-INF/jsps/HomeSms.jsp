<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="green">
Status : ${smsResponse.status} </br>
</font>
</br>
<font color="red">
Remainding Balance : ${smsResponse.balance}
</font>
<font color="blue">
<c:forEach var="warning" items="${smsResponse.warnings}">
      	${warning.message}
    </c:forEach>
</font>
<form action="sendSMS" method="post">
<table>
<tr>
<td>Mobile</td>
<td>:</td>
<td><input type="text" name="mobile"/> </td>
</tr>
<tr>
<td>Text</td>
<td>:</td>
<td><textarea name="textMessage" rows="5" cols="30"></textarea></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Send SMS"/></td>
<td></td>
</tr>
</table>
</form>
</body>
</html>