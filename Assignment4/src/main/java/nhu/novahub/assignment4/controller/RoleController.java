package nhu.novahub.assignment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.dao.RoleDao;
import nhu.novahub.assignment4.entities.Role;

@RestController

public class RoleController {
  @Autowired
  RoleDao roleDao;
  
  @RequestMapping("/findall")
  public String findAll(){
    String result = "<html>";
      
    for(Role cust : roleDao.findAll()){
        result += "<div>" + cust.toString() + "</div>";
    }
    return result + "</html>";
}
}
