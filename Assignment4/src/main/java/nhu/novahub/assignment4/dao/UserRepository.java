package nhu.novahub.assignment4.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nhu.novahub.assignment4.entities.User;

public interface UserRepository extends CrudRepository<User , Long>{
   
  public User findByEmail(String email);
  
  public User findById(int id);
  
  @Query("select u from User u where u.roleId=1 or u.roleId=2")
  public Page<User> findAll(Pageable pageable);
  
  
  @Query("select u from User u where u.roleId=2")
  public Page<User> findAllUser(Pageable pageable);
  
  @Query("select u from User u where u.roleId=1")
  public Page<User> findAllAdmin(Pageable pageable);
  
  public boolean existsByEmail(String email);
  
}
