

function deleteBook(bookId){
	var confirmMsg = confirm("Bạn có muốn xóa không ?");
	if(confirmMsg == true){
		$.ajax({
			type : "DELETE",
			url : window.location.origin+"/api/book/delete/"+bookId,
			success: function(result){
				$('.notiMsg').html(result.status);
				setTimeout(function(){ $('.notiMsg').html("")}, 5000);
				displayBooks();
				 
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
	}
}

function getEmailUserById(id){
	var result = 'undefined';
	$.ajax({
		type : "GET",
		async: false,
		url : window.location.origin+"/api/user/profile/"+id,
		success: function(data){
			result =  data.email;
		},
		error : function(ex) {
			console.log("ERROR: ", ex);
		}
	});
	return result;
}



function loadBookDetail(bookId){
	window.history.pushState('string', '', window.location.origin+'/bookDetail/'+bookId);
	$.ajax({url:window.location.origin+'/bookDetailPage',success:function(result){
	      $("#otherContent").html(result);
	 }});
	
}

function loadBookForm(){
	$.ajax({url:window.location.origin+'/bookCreationPage',success:function(result){
	      $("#otherContent").html(result);
	    }});
}

function loadFormAddNewUser(){
	$.ajax({url:window.location.origin+'/userCreationPage',success:function(result){
	      $("#otherContent").html(result);
	    }});
}

function loadFormEditBook(bookId){
	window.history.pushState('string', '', window.location.origin+'/editBookForm/'+bookId);
	$.ajax({url:window.location.origin+'/bookEditionPage',success:function(result){
	      $("#otherContent").html(result);
	 }});
}

function loadUsersList(){
	$.ajax({url:window.location.origin+'/usersListPage',success:function(result){
	      $("#Content").html(result);
	    }});
}

function loadUserProfile(){
	$.ajax({url:window.location.origin+'/userProfilePage',success:function(result){
	      $("#otherContent").html(result);
	    }});
}


