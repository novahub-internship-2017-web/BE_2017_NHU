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
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<style>
  table{
    table-layout:fixed;
  }
  td,tr{
    border : 20px solid white;
  }
</style>
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
  <div class="col-md-3"></div>
  <div class="container-fluid main-container">
  <div class="col-md-6">
    <div class="panel panel-default">
 	<div class="panel-body">
      <h2  style="text-align:center">Chỉnh sửa thông tin cá nhân</h2>
   	  <form class="form-horizontal"  action="${pageContext.request.contextPath}/user/teacher" 
            id="formEditTeacher" name="formEditTeacher" method="post">
        <table style="width:100%;">
          <tr>
            <td>
              <label>Họ Tên :</label>
              <input class="form-control" type="text" name="name" value="${teacher.name}" >
            </td>
            <td>
              <label>ID :</label>
              <input class="form-control" type="text" name="userId" value="${user.userId}" readonly>
            </td>
          </tr>
          <tr>
            <td>
              <label>Năm sinh :</label>
              <input type="text" class="form-control" name="birthYear" id="birthYear" 
                      value="${teacher.birthYear}">
            </td>
            <td>
              <label>Username :</label>
              <input class="form-control" type="text" name="username" value="${user.username}" readonly>
            </td>
          </tr>
          <tr>
            <td>
              <label>Quê quán</label>
              <input class="form-control" type="text" name="country" id="country" 
                    value="${teacher.country}">
            </td>
            <td>
              <label>Password</label>
              <a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/user/changePassForm?id=${user.userId}">
   		 		<span>Đổi password</span> 
           	  </a>
               <input class="form-control" type="hidden" name="password" value="${user.password}" >
            </td>
          </tr>
          <tr>
            <td>
              <label>Khoa</label>
              <input class="form-control" type="text" name="faculty" id="faculty" 
                      value="${teacher.faculty}">
            </td>
            <td></td>
          </tr>
          <tr>
            <td>
              <label>Chức vụ</label>
              <select class="form-control" name="degree" id="degree">
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
            <td>
              <label>Phụ cấp</label>
              <input class="form-control" type="text" name="allowance" value="${teacher.allowance}" readonly>
            </td>
          </tr>
          <tr>
            <td>
              <label>Số tiết dạy</label>
              <input class="form-control" type="text" name="classHours" id="classHours" 
                    value="${teacher.classHours}">
            </td>
            <td>
              <label>Hệ số lương</label>
              <input class="form-control" type="text" name="coefficientSalary" 
                    id="coefficientSalary" value="${teacher.coefficientSalary}">
            </td>
          </tr>
        </table>
        <div class="container-fluid" style="text-align:center">
        <h5 class="notifyMessage">${message}</h5>
          <input type="submit" value="Chỉnh sửa" class="btn btn-primary" onclick="validateInfoTeacher();">
        </div>        
      </form>
 	</div>
	</div>
  </div>
  </div>
  <div class="col-md-3"></div>
</body>
</html>