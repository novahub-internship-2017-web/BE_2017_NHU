package nhu.novahub.assignment4.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nhu.novahub.assignment4.entities.Role;




//@Repository
public interface RoleRepository  extends CrudRepository<Role , Long>{
  //public List<Role> findAll();
  @Query("select a.name from Role a, User b where b.email=?1 and a.id=b.role_id")
  public List<String> findRoleByEmail(String email);
  
  
}
