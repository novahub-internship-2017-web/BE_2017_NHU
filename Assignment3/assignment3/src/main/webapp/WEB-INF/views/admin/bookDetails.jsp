<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

	<%@ include file="header.jsp" %>
	<div class="container main-container">
	<div class="panel panel-default">
 		<div class="panel-body " id="contentPage">
 			
 			<div class="col-md-4" >
 				<img src="<c:url value="/resources/images/${book.getPicture()}"/>" width=350px>
 			</div>
 			<div class="col-md-8">
 				<table class="tableFormDetail">
    					<tr>
    						<td colspan="2"><h1>${book.getTitle()}</h1></td>
    					</tr>
    					<tr>
    						<td><label>Tác giả</label></td>
    						<td>${book.getAuthor()}</td>
    					</tr>
    					
    					<tr>
    						<td><label>Ngày tạo</label></td>
    						<td>${book.getCreatedAt()}</td>
    					</tr>
    					<tr>
    						<td><label>Ngày cập nhật</label></td>
    						<td>${book.getUpdatedAt()}</td>
    					</tr>
    					<tr>
    						<td><label>Mô tả</label></td>
    						<td>${book.getDescription()}</td>
    					</tr>
    					<tr>
    						<td>
    							<p style="color: red">${msg}</p>
    							<a class="btn btn-md btn-primary" href="${pageContext.request.contextPath}/admin/book/editForm?id=${book.getId()}">
 		 							<span>Chỉnh sửa</span>
         						</a>
    						</td>
    						<td></td>
    					</tr>
    				</table>
 			</div>
    				
    				
 		</div>
 	</div>	
	</div>

