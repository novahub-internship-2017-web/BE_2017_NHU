package nhu.novahub.assignment4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.entities.Response;
import nhu.novahub.assignment4.entities.Role;
import nhu.novahub.assignment4.entities.User;
import nhu.novahub.assignment4.service.RoleService;
import nhu.novahub.assignment4.service.UserService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
  @Autowired
  RoleService roleService;
  @Autowired
  UserService userService;
  
  Authentication authentication;
  @GetMapping("/{roleId}")
  public Role getIdUser(@PathVariable(value = "roleId") int roleId) {
    return roleService.findById(roleId);
  }
  
  @PostMapping("/change/{id}")
  public Response changeEnabled(@PathVariable(value = "id") int userId,@RequestParam int roleId) {
	  authentication = SecurityContextHolder.getContext().getAuthentication();
	  Response response  = new Response();
	  if( authentication.toString().contains("ROLE_SUPER_ADMIN") ) {
		  User currentUser = userService.findByEmail(authentication.getName());
		  if(userId == currentUser.getId()) {
			response.setStatus("Bạn không thể thay đổi quyền truy cập của mình");
		  }else {
			User user = userService.findById(userId);
			if(roleId == 1) {
				roleId = 2; //user
	    	}else {
	    		roleId = 1; //admin
	    	}
			user.setRoleId(roleId);
			try {
				userService.updateUser(user);
				response.setStatus("Bạn vừa thay đổi quyền truy cập của người dùng");
				response.setData(userService.findById(userId));
			}catch(Exception e) {
				response.setStatus("Lỗi! Không thay đổi được quyền truy cập");
			}
		  }
	  }else {
		  response.setStatus("Bạn không có quyền thay đổi");
	  }
	  return response;
  }
}
