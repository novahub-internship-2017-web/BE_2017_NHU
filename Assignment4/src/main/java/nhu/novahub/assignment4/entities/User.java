package nhu.novahub.assignment4.entities;


import javax.persistence.*;


@Entity
@Table (name = "User")
public class User {
	
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;
  
  @Column(name = "enabled")
  private int enabled;
  
  @Column(name = "role_id")
  private int roleId;
  
  public User(){

  }

  public User(User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.enabled = user.getEnabled();
    this.roleId = user.getRoleId();    
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
  
  public int getRoleId() {
  	return roleId;
  }
  
  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }
}
