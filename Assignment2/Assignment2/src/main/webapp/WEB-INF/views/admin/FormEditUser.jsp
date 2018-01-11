<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css?<%=System.currentTimeMillis()%>" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
</head>
<body>  
  <%@ include file="header.jsp" %>
  <div class="container-fluid main-container">
  <%@ include file="sidebarLeft.jsp" %>
	<div class="col-md-10">
	  <div class="panel panel-default">
 	    <div class="panel-body">
    	  <form class="formEdit" action="edit" method="post" name="formEdit">
            <h2>Chỉnh sửa tài khoản người dùng</h2>
            <table class="tableForm">
            	<tr>
            		<td><label>ID</label></td>
            		<td>
            			<input class="form-control" type="text" name="userId" value="${user.userId}" readonly>
            		</td>
            	</tr>
            	<tr>
            		<td><label>Username</label></td>
            		<td>
            			<input class="form-control" type="text" name="username" value="${user.username}" readonly>
            		</td>
            	</tr>
              
              <tr>
                <td><label>Quyền truy cập</label></td>
                <td>
                  <select class="form-control" name="role">
              <option value="admin" ${user.role.equals("admin") ? 'selected="selected"' : ''}>
              admin
              </option>
              <option value="user" ${user.role.equals("user") ? 'selected="selected"' : ''}>
              user
              </option>
            </select>
                </td>
              </tr>
            	<tr>
            		<td><label>Password</label></td>
            		<td>
                        <a class="btn btn-md btn-default" href="${pageContext.request.contextPath}/admin/user/changePassForm?id=${user.userId}">
   		 			     <span>Đổi password</span> 
           		        </a>
                      <input class="form-control" type="hidden" name="password" value="${user.password}" >
            		</td>
            	</tr>
            	<tr>
            		<td></td>
            		<td><input name="active" value="${user.active}" type="hidden"></td>
            	</tr>
            	<tr>
            		<td></td>
            		<td>
            			<input type="submit" value="Chỉnh sửa" class="btn btn-primary" >
            			<a class="btn btn-md btn-warning pull-right" href="${pageContext.request.contextPath}/admin/user/editInfoDetail?id=${user.userId}">
 		 				<span>Chỉnh sửa thông tin cá nhân</span> 
         				</a>
            		</td>
            	</tr>
            </table>
            <h5 class="notifyMessage">${message}</h5>
    	  </form>
 	    </div>
	  </div>
	</div>
  </div>
</body>
</html>