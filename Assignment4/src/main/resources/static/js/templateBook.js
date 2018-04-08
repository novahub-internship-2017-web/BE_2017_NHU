function getBooksList(){
		$.ajax({
			type : "GET",
			url : window.location.origin+"/api/book/all",
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
						var urlDetailBook = window.location.origin+"/";
						var bookRow = '<tr>' +
							'<td>' + book.id + '</td>' +
							'<td>' + book.title + '</td>' +
							'<td>' + book.author + '</td>' +
							'<td>' + book.created_at + '</td>' +
							'<td>' + book.updated_at + '</td>' +
							'<td><a title="Chi tiết" href="javascript:void(0)" onclick="getBookDetail('+book.id+')"> Xem</a>';
						/*if('${isAdmiin}' == true){
							bookRow += '<a title="Xóa" onclick="getBookDetail('+book.id+')"> Xóa</a>';
					   }*/
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
	$.ajax({
		type : "GET",
		url : window.location.origin+"/api/book/"+bookId,
		success: function(result){				
				$('.tableDetailBook').find('#title').html(result.title);
				$('.tableDetailBook').find('td#author').html(result.author);
				$('.tableDetailBook').find('td#created_at').html(result.created_at);
				$('.tableDetailBook').find('td#updated_at').html(result.updated_at);
				$('.tableDetailBook').find('td#description').html(result.description);
				document.getElementsByClassName("bookImage")[0].setAttribute("src", "/images/"+result.image);
				
				$('#editBookForm').find('#id').val(result.id);
				$('#editBookForm').find('#title').val(result.title);
				$('#editBookForm').find('#author').val(result.author);
				$('#editBookForm').find('#description').val(result.description);
		},
		error : function(ex) {
			alert("ERROR: ", ex);
			console.log("ERROR: ", ex);
		}
	});
}

function editBook(){
		var bookId = $('#editBookForm').find('#id').val();
		 var updateBook = {}
		 updateBook["title"] = $('#editBookForm').find('#title').val();
		 updateBook["author"]= $('#editBookForm').find('#author').val();	
		 updateBook["description"]= $('#editBookForm').find('#description').val();
		 alert("hi");
		 $.ajax({
			type : "PUT",
			contentType : "application/json",
			url : window.location.origin+"/api/book/update/"+bookId,
			data : JSON.stringify(updateBook),
			dataType : 'json',
			success: function(result){

				  document.getElementById('editBookFormDiv').style.display='none';
				  $('.tableDetailBook').find('#title').html(result.title);
				  $('.tableDetailBook').find('td#author').html(result.author);
				  $('.tableDetailBook').find('td#created_at').html(result.created_at);
				  $('.tableDetailBook').find('td#updated_at').html(result.updated_at);
				  $('.tableDetailBook').find('td#description').html(result.description); 
			 },
		  error: function(e){      
		   alert('Error while request..'+e);
		  }
		 }); 
	}

function addBookPage(){
	$.ajax({url:window.location.origin+'/bookCreationPage',success:function(result){
	      $("#Content").html(result);
	    }});
}

function addBook(){
	 var newBook = {}
	 newBook["title"] = $('#bookCreationForm').find('#title').val();
	 newBook["author"]= $('#bookCreationForm').find('#author').val();	
	 newBook["description"]= $('#bookCreationForm').find('#description').val();
	 $.ajax({
		type : "POST",
		contentType : "application/json",
		url : window.location.origin+"/api/book/add",
		data : JSON.stringify(newBook),
		dataType : 'json',
		success: function(result){
			$('.notiMsg').html("Thêm thành công"); 
		 },
	  error: function(e){      
	   alert('Error while request..'+e);
	  }
	 }); 
	 getBooksList();
	 
}

function censorshipBook(){
	$.ajax({
		type : "GET",
		url : window.location.origin+"/api/book/all",
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
						'<td>' + book.created_at + '</td>' +
						'<td>' + book.updated_at + '</td>' ;
					if(book.enabled == 1){
						bookRow += '<td><input type="checkbox" value="'+ book.enabled +'" checked onclick="enabled('+book.enabled+','+book.id+')"></td>';
					}else{
						bookRow += '<td><input type="checkbox" value="'+ book.enabled +'" onclick="enabled('+book.enabled+','+book.id+')"></td>';
					}
					bookRow += '<td><a title="Chi tiết" href="javascript:void(0)" onclick="getBookDetail('+book.id+')"> Xem</a>';
					
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

function enabled(st, id){
	$.ajax({
	  url: window.location.origin+"/api/book/enabled/"+id,
      type: 'POST',
      cache: false,
      data: {
        check : st
      },
	});	
}