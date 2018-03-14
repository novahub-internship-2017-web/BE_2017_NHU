package nhu.novahub.assignment3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment3.entities.User;
import nhu.novahub.assignment3.entities.UserMapper;
import nhu.novahub.assignment3.entities.UserRoleMapper;

@Repository
@Transactional
public class UserDAO {
	  @Autowired
	  DataSource datasource;
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  
	  public User checkExist(User user) {
		  String sql = "SELECT * FROM user WHERE username ='"+ user.getUsername()+"' "
		  		+ "and password = '"+ user.getPassword() +"'";
		  return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
				  
			  @Override
			  public User extractData(ResultSet rs) throws SQLException,
			  			DataAccessException {
	              if (rs.next()) {
	                  User user = new User();
	                  user.setId(rs.getInt("id"));
	                  user.setUsername(rs.getString("username"));
	                  user.setPassword(rs.getString("password"));
	                  user.setEnabled(rs.getInt("enabled"));
	                  return user;
	              }
	              return null;
			  }

		  });
	  }
	  
	  public void changePassword(int id, String password) {
		  String sql = "UPDATE user SET password = '"+ password+"' WHERE id="+id;
		  jdbcTemplate.update(sql);
	  }
	  
	  public User findById(int id) {
		  String sql = "SELECT * FROM user WHERE id = '"+ id +"' ";
		  try {
			  return jdbcTemplate.queryForObject(sql, new UserMapper());
		  }
		  catch (EmptyResultDataAccessException ex) {
			  return null;
		  }
		  
	  }
	  
	  public User findByUsername(String username) {
		  String sql = "SELECT * FROM user WHERE username = '"+ username+"' ";
		  try {
			  return jdbcTemplate.queryForObject(sql, new UserMapper());
		  }
		  catch (EmptyResultDataAccessException ex) {
			  return null;
		  }
		  
	  }
	  /*public User findByUsername(String username) {
		  String sql = "SELECT * FROM user WHERE username ='"+ username+"' ";
			  return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
					  
				  @Override
				  public User extractData(ResultSet rs) throws SQLException,
				  			DataAccessException {
		              if (rs.next()) {
		                  User user = new User();
		                  user.setId(rs.getInt("id"));
		                  user.setUsername(rs.getString("username"));
		                  user.setPassword(rs.getString("password"));
		                  return user;
		              }
		              return null;
				  }

			  });
	  }*/
	  
	  public List<User> findAll(){
		  String sql = "SELECT u.id,u.username,u.password,u.enabled,r.rolename FROM user u\n" + 
		  		"JOIN role r ON u.id = r.role_id WHERE r.rolename NOT LIKE 'admin_default'";
		  return jdbcTemplate.query(sql, new UserRoleMapper());
	  }
	  
	  public List<User> findAllUser(){
		  String sql = "SELECT u.id,u.username,u.password,u.enabled,r.rolename FROM user u\n" + 
		  		"JOIN role r ON u.id = r.role_id WHERE r.rolename = 'user'";
		  return jdbcTemplate.query(sql, new UserRoleMapper());
	  }
	  
	  public void changeEnabled(int id,int enabled) {
		  String sql = "UPDATE user SET enabled = '"+ enabled+"' WHERE id="+id;
		  jdbcTemplate.update(sql);
	  }
	  
	  public void deleteById(int id) {
		  String sql = "DELETE FROM user WHERE id="+id;
		  jdbcTemplate.update(sql);
	  }
	  
	  public void add(User user) {
			String sql = "INSERT INTO user (username,password)"
			  		+ " values ('"+ user.getUsername() +"','"+user.getPassword()+"')";
			jdbcTemplate.update(sql);
	  }
}
