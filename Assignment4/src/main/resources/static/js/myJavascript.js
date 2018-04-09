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

/*
 * */
$(document).ready(function() {
	var url = window.location.href;
	var rootUrl = window.location.origin;
	var home = window.location.origin+"/";
	var booksList = window.location.origin+"/booksList";
	var bookDetail = "";
	var check = url.search("bookDetail");
	if(check != -1){
		bookDetail = url;
	}
	switch(url) {
	    case home:
	    	$.ajax({url:window.location.origin+'/booksListPage',success:function(result){
	    	      $("#Content").html(result);
	    	    }});
	        break;
	    case booksList:
	    	$.ajax({url:window.location.origin+'/booksListPage',success:function(result){
	    	      $("#Content").html(result);
	    	    }});
	        break;
	    case bookDetail:
	        var bookId = bookDetail.substring(url.lastIndexOf('/') + 1);
	    	getBookDetail(bookId);
	        break;
	    default:
	    	alert("error");
	        break;
	} 
})

