<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css?<%=System.currentTimeMillis()%>" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
</head>
<body>
    <div class=col-md-4></div>
    <div class=col-md-4>
	<form action="LoginServlet" method="post">
        <div class="form-group">
          <label>Username:</label>
          <input type="text" class="form-control" name="username">
        </div>
		 
		<div class="form-group">
        <label>Password:</label>
		<input type="password" class="form-control" name="pwd">
		
        </div>
        <input type="submit" value="Login" class="btn btn-primary pull-right">
	</form>
  </div>
    <div class=col-md-4></div>
</body>
</html>