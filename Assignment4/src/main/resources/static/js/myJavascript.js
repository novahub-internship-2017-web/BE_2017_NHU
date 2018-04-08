/*$(document).ready(function() {
	$.ajax({url:"header",success:function(result){
	      $("#header-part").html(result);
	    }});
})*/
function getBookDetail(bookId){
		//document.getElementById('formAddBook').style.display='block';
		/*document.getElementById('Content').style.display='none';
		document.getElementById('bookDetail').style.display='block';*/
		$.ajax({url:"bookDetail",success:function(result){
	      $("#Content").html(result);
	    }});
		$.ajax({
			type : "GET",
			url : "api/book/"+bookId,
			success: function(result){/*
					$('input[name="title"]').val(result.title);
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