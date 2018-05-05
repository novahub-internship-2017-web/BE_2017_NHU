package nhu.novahub.assignment4.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment4.dao.UserRepository;
import nhu.novahub.assignment4.entities.User;

@Service
@Transactional
public class UserService{
  @Autowired
  UserRepository userRepository; 
  
  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }
  
  public User findById(int id) {
    return userRepository.findById(id);
  }
  
  public void updateUser(User user) {
    userRepository.save(user);
  }
  
  public void addUser(User user) {
	    userRepository.save(user);
  }
  
  public Page<User> findAll(Pageable pageable){
    return userRepository.findAll(pageable);
  }
  
  public Page<User> findAllUser(Pageable pageable){
    return userRepository.findAllUser(pageable);
  }
  
  public Page<User> findAllAdmin(Pageable pageable){
    return userRepository.findAllAdmin(pageable);
  }
  
  public boolean existsByEmail(String email) {
	  return userRepository.existsByEmail(email);
  }
}