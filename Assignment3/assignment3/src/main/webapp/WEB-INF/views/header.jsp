<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"  rel="stylesheet">
	<link href="<c:url value="/resources/css/myStyle.css" />"  rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
    <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.validate.js"></script>
	<script src="<c:url value="/resources/js/myValidation.js" />"></script>

</head>

<div class="navbar navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/book/booksList">
					Book Management
				</a>
			</div>
	
			<div class="collapse navbar-collapse" id="">			
				<form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/book/search"  method="POST" >
					<div class="form-group">
						<input type="text" name="keyword" class="form-control" >
						
					</div>
					<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
					Tìm kiếm theo : 
						<select name="searchBy" style="color:black">
							<option value="title">Tiêu đề</option>
							<option value="author">Tác giả</option>
						</select>
				</form>
      
				<div class="nav navbar-text navbar-right" style="margin-right: 10px;">
					
                    <label>Hi, ${currentSessionUsername}! </label>
                    <a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/changePassForm">
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
		<a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/book/addForm">
 		 			<span>Thêm sách mới</span>
        </a> 
      	<a class="btn btn-md btn-warning" href="${pageContext.request.contextPath}/book/booksListUser">
 		 			<span>Sách của bạn</span>
         </a>
         <a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/book/booksList">
 		 			<span>Toàn bộ sách</span>
        </a>
	</div>
</html>
