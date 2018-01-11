<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery_technicalkeeda.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css?<%=System.currentTimeMillis()%>" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){ 
	$("select[name=degree]").change(function(){
		var Degree = $(this).val();
		if(Degree == "Tiến sĩ"){
			$("input[name=allowance]").val("2000")
		}else if(Degree == "Thạc sĩ"){
			$("input[name=allowance]").val("900")
		}else if(Degree == "Cử nhân"){
			$("input[name=allowance]").val("300")
		}
  });
});

function validateInfoTeacher(){
	var validator = $("#formEditTeacher").validate({
    rules: {
    	name: "required",
    	birthYear: {
    		required :true,
    		digits : true
    	},
    	country: "required",
    	faculty: "required",
    	degree: "required",
    	classHours: "required",
    	coefficientSalary: {
    		required :true,
    		number : true
    	}
    },
    messages: {
    	name: "Họ tên không được trống",
    	birthYear: "Năm sinh không được trống và phải là số nguyên",
    	country: "Quê quán không được trống",
    	faculty: "Khoa không được trống",
    	degree: "Vui lòng chọn",
    	classHours: "Số tiết dạy không được trống và phải là số",
    	coefficientSalary: "Hệ số lương không được trống và phải là số"
    }
});
}
</script>

</head>
<body>  
  <%@ include file="header.jsp" %>
  <div class="container-fluid main-container">
  <%@ include file="sidebarLeft.jsp" %>
	<div class="col-md-10">
	  <div class="panel panel-default">
 	    <div class="panel-body">
    	  <form id="formEditTeacher" action="edit" method="post" name="formEditTeacher">
            <h2>Chỉnh sửa thông tin giáo viên</h2>
            <h5 class="notifyMessage">${message}</h5>
            <table class="tableForm">
            	<tr>
            		<td><label>ID</label></td>
            		<td>
            			<input class="form-control" type="text" name="teacherId" id="teacherId" 
                               value="${teacher.teacherId}" readonly>
            		</td>
            	</tr>
            	<tr>
            		<td><label>Họ tên</label></td>
            		<td>
            			<input class="form-control" type="text" name="name" id="name"
                              value="${teacher.name}">
            		</td>
            	</tr>
            	<tr>
            		<td><label>Năm sinh</label></td>
            		<td>
            			<input class="form-control" type="text" name="birthYear" id="birthYear"
                                value="${teacher.birthYear}">
            		</td>
            	</tr>
            	<tr>
            		<td><label>Quê quán</label></td>
            		<td>
            			<input class="form-control" type="text" name="country" id="country"
                                value="${teacher.country}">
            		</td>
            	</tr>
            	<tr>
            		<td><label>Phòng ban</label></td>
            		<td>
            			<input class="form-control" type="text" name="faculty" id="faculty"
                               value="${teacher.faculty}">
            		</td>
            	</tr>
            	<tr>
            		<td><label>Chức vụ</label></td>
            		<td>
            			<select class="form-control" name="degree"  id="degree">
						  <option value="Tiến sĩ" ${teacher.degree.equals("Tiến sĩ") ? 'selected="selected"' : ''}>
						  Tiến sĩ
						  </option>
						  <option value="Thạc sĩ" ${teacher.degree.equals("Thạc sĩ") ? 'selected="selected"' : ''}>
						  Thạc sĩ
						  </option>
						  <option value="Cử nhân" ${teacher.degree.equals("Cử nhân") ? 'selected="selected"' : ''}>
						  Cử nhân
						  </option>
						</select>
            		</td>
            	</tr>
            	<tr>
            		<td><label>Phụ cấp</label></td>
            		<td>
            			<input class="form-control" type="text" name="allowance" id="allowance"
                                value="${teacher.allowance}" readonly>
            		</td>
            	</tr>
            	<tr>
            		<td><label>Số tiết dạy</label></td>
            		<td>
            			<input class="form-control" type="text" name="classHours" 
                              id="classHours" value="${teacher.classHours}">
            		</td>
            	</tr>
            	<tr>
            		<td><label>Hệ số lương</label></td>
            		<td>
            			<input class="form-control" type="text" name="coefficientSalary" 
                              id="coefficientSalary"  value="${teacher.coefficientSalary}">
            		</td>
            	</tr>
            	<tr>
            		<td></td>
            		<td>
            			<input type="submit" value="Chỉnh sửa" class="btn btn-primary" onclick="validateInfoTeacher();">
            			<a class="btn btn-md btn-warning pull-right" href="${pageContext.request.contextPath}/admin/user/editForm?id=${teacher.teacherId}">
 		 				<span>Chỉnh sửa thông tin tài khoản</span> 
         				</a>
            		</td>
            	</tr>
            </table>
			
    	  </form>
 	    </div>
	  </div>
	</div>
  </div>
</body>
</html>