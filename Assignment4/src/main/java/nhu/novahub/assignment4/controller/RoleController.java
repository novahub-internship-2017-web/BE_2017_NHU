package nhu.novahub.assignment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.dao.RoleRepository;
import nhu.novahub.assignment4.entities.Role;

@RestController

public class RoleController {
  @Autowired
  RoleRepository roleRepository;
  
  @RequestMapping("/findall")
  public String findAll(){
    String result = "<html>";
      
    for(Role cust : roleRepository.findAll()){
        result += "<div>" + cust.toString() + "</div>";
    }
    return result + "</html>";
 }
}
