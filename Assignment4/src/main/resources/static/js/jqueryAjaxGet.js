$(document).ready(function() {
	ajaxGet();
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : "api/book/all",
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
							'<td>' + book.created_at + '</td>' +
							'<td>' + book.updated_at + '</td>' +
							'<td><a title="Chi tiết" href="javascript:void(0)" onclick="getBookDetail('+book.id+')"> Xem</a> </td>' +
						  '</tr>';
						
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
	
	
	
})
function getBookDetail(bookId){
		//document.getElementById('formAddBook').style.display='block';
		document.getElementById('Content').style.display='none';
		document.getElementById('bookDetail').style.display='block';
		$.ajax({
			type : "GET",
			url : "api/book/"+bookId,
			success: function(result){
					/*$('input[name="title"]').val(result.title);
					$('input[name="author"]').val(result.author);
					$('input[name="id"]').val(result.id);*/
					$('.tableDetailBook').find('#title').html(result.title);
					$('.tableDetailBook').find('td#author').html(result.author);
					$('.tableDetailBook').find('td#created_at').html(result.created_at);
					$('.tableDetailBook').find('td#updated_at').html(result.updated_at);
					$('.tableDetailBook').find('td#description').html(result.description);
			},
			error : function(ex) {
				alert("ERROR: ", ex);
				console.log("ERROR: ", ex);
			}
		});	
	}