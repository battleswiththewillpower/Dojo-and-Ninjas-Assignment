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
<h1>New Dojo</h1>
 <form:form action="/dojos/create" method="post" modelAttribute="dojo">
    <div>
		<form:label path="name"> Name: </form:label><br />
		<form:input path="name"/>
		<form:errors path="name"/>
	</div>
    
    <input type="submit" value="Create"/>
</form:form> 



</body>
</html>