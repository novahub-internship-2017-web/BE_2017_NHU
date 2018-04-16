package nhu.novahub.assignment4.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nhu.novahub.assignment4.entities.User;

public interface UserRepository extends CrudRepository<User , Long>{
   
  public User findByEmail(String email);
  
  public User findById(int id);
  
  public List<User> findAll();
  
}
