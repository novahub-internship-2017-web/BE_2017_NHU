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
 			<form:form action="${pageContext.request.contextPath}/admin/book/edit" 
 						class="form-group" method="post" modelAttribute="book" 
 						enctype="multipart/form-data" id="formBook" name="formBook">
    				<table class="tableForm"  style="width:95%">
    					<tr>
    						<td><label >Mã sách</label></td>
    						<td><form:input path="id" value="${book.getId()}" 
    										class="form-control" readonly="true"/></td>
    					</tr>
    					<tr>
    						<td><label >Tiêu đề</label></td>
    						<td><form:input path="title" value="${book.getTitle()}" 
    										class="form-control"/></td>
    					</tr>
    					<tr>
    						<td><label>Tác giả</label></td>
    						<td> <form:input path="author" value="${book.getAuthor()}" 
    										class="form-control"/></td>
    					</tr>
    					<!-- <tr>
    						<td><label>Hình ảnh</label></td>
    						<td> <input type="file" name="fileUpload"/></td>
    					</tr> -->
    					<tr>
    						<td><label>Mô tả</label></td>
    						<td> <form:textarea path="description" value="${book.getDescription()}"
    											class="form-control"/></td>
    					</tr>
    					
    				</table>
					    <input type="submit" value="Cập nhật" class="btn btn-primary pull-right" 
					    		onclick="validateFormBook();">
    				</form:form>
    				
 		</div>
 	</div>	
	<hr/>
	</div>

