
function validateEditUser()
{ 
 var username = document.form.username.value;
 var password = document.form.password.value;
 
 if (username==null || username=="")
 { 
 alert("Username không được để trống"); 
 return false; 
 }
 else if (password==null || password=="")
 { 
 alert("Password không được để trống"); 
 return false; 
 }
 else if (isNaN(password))
 { 
 alert("Password phải là số"); 
 return false; 
 }
 } 