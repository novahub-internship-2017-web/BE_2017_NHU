<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

	<%@ include file="header.jsp" %>
	<div class="container main-container">
	<div class="panel panel-default col-md-8 col-md-offset-2">
 		<div class="panel-body " id="contentPage">
 			<h1>Chỉnh sửa thông tin sách</h1>
 			${error}
  				<form:form action="${pageContext.request.contextPath}/book/upload" method="post"
 				class="form-group" enctype="multipart/form-data" >
    				<input type="file" name="fileUpload"/>
    				<input type="submit" value="up image" class="btn btn-primary pull-right" >	
    				    
    				</form:form>
    				<img src="<c:url value="/resources/images/${urlImage}"/>" width=350px>
    				<img src="<c:url value="/resources/images/22020714032018.jpg"/>" width=350px>
 		</div>
 	</div>	

	</div>

