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
<script type="text/javascript">

  function validatePassword(){
  	var validator = $("#formEdit").validate({
      rules: {
      	oldPassword: "required",
      	newPassword: "required",
          confirmPassword: {
              equalTo: "#newPassword"
          }
      },
      messages: {
      	oldPassword:"Vui lòng nhập mật khẩu cũ",
      	newPassword: "Vui lòng nhập mật khẩu mới",
        confirmPassword: "Không khớp mật khẩu mới"
      }
  });
  }
 

</script>
</head>
<body>  
  <%@ include file="header.jsp" %>
  <div class="col-md-3"></div>
  <div class="col-md-6">
  <div class="container-fluid main-container">
	  <div class="panel panel-default">
 	    <div class="panel-body">
        <h2>Thay đổi mật khẩu</h2>
        <h5 class="notifyMessage">${message}</h5>
    	  <form id="formEdit" action="changePassword" method="post" name="formEdit" >
            <table class="tableForm">
            	<tr>
            		<td><label>ID</label></td>
            		<td>
            			<input class="form-control" type="text" name="userId" value="${user.userId}" readonly>
            		</td>
            	</tr>
                <tr>
                  <td><label>Mật khẩu cũ</label></td>
                 <td>
                  <input class="form-control" type="text" name="oldPassword" id="oldPassword">
                </td>
                </tr>
            	<tr>
            		<td><label>Mật khẩu mới</label></td>
            		<td>
                      <input class="form-control" type="text" name="newPassword" id="newPassword">
                     </td>
            	</tr>
            	<tr>
            		<td><label>Xác nhận mật khẩu</label></td>
            		<td>
                      <input class="form-control" type="text" name="confirmPassword" id="confirmPassword">
                     </td>
            	</tr>
            	<tr>
            		<td></td>
            		<td>
            			<input type="submit" value="Chỉnh sửa" class="btn btn-primary" onclick="validatePassword();">
            		</td>
            	</tr>
            </table>
			 
    	  </form>
 	    </div>
	</div>
  </div>
  </div>
  <div class="col-md-3"></div>
</body>
</html>