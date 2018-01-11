<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 		 		<div class="panel-body " id="contentPage">
 		 			<h1>Danh sách giáo viên</h1>
 		 			
 		 			<a class="btn btn-md btn-primary" href="${pageContext.request.contextPath}/admin/teacher/addForm">
 		 			<span>Thêm giáo viên</span>
         			 <i class="glyphicon glyphicon-plus-sign"></i>
         			 
         			 </a> 
    				<table id="tableList" > 
						
						<tr>
							<th>ID</th>
							<th>Tên</th>
							<th>Năm sinh</th>
							<th>Quê quán</th>
							<th>Loại</th>
							<th>Khoa</th>
							<th>Chức vụ</th>
							<th>Số tiết dạy </th>
							<th>Phụ cấp</th>
							<th>Hệ số lương </th>
							<th>Lương </th>
							<th>Tác vụ</th>
						</tr>
						
						
						<c:forEach items="${listTeacher}" var="teacher">
						<tr>
							<td>${teacher.teacherId}</td>
							<td>${teacher.name}</td>
							<td>${teacher.birthYear}</td>
							<td>${teacher.country}</td>
							<td>${teacher.career}</td>
							<td>${teacher.faculty}</td>
							<td>${teacher.degree}</td>
							<td>${teacher.classHours}</td>
							<td>${teacher.allowance}</td>
							<td>${teacher.coefficientSalary}</td>
							<td>${Math.round((teacher.coefficientSalary*730 + teacher.allowance + teacher.classHours*30)*100)/100}</td>
							<td>
								<a title="Chỉnh sửa" 
								href="${pageContext.request.contextPath}/admin/teacher/editForm?id=${teacher.teacherId}" >
								<i class="glyphicon glyphicon-edit"></i>
								</a>
								<a onclick="return confirm('Bạn muốn xóa không ?')" title="Xóa" 
							  href="${pageContext.request.contextPath}/admin/teacher/delete?id=${teacher.teacherId}">
							  <i class="glyphicon glyphicon-remove-circle"></i>
					 		</a>
							</td>
						</tr>
						</c:forEach>	
							
					</table>
 	 			</div>
			</div>
		</div>
	</div>
</body>
</html>