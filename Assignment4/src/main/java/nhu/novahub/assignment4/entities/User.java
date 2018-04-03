package nhu.novahub.assignment4.entities;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table (name = "User")
public class User {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  @NotBlank
  private String email;

  @NotBlank
  private String password;
  
  @NotBlank
  private int enabled;
  
  @NotBlank
  private int role_id;
  public User(){

  }

  public User(User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.enabled = user.getEnabled();
    this.role_id = user.getRole_id();    
  }
  public int getId() {
  	return id;
  }
  
  public void setId(int id) {
  	this.id = id;
  }
  
  public String getEmail() {
  	return email;
  }
  
  public void setEmail(String email) {
  	this.email = email;
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
  
  public int getRole_id() {
  	return role_id;
  }
  
  public void setRole_id(int role_id) {
    this.role_id = role_id;
  }
}