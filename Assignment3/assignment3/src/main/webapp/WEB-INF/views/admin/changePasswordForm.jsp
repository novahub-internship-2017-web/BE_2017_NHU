<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
function validateChangePass(){
	var validator = $("#validatePass").validate({
    rules: {
    	oldPassword: "required",
    	newPassword: "required",
    	confirmPassword: {
              equalTo: "#newPassword"
        }
    },
    messages: {
    	oldPassword:"Không được trống",
    	newPassword:"Không được trống",
    	confirmPassword: "Không khớp"
    }
});
}
</script>
	<%@ include file="header.jsp" %>
	<div class="container main-container">
	<div class="panel panel-default col-md-6 col-md-offset-3">
 		<div class="panel-body text-center" id="contentPage">
 			<h1>Cập nhật mật khẩu </h1>
 			<p class="error">${msg}</p>
 			<form action="changePass" method="post" name="validatePass" id="validatePass">
    				<table class="tableForm" style="width:100%">
    					<tr>
    						<td><label >Mật khẩu cũ</label></td>
    						<td><input name="oldPassword" id="oldPassword" class="form-control" 
    								type="password"/></td>
    					</tr>
    					<tr>
    						<td><label>Mật khẩu mới</label></td>
    						<td> <input name="newPassword" id="newPassword" class="form-control" 
    								type="password"/></td>
    					</tr>
    					<tr>
    						<td><label>Xác nhật mật khẩu mới</label></td>
    						<td> <input name="confirmPassword" id="confirmPassword" 
    								class="form-control" type="password"/></td>
    					</tr>
    					<tr>
    						<td></td>
    						<td> <input type="submit" value="Cập nhật" 
    							class="btn btn-primary pull-right"
					    		onclick="validateChangePass();"></td>
    					</tr>
    				</table>
					    
    				</form>
    				
 		</div>
 	</div>	

	</div>

