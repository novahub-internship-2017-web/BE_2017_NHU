<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css?<%=System.currentTimeMillis()%>" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>  
  <%@ include file="header.jsp" %>
  <div class="container-fluid main-container">
  <%@ include file="sidebarLeft.jsp" %>
	<div class="col-md-10">
	  <div class="panel panel-default">
 	    <div class="panel-body">
    	  <h2 class="notifyMessage">${message}</h2>
 	    </div>
	  </div>
	</div>
  </div>
</body>
</html>