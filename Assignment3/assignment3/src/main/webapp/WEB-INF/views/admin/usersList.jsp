<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
function active(st, id){
	$.ajax({
	  url: "${pageContext.request.contextPath}/admin/user/enabled",
      type: 'POST',
      cache: false,
      data: {
        enabled : st,
        idUser: id
      },
	});	
}

function changeRole(str,id){
	$.ajax({
	  url: "${pageContext.request.contextPath}/admin/user/role",
      type: 'POST',
      cache: false,
      data: {
        role : str,
        idUser : id
      },
	});	
}
</script>

	<%@ include file="header.jsp" %>
	<div class="container main-container">
	<div class="panel panel-default">
 		<div class="panel-body " id="contentPage">
 			<h1>Danh sách user </h1>
         	<p style="color: red">${msg}</p>
 			<table id="tableList"> 
						<thead>
						<tr>
							<th>ID</th>
							<th>Username</th>
							<th>Quyền truy cập</th>
			 				<th>Hoạt động</th>
							<th>Xóa</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${usersList}" var="user">
						<tr>
						  <td>${user.getId()}</td>
						  <td>${user.getUsername()}</td>
						  <td>
						  <select id="role" onchange="changeRole(this.value,${user.getId()})">
							  <option value="admin" ${user.getRole().equals("admin") ? 'selected="selected"' : ''}>
							  Admin
							  </option>
							  <option value="user" ${user.getRole().equals("user") ? 'selected="selected"' : ''}>
							  User
							  </option>
							</select>
						  </td>
						  <td>
						  <input type="checkbox" id="active" 
				     		value="${user.getEnabled()}" ${user.getEnabled() == 1 ? 'checked' : ''} 
				     		onclick="active(${user.getEnabled()}, ${user.getId()})">
						  </td>
						  <td>
							<a onclick="return confirm('Bạn muốn xóa không ?')" title="Xóa" 
							  href="${pageContext.request.contextPath}/admin/user/${user.getId()}/delete">
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

