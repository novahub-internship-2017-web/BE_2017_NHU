package nhu.novahub.assignment4.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.entities.Role;
import nhu.novahub.assignment4.service.RoleService;
import nhu.novahub.assignment4.service.UserService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
  @Autowired
  RoleService roleService;
  @Autowired
  UserService userService;
  
  @GetMapping("/{roleId}")
  public Role getIdUser(@PathVariable(value = "roleId") int roleId) {
    return roleService.findById(roleId);
  }
  
  
}
