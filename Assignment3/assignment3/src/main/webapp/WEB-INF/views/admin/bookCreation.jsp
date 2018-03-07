<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
	<%@ include file="header.jsp" %>
	<div class="container main-container">
	<div class="panel panel-default col-md-6 col-md-offset-3" >
 		<div class="panel-body text-center" id="contentPage" >
 			<h1>Thêm sách mới</h1>
 			<form:form id="formBook" name="formBook" class="form-group"
 						action="${pageContext.request.contextPath}/admin/book/add" 
 						method="post" modelAttribute="book" >
    				<table class="tableForm" style="width:100%" >
    					<tr>
    						<td><label >Tiêu đề</label></td>
    						<td><form:input path="title" class="form-control" /></td>
    					</tr>
    					<tr>
    						<td><label>Tác giả</label></td>
    						<td> <form:input path="author" class="form-control"/></td>
    					</tr>
    					<!-- <tr>
    						<td><label>Hình ảnh</label></td>
    						<td> <input type="file" name="fileUpload"/></td>
    					</tr> -->
    					<tr>
    						<td><label>Mô tả</label></td>
    						<td> <form:textarea path="description" class="form-control" /></td>
    					</tr>
    					<tr>
    						<td></td>
    						<td> <input type="submit" value="Đăng ký" class="btn btn-primary pull-right"
					     			onclick="validateFormBook();">
					     	</td>
    					</tr>
    				</table>
					    
    				</form:form>
    				
 		</div>
 	</div>	
	</div>

