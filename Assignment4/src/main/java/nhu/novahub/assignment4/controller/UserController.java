package nhu.novahub.assignment4.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import nhu.novahub.assignment4.entities.User;
import nhu.novahub.assignment4.service.RoleService;
import nhu.novahub.assignment4.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  UserService userService;
  @Autowired
  RoleService roleService;
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @GetMapping("/all")
  public List<User> usersList() {
    return userService.findAll();
  } 
  
  @GetMapping("/{email}")
  public User getIdUser(@PathVariable(value = "email") String email) {
    return userService.findByEmail(email);
  }  
  
  @GetMapping("/profile/{id}")
  public User getEmailUser(@PathVariable(value = "id") int id) {
    return userService.findById(id);
  }
  
  @GetMapping("/getCurrentUser")
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
  public User changePass( Principal principal,@RequestParam("oldPass") String oldPass,
                     @RequestParam("newPass") String newPass,
                     @RequestParam("confirmPass") String confirmPass) {
    try {
      String email = principal.getName();
      User user = userService.findByEmail(email);
      if(passwordEncoder.matches(oldPass, user.getPassword()) && newPass.equals(confirmPass)) {
        user.setPassword(passwordEncoder.encode(newPass));
        userService.updateUser(user);
      }
      return userService.findByEmail(email);
    }catch(Exception e) {
      System.out.print(e);
      return null;
    }
  }
  
  @PostMapping("/enabled/{id}")
  public void changeEnabled(@PathVariable(value = "id") int userId,@RequestParam int status,
            Principal principal) {
    User currentUser =  userService.findByEmail(principal.getName());
    String currentUserRole = roleService.findById(currentUser.getId());
    if(currentUserRole.contains("ADMIN")) {
      if(status == 1) { 
        status = 0; // disabled
      }else {
        status = 1; // enabled
      }
      User user = userService.findById(userId);
      user.setEnabled(status);
      userService.updateUser(user);
    }
  }
}
