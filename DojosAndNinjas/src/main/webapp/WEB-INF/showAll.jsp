<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Dojo Show</h1>
<h2><c:out value="${onedojo.name}"/> Location Ninjas</h2>
<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th> 
    <th>Age</th>
  </tr>
  <c:forEach  var="ninja" items="${ onedojo.ninjas }">
  <tr>
    <td><c:out value="${ninja.firstName}"></c:out> </td> 
	<td><c:out value="${ninja.lastName}"></c:out></td>
	<td><c:out value="${ninja.age}"></c:out></td>
	
	<td> 
	</td>
  </tr>
 </c:forEach>
</table>


</body>
</html>