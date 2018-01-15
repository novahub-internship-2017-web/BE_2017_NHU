package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  private static ConnectionManager  instance  = null;
  private Connection conn  = null;
  
  private ConnectionManager() {
    super();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/assignment2?autoReconnect=true&useSSL=false", "root", "root");
      
    } catch (Exception ex) {
      System.out.println("Database.getConnection() Error -->"
          + ex.getMessage());
      ex.printStackTrace();
         }
  }
  
  public static ConnectionManager getInstance(){
    try {
      if (instance == null || instance.getConnection().isClosed()) {

        instance = new ConnectionManager();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return instance;
  }

  public Connection getConnection() {
    return conn;
  }
  
  public static void close(Connection con) {
    try {
      con.close();
    } catch (Exception ex) {
    }
}
}

