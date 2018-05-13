package nhu.novahub.assignment4.controller;

import java.security.Principal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.entities.Book;
import nhu.novahub.assignment4.entities.Response;
import nhu.novahub.assignment4.entities.User;
import nhu.novahub.assignment4.service.RoleService;
import nhu.novahub.assignment4.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  UserService userService;
  @Autowired
  RoleService roleService;
  
  Authentication authentication;
  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  
  Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @GetMapping("")
  public Response getAll(Pageable pageable) {
	Page<User> users = userService.findAll(pageable);
	Response response = new Response();
	if(users.hasContent()) {
		response.setData(users);
		response.setStatus("Có dữ liệu");
	}else {
	  response.setStatus("Dữ liệu trống");
	}
    return response;
  } 
  
  @GetMapping("/findByRole/user")
  public Response getUsersRoleUser(Pageable pageable) {
	Page<User> users = userService.findAllUser(pageable);
	Response response = new Response();
	if(users.hasContent()) {
		response.setData(users);
		response.setStatus("Có dữ liệu");
	}else {
	  response.setStatus("Dữ liệu trống");
	}
    return response;
  }
  
  @GetMapping("/findByRole/admin")
  public Response getUsersRoleAdmin(Pageable pageable) {
	Page<User> users = userService.findAllAdmin(pageable);
	Response response = new Response();
	if(users.hasContent()) {
		response.setData(users);
		response.setStatus("Có dữ liệu");
	}else {
	  response.setStatus("Dữ liệu trống");
	}
    return response;
  }
  
  @GetMapping("/email/{email}")
  public User getIdUser(@PathVariable(value = "email") String email) {
    return userService.findByEmail(email);
  }  
  
  @GetMapping("/id/{id}")
  public User getEmailUser(@PathVariable(value = "id") int id) {
    return userService.findById(id);
  }
  
  @GetMapping("/self")
  public User currentUserName( Principal principal) {
    try {
      String email = principal.getName();
      return userService.findByEmail(email);
    }catch(Exception e) {
      System.out.print(e);
      return null;
    }
}

  @PostMapping("/changePassword")
  public Response changePass(@RequestParam("oldPass") String oldPass,
                     @RequestParam("newPass") String newPass,
                     @RequestParam("confirmPass") String confirmPass) {
	  Response response = new Response();
    try {
      authentication = SecurityContextHolder.getContext().getAuthentication();
      User user =  userService.findByEmail(authentication.getName());
      String dbPass = user.getPassword();
      if(passwordEncoder.matches(oldPass, dbPass)) {
    	  if(newPass.equals(confirmPass)) {
    		user.setPassword(passwordEncoder.encode(newPass));
	        userService.updateUser(user);
	        response.setStatus("<b style=\"color:blue\">Cập nhật mật khẩu thành công</b>");
    	  }else {
    		  response.setStatus("<b style=\"color:red\">Mật khẩu xác nhận không khớp</b>");
    	  }
      }else {
    	  response.setStatus("<b style=\"color:red\">Mật khẩu cũ không chính xác</b>");
      }
    }catch(Exception e) {
		logger.error("Exception !", e);
		response.setStatus("Cập nhật mật khẩu thất bại");
    }
    return response;
  }
  
  // register and add new user
  @PostMapping("")
  public Response addBook(@RequestBody User user) {
	  Response response  = new Response();
	  if(!userService.existsByEmail(user.getEmail())) {
		  if(user.getPassword().equals(user.getConfirmPassword())) {
			  User newUser = new User();
			  newUser.setEmail(user.getEmail());
			  newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			  if(user.getRoleId() != 1 ) {
				  newUser.setRoleId(2); // role user
			  }else {
				  newUser.setRoleId(user.getRoleId());
			  }
			  newUser.setEnabled(1); //enabled
			  try{
				  userService.addUser(newUser);
				  response.setStatus("Bạn đã đăng kí thành công");
			  }catch(Exception e) {
				  e.printStackTrace();
				  response.setStatus("Lỗi! Không thêm được");
			  }
		  }else {
			  response.setStatus("Mật khẩu xác nhận không khớp");
		  }
	  }else {
		  response.setStatus("Email đã tồn tại");
	  }
	  return response;
  }
  
  @PostMapping("/enabled/{id}")
  public Response changeEnabled(@PathVariable(value = "id") int userId,@RequestParam int status) {
	  authentication = SecurityContextHolder.getContext().getAuthentication();
	  Response response  = new Response();
	  if(authentication.toString().contains("ROLE_ADMIN") || 
		 authentication.toString().contains("ROLE_SUPER_ADMIN") ) {
		  User currentUser = userService.findByEmail(authentication.getName());
		  if(userId == currentUser.getId()) {
			response.setStatus("Bạn không thể thay đổi hoạt động của mình");
		  }else {
			User user = userService.findById(userId);
			if(status == 1) {
	    		status = 0; //disabled
	    	}else {
	    		status = 1; //enabled
	    	}
			user.setEnabled(status);
			try {
				userService.updateUser(user);
				response.setStatus("Bạn vừa thay đổi hoạt động của người dùng");
				response.setData(userService.findById(userId));
			}catch(Exception e) {
				response.setStatus("Lỗi! Không thay đổi được quyền hoạt động");
			}
		  }
	  }else {
		  response.setStatus("Bạn không có quyền thay đổi");
	  }
	  return response;
  }
  
  
  @GetMapping("checkEmail/{email}")
  public Response checkEmail(@PathVariable(value = "email") String email) {
	  Response response  = new Response();
	  response.setData(userService.existsByEmail(email));
	  return response;
  }
}
