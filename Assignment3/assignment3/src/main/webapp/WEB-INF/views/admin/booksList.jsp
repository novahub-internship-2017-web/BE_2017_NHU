<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<%@ include file="header.jsp" %>
	<div class="container main-container">
	<div class="panel panel-default">
 		<div class="panel-body " id="contentPage">
 			<h1>Danh sách </h1>
         	<p style="color: red">${msg}</p>
 			<table id="tableList" style="${css}"> 
						<thead>
						<tr>
							<th>ID</th>
							<th>Tiêu đề</th>
							<th>Tác giả</th>
							<th>Ngày tạo</th>
							<th>Ngày cập nhật</th>
							<th>Tác vụ</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${booksList}" var="book">
						<tr>
						  <td>${book.getId()}</td>
						  <td>${book.getTitle()}</td>
						  <td>${book.getAuthor()}</td>
				    	  <td>${book.getCreatedAt()}</td>
						  <td>${book.getUpdatedAt()}</td>
						  <td>
							<a title="Chi tiết" 
							  href="${pageContext.request.contextPath}/admin/book/${book.getId()}/detail" >
							  <i class="glyphicon glyphicon-zoom-in"></i>
							</a>
							<a onclick="return confirm('Bạn muốn xóa không ?')" title="Xóa" 
							  href="${pageContext.request.contextPath}/admin/book/${book.getId()}/delete">
							  <i class="glyphicon glyphicon-remove-circle"></i>
					 		</a>
						  </td>
						</tr>
						</c:forEach>	
						</tbody>	
					</table>
 		</div>
 	</div>	
	<hr/>
	</div>

