package nhu.novahub.assignment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment4.dao.RoleRepository;
import nhu.novahub.assignment4.entities.Role;

@Service
@Transactional
public class RoleService{
  @Autowired
  RoleRepository roleRepository; 
  
  public String findById(int id) {
    Role role = roleRepository.findById(id);
    return role.getName();
  }
  
  public List<Role> findAll(){
    return roleRepository.findAll();
  }
}