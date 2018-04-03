package nhu.novahub.assignment4.dao;

import org.springframework.data.repository.CrudRepository;

import nhu.novahub.assignment4.entities.User;

public interface UserRepository extends CrudRepository<User , Long>{
   
  public User findByEmail(String email);
}
