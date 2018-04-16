package nhu.novahub.assignment4.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nhu.novahub.assignment4.entities.Role;


public interface RoleRepository  extends CrudRepository<Role , Long>{
  
  @Query("select a.name from Role a, User b where b.email=?1 and a.id=b.roleId")
  public List<String> findRoleByEmail(String email);
  
  public Role findById(int id);
  
  public List<Role> findAll();
} 
