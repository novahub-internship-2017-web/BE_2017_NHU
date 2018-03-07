package nhu.novahub.assignment3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment3.dao.UserDAO;
import nhu.novahub.assignment3.entities.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public User checkExist(User user) {
		return userDAO.checkExist(user);
	}
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
	
	public void changePassword(int id,String password) {
		userDAO.changePassword(id, password);
	}
	
	public List<User> findAll(){
		return userDAO.findAll();
	}
	
	public List<User> findAllUser(){
		return userDAO.findAllUser();
	}
	
	public void changeEnabled(int id,int enabled) {
		userDAO.changeEnabled(id, enabled);
	}
	
	public void deleteById(int id) {
		userDAO.deleteById(id);
	}
	
	public void add(User user) {
		userDAO.add(user);
	}
	
	public User findById(int id) {
		return userDAO.findById(id);
	}
	
}
