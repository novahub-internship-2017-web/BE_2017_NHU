package nhu.novahub.assignment4.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import nhu.novahub.assignment4.entities.User;
import nhu.novahub.assignment4.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  UserService userService;
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @GetMapping("/{email}")
  public User getIdUser(@PathVariable(value = "email") String email) {
    return userService.findByEmail(email);
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
}
