package nhu.novahub.assignment4.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nhu.novahub.assignment4.entities.Role;




//@Repository
public interface RoleDao  extends CrudRepository<Role , Long>{
  List<Role> findAll();
}
