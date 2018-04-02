package nhu.novahub.assignment4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.dao.RoleRepository;
import nhu.novahub.assignment4.dao.UserRepository;
import nhu.novahub.assignment4.entities.User;

@RestController
public class UserController {
  @Autowired
  UserRepository userRepository;
  
  /*@RequestMapping("/findall")
  public String findAll(){
    String result = "<html>";
      
    for(User cust : userRepository.findAll()){
        result += "<div>" + cust.toString() + "</div>";
    }
    return result + "</html>";
}*/
}
