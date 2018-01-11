package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.User;
 
public class UserDAO { 
  static Connection currentCon = null;
  static ResultSet rs = null; 
  static String sql = "";
  
  public static User isValid(String username, String password) {
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    sql = "select * from user where Username=? and Password=?";
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,username);
      ps.setString(2,password);
      rs = ps.executeQuery();
      if(rs != null && rs.next()){
        User user = new User(rs.getInt("UserId") , rs.getString("Username"),
            rs.getString("Password"),rs.getString("Role"),rs.getInt("Active"));
      return user;    
      }
      else {
        return null;
      }
      
    }catch(Exception ex) {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
    }
    return null;
  }
  public static User getUser(int id) {
    sql = "select * from user where UserId="+id;
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    User user = null;
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql); 
      while(rs.next()) {
        user = new User(rs.getInt("UserId") , rs.getString("Username"),
            rs.getString("Password"),rs.getString("Role"),rs.getInt("Active")); 
      }
      return user;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return null;
  }
  public static List<User> getAll(){
    sql = "select * from user";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    List<User> list = new ArrayList<User>();
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
        int userId = rs.getInt("UserId");
        String username = rs.getString("Username");
        String password = rs.getString("Password");
        String role = rs.getString("Role");
        int active = rs.getInt("Active");
        User user = new User(userId, username, password, role, active);
        list.add(user);
      }
      return list;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static void changeActive(int userId,int active) {
    sql = "update user set Active=? where UserId = "+userId;
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      if( active == 0) {
        ps.setInt(1, 1);
      }
      if( active == 1) {
        ps.setInt(1, 0);
      }
      ps.executeUpdate();
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
  }
  public static boolean checkActive(int userID) {
    return false;
  }
  public static void add(String username, String password,String role) {
    sql = "insert into user (Username,Password,Role) " + 
        "values(?,?,?)";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,username);
      ps.setString(2,password);
      ps.setString(3,role);
      ps.execute();
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
  }
  
  public static int getId(String username) {
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    sql = "select UserId from user where Username=?";
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,username);
      rs = ps.executeQuery();
      if(rs != null && rs.next()){
        return rs.getInt("UserId");   
      }
      else {
        return -1;
      }
      
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return -1;
  }
  public static int delete(int id) {
    sql = "delete from user where UserId = ?";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    int status = 0;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,Integer.toString(id));
      status = ps.executeUpdate();
      return status;
    }catch(SQLException ex) {
      System.out.println(ex);
      ex.printStackTrace();
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return status;
  }
  
  public static int editUserInfo(User user) {
    sql = "update user set Username=?, Password=?, Role=?, " + 
        "Active=? where UserId = "+user.getUserId();
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    int status = 0;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,user.getUsername());
      ps.setString(2,user.getPassword());
      ps.setString(3,user.getRole());
      ps.setString(4,Integer.toString(user.getActive()));
      status = ps.executeUpdate();
      return status;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return status;
  }
  
  public static int editInfo(int id,String username, String password) {
    sql = "update user set Username=?, Password=? where UserId = "+id;
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    int status = 0;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,username);
      ps.setString(2,password);
      status = ps.executeUpdate();
      return status;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return status;
  }
  
  public static boolean checkUsername(String username) {
    sql = "select * from user where Username='"+username+"'";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql); 
      while(rs.next()) {
        return true;
      }
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return false;
  }
  
  public static boolean changePassword(int id, String pass) {
    sql = "update user set Password=? where UserId = "+id;
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,pass);
      ps.executeUpdate();
      return true;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return false;
  }
}
