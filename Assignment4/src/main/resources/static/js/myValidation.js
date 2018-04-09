function validateFormBook(){
	var validator = $("#formBook").validate({
    rules: {
    	title: "required",
    	author: "required",
    },
    messages: {
    	title:"Tiêu đề không được trống",
    	author: " Tác giả không được trống"
    }
});
}


