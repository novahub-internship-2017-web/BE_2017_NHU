package nhu.novahub.assignment3.entities;


import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	private int id;
	@NotBlank(message = "Username may not be null")
	private String username;
	@NotBlank(message = "Password may not be null")
	private String password;
	private int enabled;
	private String role;
	
	public User() {
		
	}
	
	public User(String username,String password) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
