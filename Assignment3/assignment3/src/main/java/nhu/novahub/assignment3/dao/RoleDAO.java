package nhu.novahub.assignment3.dao;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment3.entities.Role;
import nhu.novahub.assignment3.entities.RoleMapper;

@Repository
@Transactional
public class RoleDAO {
	  @Autowired
	  DataSource datasource;
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  
	  public Role findById(int id) {
		  String sql = "SELECT * FROM role WHERE role_id = '"+ id+"' ";
		  return jdbcTemplate.queryForObject(sql, new RoleMapper());
	  }
	  
	  public void changeRole(int id, String rolename) {
		  String sql = "UPDATE role SET rolename = '"+ rolename +"' WHERE role_id="+id;
		  jdbcTemplate.update(sql);
	  }
	  
	  public void delete(int id) {
		  String sql = "DELETE FROM role WHERE role_id="+id;
		  jdbcTemplate.update(sql);
	  }
	  
	  public void add(Role role) {
			String sql = "INSERT INTO role (role_id,rolename)"
			  		+ " values ('"+ role.getRoleId() +"','"+role.getRolename()+"')";
			jdbcTemplate.update(sql);
	  }
}
