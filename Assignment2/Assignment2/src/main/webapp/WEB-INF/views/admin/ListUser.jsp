<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css?<%=System.currentTimeMillis()%>" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-confirmation.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script>
function active(st, id){
	$.ajax({
	  url: "${pageContext.request.contextPath}/admin/user/role",
      type: 'POST',
      cache: false,
      data: {
        status : st,
        idUser: id
      },
	});	
}
</script>
<style>

</style>
</head>
<body>
  <%@ include file="header.jsp" %>
  <div class="container-fluid main-container">
  <%@ include file="sidebarLeft.jsp" %>
    <div class="col-md-10">
	  <div class="panel panel-default">
 	  <div class="panel-body " id="contentPage">
 	    <h1>Danh sách người dùng</h1>
 		  <a class="btn btn-md btn-primary" href="${pageContext.request.contextPath}/admin/user/addForm">
 		 	 <span>Thêm người dùng</span>
         	 <i class="glyphicon glyphicon-plus-sign"></i>
          </a> 
    	  <table id="tableList"> 
			<thead>
			<tr>
			  <th>ID</th>
			  <th>Username</th>
			  <th>Quyền truy cập</th>
			  <th>Active</th>
			  <th>Tác vụ</th>
			</tr>
			</thead>
			<tbody>
			  <c:forEach items="${listUser}" var="user">
				 <tr>
				   <td>${user.userId}</td>
				   <td>${user.username}</td>
				   <td>${user.role}</td>	
				   <td>
				     <input type="checkbox" id="active" 
				     value="${user.active}" ${user.active == 1 ? 'checked' : ''} 
				     onclick="active(${user.active }, ${user.userId})">
				   </td>
				   <td>
					 <a title="Chỉnh sửa"
					 	href="${pageContext.request.contextPath}/admin/user/editForm?id=${user.userId}" >
					 	<i class="glyphicon glyphicon-edit"></i>
					 </a>
					 <a onclick="return confirm('Bạn muốn xóa không ?')" title="Xóa" 
					    href="${pageContext.request.contextPath}/admin/user/delete?id=${user.userId}">
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
  </div>	
</body>
</html>