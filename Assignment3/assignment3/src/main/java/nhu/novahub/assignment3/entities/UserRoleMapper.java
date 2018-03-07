package nhu.novahub.assignment3.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRoleMapper implements RowMapper<User>{
	
	  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		  User user = new User();
		  	user.setId(rs.getInt("id"));
		  	user.setUsername(rs.getString("username"));
		  	user.setPassword(rs.getString("password"));
		  	user.setEnabled(rs.getInt("enabled"));
		  	user.setRole(rs.getString("rolename"));
		    return user;
		  }
}