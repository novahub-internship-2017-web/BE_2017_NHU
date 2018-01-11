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
  td,tr{
    border : 20px solid white;
  }
</style>

<script>
$(document).ready(function(){ 
	$("select[name=position]").change(function(){
		var Position = $(this).val();
		if(Position == "Trưởng phòng"){
			$("input[name=allowance]").val("1000")
		}else if(Position == "Phó phòng"){
			$("input[name=allowance]").val("600")
		}else if(Position == "Nhân viên"){
			$("input[name=allowance]").val("400")
		}
  });
});

function validateInfoStaff(){
	var validator = $("#formEditStaff").validate({
    rules: {
    	name: "required",
    	birthYear: {
    		required :true,
    		digits : true
    	},
    	country: "required",
    	department: "required",
    	position: "required",
    	workDays: "required",
    	coefficientSalary: {
    		required :true,
    		number : true
    	}
    },
    messages: {
    	name: "Họ tên không được trống",
    	birthYear: "Năm sinh không được trống và phải là số nguyên",
    	country: "Quê quán không được trống",
    	department: "Bộ phận không được trống",
    	position: "Vui lòng chọn",
    	workDays: "Số ngày làm không được trống và phải là số",
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
      
   	  <form class="form-horizontal"action="${pageContext.request.contextPath}/user/staff" 
          method="post" id="formEditStaff" name="formEditStaff" >
        <table style="width:100%;">
          <tr>
            <td>
              <label>Họ Tên :</label>
              <input class="form-control" type="text" name="name" id="name" value="${staff.name}">
            </td>
            <td>
              <label>ID :</label>
              <input class="form-control" type="text" name="userId" value="${user.userId}" readonly>
            </td>
          </tr>
          <tr>
            <td>
              <label>Năm sinh :</label>
              <input type="text" class="form-control" name="birthYear" id="birthYear" value="${staff.birthYear}">
            </td>
            <td>
              <label>Username :</label>
              <input class="form-control" type="text" name="username" value="${user.username}" readonly>
            </td>
          </tr>
          <tr>
            <td>
              <label>Quê quán</label>
              <input class="form-control" type="text" name="country" id="country" value="${staff.country}">
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
              <label>Phòng ban</label>
              <input class="form-control" type="text" name="department" id="department" value="${staff.department}">
            </td>
            <td></td>
          </tr>
          <tr>
            <td>
              <label>Chức vụ</label>
              <select class="form-control" name="position" id="position">
	            <option value="Trưởng phòng" ${staff.position.equals("Trưởng phòng") ? 'selected="selected"' : ''}>
				Trưởng phòng
				</option>
				<option value="Phó phòng" ${staff.position.equals("Phó phòng") ? 'selected="selected"' : ''}>
				Phó phòng
				</option>
				<option value="Nhân viên" ${staff.position.equals("Nhân viên") ? 'selected="selected"' : ''}>
				Nhân viên
				</option>
			   </select>
            </td>
            <td>
              <label>Phụ cấp</label>
              <input class="form-control" type="text" name="allowance" 
                      value="${staff.allowance}" readonly>
            </td>
          </tr>
          <tr>
            <td>
              <label>Ngày làm việc</label>
              <input class="form-control" name="workDays" id="workDays" 
                      type="text" value="${staff.workDays}">
            </td>
            <td>
              <label>Hệ số lương</label>
              <input class="form-control" name="coefficientSalary" id="coefficientSalary" 
                      type="text" value="${staff.coefficientSalary}">
            </td>
          </tr>
        </table>
        <div class="container-fluid" style="text-align:center">
           <h5 class="notifyMessage">${message}</h5>
          <input type="submit" value="Chỉnh sửa" class="btn btn-primary" onclick="validateInfoStaff();">
        </div>
      </form>
 	</div>
	</div>
  </div>
  </div>
  <div class="col-md-3"></div>
</body>
</html>