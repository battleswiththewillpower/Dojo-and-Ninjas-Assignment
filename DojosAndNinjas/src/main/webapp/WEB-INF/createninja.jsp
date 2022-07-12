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
<h1>New Ninja</h1>
 <form:form action="/ninja/create" method="post" modelAttribute="ninja">
    <div>
		<form:label path="firstName"> First Name: </form:label><br />
		<form:input path="firstName"/>
		<form:errors path="firstName"/>
	</div>
	<div>
		<form:label path="lastName"> Last Name: </form:label><br />
		<form:input path="lastName"/>
		<form:errors path="lastName"/>
	</div>
	<div>
		<form:label path="age">Age: </form:label><br />
		<form:input type="int" path="age"/>
		<form:errors path="age"/>
	</div>
	<div>
	<form:label path="dojo">Dojo</form:label>
   		<form:select path="dojo">
   			<c:forEach var="dojo" items="${ dojos }">
   				<form:option value="${ dojo.id }"><c:out value="${ dojo.name }" /></form:option>   			
   			</c:forEach>
   		</form:select>
	</div>
	
    
    <input type="submit" value="Create"/>
</form:form> 

</body>
</html>