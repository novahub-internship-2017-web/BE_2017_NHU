package nhu.novahub.assignment4.service;

import org.springframework.beans.factory.annotation.Autowired;
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
  
  public void updateUser(User user) {
    userRepository.save(user);
  }
}