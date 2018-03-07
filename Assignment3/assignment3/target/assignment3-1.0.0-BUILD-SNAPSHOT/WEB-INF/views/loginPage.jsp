<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Login Page</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"  rel="stylesheet">
	<link href="<c:url value="/resources/css/myStyle.css" />"  rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

	<p class="error">${msg}</p>
 <form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="user">
 	<div class="form-group">
    	<label>Username:</label>
      	<form:input path="username"/> <form:errors path="username" cssClass="error"/>
    </div>
    
    <div class="form-group">
        <label>Password:</label>
		<form:input path="password" type="password"/> <form:errors path="password" cssClass="error"/>
	 </div>
	 
	 <input type="submit" value="Login" class="btn btn-primary pull-left">
	 
 </form:form>

<%-- <form action="login" method="post">
        <div class="form-group">
          <label>Username:</label>
          <input type="text" class="form-control" name="username">
        </div>
		 
		<div class="form-group">
        <label>Password:</label>
		<input type="password" class="form-control" name="password">
		
        </div>
        <input type="submit" value="Login" class="btn btn-primary pull-right">
	</form> --%>
</body>
</html>
