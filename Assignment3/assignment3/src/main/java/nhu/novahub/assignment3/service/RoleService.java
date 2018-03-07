package nhu.novahub.assignment3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment3.dao.RoleDAO;
import nhu.novahub.assignment3.entities.Role;


@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleDAO roleDAO;
	
	
	public Role findById(int id) {
		return roleDAO.findById(id);
	}
	
	public void changeRole(int id,String rolename) {
		roleDAO.changeRole(id, rolename);
	}
	
	public void delete(int id) {
		roleDAO.delete(id);
	}
	
	public void add(Role role) {
		roleDAO.add(role);
	}
}
