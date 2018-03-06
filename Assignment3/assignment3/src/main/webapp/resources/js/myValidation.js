function validateBookCreation(){
	var validator = $("#validateBookCreation").validate({
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