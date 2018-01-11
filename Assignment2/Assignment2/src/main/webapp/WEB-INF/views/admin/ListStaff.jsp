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
 		 			<h1>Danh sách nhân viên</h1>
 		 			
 		 			<a class="btn btn-md btn-primary" href="${pageContext.request.contextPath}/admin/staff/addForm">
 		 			<span>Thêm nhân viên</span>
         			 <i class="glyphicon glyphicon-plus-sign"></i>
         			 
         			 </a> 
    				<table id="tableList"> 
						<thead>
						<tr>
							<th>ID</th>
							<th>Tên</th>
							<th>Năm sinh</th>
							<th>Quê quán</th>
							<th>Loại</th>
							<th>Bộ phận</th>
							<th>Chức vụ</th>
							<th>Ngày làm việc </th>
							<th>Phụ cấp</th>
							<th>Hệ số lương </th>
							<th>Lương</th>
							<th>Tác vụ</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${listStaff}" var="staff">
						<tr>
						  <td>${staff.staffId}</td>
						  <td>${staff.name}</td>
						  <td>${staff.birthYear}</td>
				    	  <td>${staff.country}</td>
						  <td>${staff.career}</td>
							<td>${staff.department}</td>
							<td>${staff.position}</td>
							<td>${staff.workDays}</td>
							<td>${staff.allowance}</td>
							<td>${staff.coefficientSalary}</td>
							<td>${Math.round((staff.coefficientSalary*730 + staff.allowance + staff.workDays*30)*100)/100}</td>
						  <td>
							<a title="Chỉnh sửa" 
							  href="${pageContext.request.contextPath}/admin/staff/editForm?id=${staff.staffId}" >
							  <i class="glyphicon glyphicon-edit"></i>
							</a>
							<a onclick="return confirm('Bạn muốn xóa không ?')" title="Xóa" 
							  href="${pageContext.request.contextPath}/admin/staff/delete?id=${staff.staffId}">
							  <i class="glyphicon glyphicon-remove-circle"></i>
					 		</a>
							</td>
						</tr>
						</c:forEach>	
						</tbody>	
					</table>
 	 			</div>
			</div>
		</div>
	</div>
</body>
</html>