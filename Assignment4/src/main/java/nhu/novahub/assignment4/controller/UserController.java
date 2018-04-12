package nhu.novahub.assignment4.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.dao.UserRepository;
import nhu.novahub.assignment4.entities.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  UserRepository userRepository;
  
  @GetMapping("/{email}")
  public User getIdUser(@PathVariable(value = "email") String email) {
    return userRepository.findByEmail(email);
  }  
  
  @GetMapping("/getCurrentUser")
  public User currentUserName( Principal principal) {
    try {
      String email = principal.getName();
      return userRepository.findByEmail(email);
    }catch(Exception e) {
      System.out.print(e);
      return null;
    }
  }
}
