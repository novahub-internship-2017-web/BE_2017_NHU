<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../admin/header.jsp" %>
<style>

.modal{
 	display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
 }
 .modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    width: 40%; /* Could be more or less, depending on screen size */
}
</style>
<script type="text/javascript">

function booksListJSON(){
	$.ajax({
		url : "${pageContext.request.contextPath}/admin/book/json/booksList",
		type : "GET",
		contentType : "application/json",
		dataType : 'json',				
		success : function(data) {
			
			 var title = '<table id="tableList" ><tr><td>ID</td>'+
	            		'<td>Tiêu đề</td>'+
	            		'<td>Tác giả</td>'+
	            		'<td>Thời gian tạo</td>'+
	            		'<td>Thời gian cập nhật</td>'+
	            		'<td>Tác vụ</td>'+
	            		'</tr>';
			for (var i=0; i<data.length; i++) {
	            var row = '<tr><td>' + data[i].id+ '</td>'+
	            		'<td>' + data[i].title + '</td>'+
	            		'<td>' + data[i].author + '</td>'+
	            		'<td>' + data[i].createdAt + '</td>'+
	            		'<td>' + data[i].updatedAt + '</td>'+
	            		'<td> <a title="Chi tiết" href="${pageContext.request.contextPath}/admin/book/'+data[i].id+'/detail"> <i class="glyphicon glyphicon-zoom-in"></i></a> </td>'+
	            		'</tr>';
	            title = title + row;
	        }
			title = title+ '</table>';
			$('#result').html(title);
	    },
	    error: function(jqXHR, textStatus, errorThrown){
	        alert('Error: ' + textStatus + ' - ' + errorThrown);
	    
		}
	});
 }
 
function searchJSON(){
		var key = $('#keywordJSON').val();
	    var searchBook = {}
	   searchBook["title"] = $('#keywordJSON').val(); 
	$.ajax({
		url : "${pageContext.request.contextPath}/admin/book/json/search",
		type : "GET",
		contentType : "application/json",
		dataType : 'json',		
		data: {title:$('#keywordJSON').val()},
		success : function(data) {
			if(data.length > 0){
				 var title = '<table id="tableList" ><tr><td>ID</td>'+
         		'<td>Tiêu đề</td>'+
         		'<td>Tác giả</td>'+
         		'<td>Thời gian tạo</td>'+
         		'<td>Thời gian cập nhật</td>'+
         		'<td>Tác vụ</td>'+
         		'</tr>';
			for (var i=0; i<data.length; i++) {
	         var row = '<tr><td>' + data[i].id+ '</td>'+
	         		'<td>' + data[i].title + '</td>'+
	         		'<td>' + data[i].author + '</td>'+
	         		'<td>' + data[i].createdAt + '</td>'+
	         		'<td>' + data[i].updatedAt + '</td>'+
	         		'<td> <a title="Chi tiết" href="${pageContext.request.contextPath}/admin/book/'+data[i].id+'/detail"> <i class="glyphicon glyphicon-zoom-in"></i></a> </td>'+
	         		'</tr>';
	         title = title + row;
	     	}
			title = title+ '</table>';
			title = '<p class="error">Kết quả tìm kiếm với từ khóa "<i>'+key+'"</i></p>' + title;
			$('#result').html(title);	
			}
			else{
				$('#result').html('<p class="error">Không có kết quả với từ khóa "<i>'+key+'"</i></p>');	
			}
			
	    },
	    error: function(jqXHR, textStatus, errorThrown){
	        alert('Error: ' + textStatus + ' - ' + errorThrown);
	    
		}
	});
 }
 
 function addBookJSON(){
	 var newBook = {}
	 newBook["title"] = $('#title').val();
	 newBook["author"]= $('#author').val();	
	 newBook["description"]= $('#description').val();	
	 $.ajax({
	  type: "post",
	  contentType : "application/json",
	  dataType : 'json',
	  url: "${pageContext.request.contextPath}/admin/book/json/add",
	  cache: false,    
	  data:JSON.stringify(newBook),
	  success: function(data){
		  document.getElementById('formAddBook').style.display='none';
		  var title = '<table id="tableList" ><tr><td>ID</td>'+
  		'<td>Tiêu đề</td>'+
  		'<td>Tác giả</td>'+
  		'<td>Thời gian tạo</td>'+
  		'<td>Thời gian cập nhật</td>'+
  		'<td>Tác vụ</td>'+
  		'</tr>';
for (var i=0; i<data.length; i++) {
  	var row = '<tr><td>' + data[i].id+ '</td>'+
  		'<td>' + data[i].title + '</td>'+
  		'<td>' + data[i].author + '</td>'+
  		'<td>' + data[i].createdAt + '</td>'+
  		'<td>' + data[i].updatedAt + '</td>'+
  		'<td> <a title="Chi tiết" '+
  		'href="${pageContext.request.contextPath}/admin/book/'+data[i].id+'/detail"> '+
  		'<i class="glyphicon glyphicon-zoom-in"></i></a> </td>'+
  		'</tr>';
  title = title + row;
}
title = title+ '</table>';
title = '<p class="error"> Đã thêm thành công </p>' + title;
$('#result').html(title);
	  },
	  error: function(){      
	   alert('Error while request..');
	  }
	 });
	}
 
</script>

	<div class="container main-container">
	<div class="panel panel-default">
 		<div class="panel-body " id="contentPage">
 			<div >
 				<input type="button" id="" value="Thêm sách" 
 					onclick="document.getElementById('formAddBook').style.display='block'"/>
 				<input type="button" id="buttonn" value="Toàn bộ sách" onclick="booksListJSON();"/>
				<input type="text" name="keywordJSON" id="keywordJSON" class="form-control" placeholder="Tìm kiếm">						
				<button type="submit" class="btn btn-default" onclick="searchJSON();">
				<i class="glyphicon glyphicon-search"></i></button>
			
 			</div>
 			
         	<p style="color: red">${msg}</p>
         	<div id="formAddBook" class="modal text-center">
         	 <form class="modal-content animate" name="employeeForm" method="post"> 
         	 <h3>Thêm sách mới</h3>
			  <table style=" width:100%"  class="tableForm">
			   <tr>
			    <td><label ><b>Tiêu đề</b></label></td>
			    <td><input type="text" name="title" id="title" class="form-control" required></td>
			   </tr>
			   <tr>
			    <td><label ><b>Tác giả</b></label></td>
			    <td> <input type="text" name="author" id="author" class="form-control" required></td>
			   </tr>
			   <tr>
			    <td><label ><b>Mô tả</b></label></td>
			    <td> <textarea name="description" id="description" class="form-control"></textarea>
			   </tr>
			   <tr>
			    <td></td>
			    <td>
			    	<input type="button" value="Thêm" class="btn btn-primary "
						     onclick="addBookJSON();">
				    <input type="button" value="Hủy" class="btn btn-danger"
				     	onclick="document.getElementById('formAddBook').style.display='none'">
				    
			    </td>
			   </tr>
			  </table>
			 </form>
			 
		</div>
		
 			<div id="result"></div>

			
 		</div>
 	</div>	
	</div>
