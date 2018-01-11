<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String userName = null;
//allow access only if session exists
if(session.getAttribute("currentSessionUser") == null){
  response.sendRedirect("${pageContext.request.contextPath}/login");
  //request.getRequestDispatcher("${pageContext.request.contextPath}/login").forward(request, response);
}else userName = (String) session.getAttribute("currentSessionUser");
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
  if(cookie.getName().equals("currentSessionUser")) userName = cookie.getValue();
}
}
%>
	<div class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
					Admin Site
				</a>
			</div>
	
			<div class="collapse navbar-collapse" id="">			
				<form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/admin/user/search"  method="GET" >
					<div class="form-group">
						<input type="text" name="keyword" class="form-control" >
						
					</div>
					<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
					Tìm kiếm cán bộ theo : 
						<select name="searchBy">
							<option value="name">Tên</option>
							<option value="country">Quê quán</option>
							<option value="birthYear">Năm sinh</option>
						</select>
				</form>
      
				<div class="nav navbar-text navbar-right" style="margin-right: 10px;">
                    <label>Hi, <%=userName %></label>
					<a href="${pageContext.request.contextPath}/logout" >Đăng xuất </a>
					
				</div>
			</div>
		</div>
	</div>
