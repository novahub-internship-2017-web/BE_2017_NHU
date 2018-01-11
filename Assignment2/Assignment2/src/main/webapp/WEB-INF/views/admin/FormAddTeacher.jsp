<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery_technicalkeeda.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script><!-- 
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script> -->
<script>
function validateInfoTeacherUser(){
	var validator = $("#formAddTeacher").validate({
    rules: {
    	username: "required",
    	password: "required",
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
    	username:"Username không được trống",
    	password: "Password không được trống",
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


</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container-fluid main-container">
	<%@ include file="sidebarLeft.jsp" %>
		<div class="col-md-10">
			<div class="panel panel-default">
 		 		<div class="panel-body">
                    <h2> Thêm giáo viên</h2>
                    <h5 class="notifyMessage">${message}</h5>
    				<form id="formAddTeacher" name="formAddTeacher" action="add" method="post" >
    				<table class="tableForm">
    					<tr>
    						<td><label>Username</label></td>
    						<td> <input class="form-control" type="text" name="username" id="username"></td>
    					</tr>
    					<tr>
    						<td><label>Password</label></td>
    						<td> <input class="form-control" type="text" name="password" id="password"></td>
    					</tr>
    					<tr>
    						<td><label>Quyền truy cập</label></td>
    						<td>
    							<select class="form-control" name="role" >
									<option value="user">user</option>
									<option value="admin">admin</option>
								</select>
    						</td>
    					</tr>
    					<tr>
    						<td><label>Họ tên</label></td>
    						<td><input class="form-control" type="text" name="name" id="name"></td>
    					</tr>
    					<tr>
    						<td><label>Năm sinh</label></td>
    						<td><input class="form-control" type="text" name="birthYear" id="birthYear"></td>
    					</tr>
    					<tr>
    						<td><label>Quê quán</label></td>
    						<td><input class="form-control" type="text" name="country" id="country"></td>
    					</tr>
    					<tr>
    						<td><label>Khoa</label></td>
    						<td><input class="form-control" type="text" name="faculty" id="faculty"></td>
    					</tr>
    					<tr>
    						<td><label>Chức vụ</label></td>
    						<td>
    							<select class="form-control" name="degree" id="degree">
							      <option value="">--- Chọn ---</option>
								  <option value="Tiến sĩ">Tiến sĩ</option>
								  <option value="Thạc sĩ">Thạc sĩ</option>
								  <option value="Cử nhân">Cử nhân</option>
								</select>
    						</td>
    					</tr>
    					<tr>
    						<td><label>Phụ cấp</label></td>
    						<td><input class="form-control" type="text" name="allowance" readonly></td>
    					</tr>
    					<tr>
    						<td><label>Số tiết dạy</label></td>
    						<td><input class="form-control" type="text" name="classHours" id="classHours"></td>
    					</tr>
    					<tr>
    						<td><label>Hệ số lương</label></td>
    						<td><input class="form-control" type="text" name="coefficientSalary" id="coefficientSalary"></td>
    					</tr>
    				</table>
					    <input type="submit" value="Đăng ký" class="btn btn-primary pull-right" onclick="validateInfoTeacherUser();">
    				</form>
 	 			</div>
			</div>
		</div>
	</div>
</body>
</html>