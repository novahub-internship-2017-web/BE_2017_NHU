<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Thêm người dùng</title>
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
 		 		<div class="panel-body" style="text-align:center">
 		 		<h2>Thêm tài khoản người dùng</h2>
    			<h5>Chọn loại cán bộ</h5>	
    			<a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/admin/staff/addForm">
 		 			<span>Nhân viên</span> 
         		</a>
    			<a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/admin/teacher/addForm">
 		 			<span>Giáo viên</span>
         		</a>
 	 			</div>
			</div>
		</div>
	</div>
</body>
</html>