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
    	username:"Username không được trống",
    	password: "Password không được trống",
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
  <div class="container-fluid main-container">
  <%@ include file="sidebarLeft.jsp" %>
	<div class="col-md-10">
	  <div class="panel panel-default">
 	    <div class="panel-body">
          <h2>Chỉnh sửa thông tin nhân viên</h2>
          <h5 class="notifyMessage">${message}</h5>
    	  <form name="formEditStaff" id="formEditStaff" action="edit" method="post">
            <table class="tableForm">
            	<tr>
    				<td><label>ID</label></td>
    				<td> 
    				<input class="form-control" type="text" name="staffId" id="staffId"
                            value="${staff.staffId}" readonly>
    				</td>
    			</tr>
    			<tr>
    				<td><label>Họ tên</label></td>
    				<td> 
    				<input class="form-control" type="text" name="name" id="name"
                            value="${staff.name}">
    				</td>
    			</tr>
    			<tr>
    				<td><label>Năm sinh</label></td>
    				<td> 
    				<input class="form-control" type="text" name="birthYear" id="birthYear"
                            value="${staff.birthYear}">
    				</td>
    			</tr>
    			<tr>
    				<td><label>Quê quán</label></td>
    				<td> 
    				<input class="form-control" type="text" name="country" id="country"
                            value="${staff.country}">
    				</td>
    			</tr>
    			<tr>
    				<td><label>Phòng ban</label></td>
    				<td> 
    				<input class="form-control" type="text" name="department" id="department"
                            value="${staff.department}">
    				</td>
    			</tr>
    			<tr>
    				<td><label>Chức vụ</label></td>
    				<td> 
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
    			</tr>
    			<tr>
    				<td><label>Phụ cấp</label></td>
    				<td> 
    				<input class="form-control" type="text" name="allowance" 
                            value="${staff.allowance}" readonly>
    				</td>
    			</tr>
    			<tr>
    				<td><label>Ngày làm việc</label></td>
    				<td> 
    				<input class="form-control" type="text" name="workDays" id="workDays"
                            value="${staff.workDays}">
    				</td>
    			</tr>
    			<tr>
    				<td><label>Hệ số lương</label></td>
    				<td> 
    				<input class="form-control" name="coefficientSalary" id="coefficientSalary"
                           type="text" value="${staff.coefficientSalary}">
    				</td>
    			</tr>
    			<tr>
            		<td></td>
            		<td>
            			<input type="submit" value="Chỉnh sửa" class="btn btn-primary" onclick="validateInfoStaff();">
            			<a class="btn btn-md btn-warning pull-right" 
                  href="${pageContext.request.contextPath}/admin/user/editForm?id=${staff.staffId}">
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