<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
function validateUserCreation(){
	var validator = $("#validateUser").validate({
    rules: {
    	username: "required",
    	password: "required",
    	confirmPassword: {
              equalTo: "#password"
        }
    },
    messages: {
    	username:"Không được trống",
    	password:"Không được trống",
    	confirmPassword: "Không khớp"
    }
});
}
</script>
	<%@ include file="header.jsp" %>
	<div class="container main-container">
	<div class="panel panel-default col-md-6 col-md-offset-3">
 		<div class="panel-body text-center" id="contentPage">
 			<h1>Thêm người dùng</h1>
 			<h5 class="error">${msg}</h5>
 			<form id="validateUser" name="validateUser" 
 						action="${pageContext.request.contextPath}/admin/user/add" method="post">
    				<table class="tableForm" style="width:100%">
    					<tr>
    						<td><label >Username</label></td>
    						<td><input name="username" id="username" class="form-control" 
    								type="text" value="${usn}"></td>
    					</tr>
    					<tr>
    						<td><label>Mật khẩu</label></td>
    						<td> <input name="password" id="password" class="form-control" 
    							type="password" value="${pw}"></td>
    					</tr>
    					<tr>
    						<td><label>Xác nhận lại mật khẩu</label></td>
    						<td> <input name="confirmPassword" id="confirmPassword" 
    									class="form-control" type="password"></td>
    					</tr>
    					<tr>
    						<td><label>Quyền truy cập</label></td>
    						<td>
								<select name="role" id="role">
									  <option value="admin" > Admin </option>
									  <option value="user" selected> User </option>
								</select>
							</td>
    					</tr>
    					<tr>
    						<td><input onclick="validateUserCreation();" type="submit" 
    						value="Đăng ký" class="btn btn-primary pull-left"></td>
    						<td>
							</td>
    					</tr>
    				</table>
					    
    				</form>
    				
 		</div>
 	</div>	

	</div>

