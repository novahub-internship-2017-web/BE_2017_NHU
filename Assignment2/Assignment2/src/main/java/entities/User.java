package entities;

public class User {
  private int userId;
  private String username;
  private String password;
  private String role;
  private int active;
  
  public User() {
    super();
  }
  public User(int userId,String username,String password,String role,int active) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.role = role;
    this.active = active;
  }
  public int getUserId() {
    return userId;
  }
  public void setUserId(int userId) {
    this.userId = userId;
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
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  public int getActive() {
    return active;
  }
  public void setActive(int active) {
    this.active = active;
  }
  
  
  
}
