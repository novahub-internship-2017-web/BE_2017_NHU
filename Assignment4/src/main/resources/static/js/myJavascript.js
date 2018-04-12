function getBooksList(){
	var roleUser = "isGuess"; 
	if($('#checkRoleUser').val() == 'isAdmin'){
		roleUser = "isAdmin"; 
	}
	if($('#checkRoleUser').val() == 'isUser'){
		roleUser = "isUser"; 
	}
	window.history.pushState('string', '', window.location.origin+'/booksList');
		$.ajax({
			type : "GET",
			url : window.location.origin+"/api/book/all/enabled",
			success: function(result){
				if(result.length > 0){
					$('#Content').html('<table id="tableList"><thead><tr>'+
							'<th>Mã số</th>'+
							'<th>Tiêu đề</th>'+
							'<th>Tác giả</th>'+
							'<th>Ngày tạo</th>'+
							'<th>Ngày cập nhật</th>'+
							'<th>Tác vụ</th>'+
							'</tr></thead>'+
							'<tbody></tbody></table>');
					$.each(result, function(i, book){
						var bookRow = '<tr>' +
							'<td>' + book.id + '</td>' +
							'<td>' + book.title + '</td>' +
							'<td>' + book.author + '</td>' +
							'<td>' + book.createdAt + '</td>' +
							'<td>' + book.updatedAt + '</td>' +
							'<td><a title="Chi tiết" href="javascript:void(0)" onclick="getBookDetail('+book.id+')"> Xem</a>';
						if(roleUser == "isAdmin" || roleUser == "isUser"){
							bookRow += '<a title="Xóa" onclick="getBookDetail('+book.id+')"> Xóa</a>';
					   }
							bookRow +='</td></tr>';
						$('#tableList tbody').append(bookRow);
						
			        });
				}else{
					$('#Content').html('Không có dữ liệu');
				}
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
	}

function getBooksListByUser(){
	var idUser = -1; // not login
	// check id user
	$.ajax({
		type : "GET",
		url : window.location.origin+"/api/user/getCurrentUser",
		success: function(result){		
			idUser = result.id;
		},
		error : function(ex) {
			console.log("ERROR: ", ex);
		}
	});
	alert(window.location.origin+"/api/book/all/"+idUser);
	window.history.pushState('string', '', window.location.origin+'/booksListByUser');
		$.ajax({
			type : "GET",
			url : window.location.origin+"/api/book/all/"+idUser,
			success: function(result){
				if(result.length > 0){
					$('#Content').html('<table id="tableList"><thead><tr>'+
							'<th>Mã số</th>'+
							'<th>Tiêu đề</th>'+
							'<th>Tác giả</th>'+
							'<th>Ngày tạo</th>'+
							'<th>Ngày cập nhật</th>'+
							'<th>Tác vụ</th>'+
							'</tr></thead>'+
							'<tbody></tbody></table>');
					$.each(result, function(i, book){
						var bookRow = '<tr>' +
							'<td>' + book.id + '</td>' +
							'<td>' + book.title + '</td>' +
							'<td>' + book.author + '</td>' +
							'<td>' + book.createdAt + '</td>' +
							'<td>' + book.updatedAt + '</td>' +
							'<td><a title="Chi tiết" href="javascript:void(0)" onclick="getBookDetail('+book.id+')"> Xem</a>';
							bookRow += '<a title="Xóa" onclick="getBookDetail('+book.id+')"> Xóa</a>';
							bookRow +='</td></tr>';
						$('#tableList tbody').append(bookRow);
						
			        });
				}else{
					$('#Content').html('Không có dữ liệu');
				}
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
	}

function getBookDetail(bookId){
	$.ajax({url:window.location.origin+'/bookDetailPage',success:function(result){
      $("#Content").html(result);
    }});
	window.history.pushState('string', '', window.location.origin+'/bookDetail/'+bookId);
	var idUser = -1;
	// check id user
	$.ajax({
		type : "GET",
		url : window.location.origin+"/api/user/getCurrentUser",
		success: function(result){		
			idUser = result.id;
		},
		error : function(ex) {
			console.log("ERROR: ", ex);
		}
	});
	//get book detail
	$.ajax({
		type : "GET",
		url : window.location.origin+"/api/book/"+bookId,
		success: function(result){				
				$('.tableDetailBook').find('#title').html(result.title);
				$('.tableDetailBook').find('td#author').html(result.author);
				$('.tableDetailBook').find('td#created_at').html(result.createdAt);
				$('.tableDetailBook').find('td#updated_at').html(result.updatedAt);
				$('.tableDetailBook').find('td#description').html(result.description);
				document.getElementsByClassName("bookImage")[0].setAttribute("src", "/images/"+result.image);
				
				$('#editBookForm').find('#id').val(result.id);
				$('#editBookForm').find('#title').val(result.title);
				$('#editBookForm').find('#author').val(result.author);
				$('#editBookForm').find('#description').val(result.description);
				if(idUser == result.user_id){
					document.getElementById('buttonEditBook').style.display = 'block';
				}
		},
		error : function(ex) {
			alert("ERROR: ", ex);
			console.log("ERROR: ", ex);
		}
	});
}



function addBookPage(){
	$.ajax({url:window.location.origin+'/bookCreationPage',success:function(result){
	      $("#Content").html(result);
	    }});
}



function censorshipBook(){
	$.ajax({
		type : "GET",
		url : window.location.origin+"/api/book/all/disabled",
		success: function(result){
			if(result.length > 0){
				$('#Content').html('<table id="tableList"><thead><tr>'+
						'<th>Mã số</th>'+
						'<th>Tiêu đề</th>'+
						'<th>Tác giả</th>'+
						'<th>Ngày tạo</th>'+
						'<th>Ngày cập nhật</th>'+
						'<th>Duyệt</th>'+
						'<th>Tác vụ</th>'+
						'</tr></thead>'+
						'<tbody></tbody></table>');
				$.each(result, function(i, book){
					var bookRow = '<tr>' +
						'<td>' + book.id + '</td>' +
						'<td>' + book.title + '</td>' +
						'<td>' + book.author + '</td>' +
						'<td>' + book.createdAt + '</td>' +
						'<td>' + book.updatedAt + '</td>' ;
					if(book.enabled == 1){
						bookRow += '<td><input type="checkbox" value="'+ book.enabled +'" checked onclick="enabled('+book.enabled+','+book.id+')"></td>';
					}else{
						bookRow += '<td><input type="checkbox" value="'+ book.enabled +'" onclick="enabled('+book.enabled+','+book.id+')"></td>';
					}
					bookRow += '<td><a title="Chi tiết" href="javascript:void(0)" onclick="getBookDetail('+book.id+')"> Xem</a>';
					
						bookRow += '<a title="Xóa" onclick="deleteBook('+book.id+')"> Xóa</a>';
						bookRow +='</td></tr>';
					$('#tableList tbody').append(bookRow);
					
		        });
			}else{
				$('#Content').html('Không có dữ liệu');
			}
		},
		error : function(e) {
			alert("ERROR: ", e);
			console.log("ERROR: ", e);
		}
	});	
}

function enabled(st, id){
	$.ajax({
	  url: window.location.origin+"/api/book/enabled/"+id,
      type: 'POST',
      cache: false,
      data: {
        status : st
      },
	});	
}

function deleteBook(bookId){
	var confirmMsg = confirm("Bạn có muốn xóa không ?");
	if(confirmMsg == true){
		$.ajax({
			type : "DELETE",
			url : window.location.origin+"/api/book/delete/"+bookId,
			success: function(result){
				$('.notiMsg').html("Xóa thành công");
				getBooksList();
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
	}
}