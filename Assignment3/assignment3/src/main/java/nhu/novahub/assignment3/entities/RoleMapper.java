package nhu.novahub.assignment3.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoleMapper implements RowMapper<Role>{
	
	  public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Role role = new Role();
		  role.setRoleId(rs.getInt("role_id"));
		  role.setRolename(rs.getString("rolename"));
		  return role;
	}
}