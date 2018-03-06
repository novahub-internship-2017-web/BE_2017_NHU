<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="<c:url value="/resources/js/jquery_technicalkeeda.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" >
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/myStyle.css" />">
</head>

<div id="adminPage" class=" navbar navbar-static-top " >
		<div class="container-fluid" style="">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/admin/book/booksList">
					Book Management
				</a>
			</div>
	
			<div class="collapse navbar-collapse" id="">			
				<form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/admin/book/search"  method="POST" >
					<div class="form-group">
						<input type="text" name="keyword" class="form-control" >
						
					</div>
					<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
					Tìm kiếm theo : 
						<select name="searchBy" style="color:black">
							<option value="all_field">Tất cả</option>
							<option value="title">Tiêu đề</option>
							<option value="author">Tác giả</option>
						</select>
				</form>
      
				<div class="nav navbar-text navbar-right" style="margin-right: 10px;">
                    <label>Hi, ${currentSessionUsername}! </label>
					<a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/admin/user/changePassForm">
 		 			<span>Đổi mật khẩu</span>
         			</a>
                    <a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/logout">
 		 			<span>Đăng xuất</span>
         			</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container main-container" id="menubar">
	<a class="btn btn-md btn-primary" href="${pageContext.request.contextPath}/admin/user/list">
 		 			<span>Quản lý user</span>
         	</a>
         	<a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/admin/book/booksList">
 		 			<span>Quản lý sách</span>
         	</a>
         	<a class="btn btn-md btn-primary" href="${pageContext.request.contextPath}/admin/book/booksListUser">
 		 			<span>Sách của bạn</span>
         	</a>
 			<a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/admin/book/addForm">
 		 			<span>Thêm sách mới</span>
         	</a> 
         	<a class="btn btn-md btn-primary" href="${pageContext.request.contextPath}/admin/user/addForm">
 		 			<span>Thêm user</span>
         	</a>
	</div>
</html>
