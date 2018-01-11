package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Staff;

public class StaffDAO {
  static Connection currentCon = null;
  static ResultSet rs = null;
  static String sql = "";
  
  public static List<Staff> getAll(){
    sql = "select * from staff";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    List<Staff> list = new ArrayList<Staff>();
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
        int staffId = rs.getInt("StaffId");
        String name = rs.getString("Name");
        int birthYear = rs.getInt("BirthYear");
        String country = rs.getString("Country");
        String department = rs.getString("Department");
        String position = rs.getString("Position");
        int workDays = rs.getInt("WorkDays");
        int allowance = rs.getInt("Allowance");
        float coefficientSalary = rs.getFloat("CoefficientSalary");
        Staff staff = new Staff(staffId, name, birthYear, country, department, position, workDays, allowance, coefficientSalary);
        list.add(staff);
      }
      return list;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static Staff getStaff(int id) {
    sql = "select * from staff where StaffId="+id;
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    Staff staff = null;
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
        int staffId = rs.getInt("StaffId");
        String name = rs.getString("Name");
        int birthYear = rs.getInt("BirthYear");
        String country = rs.getString("Country");
        String department = rs.getString("Department");
        String position = rs.getString("Position");
        int workDays = rs.getInt("WorkDays");
        int allowance = rs.getInt("Allowance");
        float coefficientSalary = rs.getFloat("CoefficientSalary");
        staff = new Staff(staffId, name, birthYear, country, department, position, workDays, allowance, coefficientSalary);     
      }
      return staff;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
  }
  return null;
  }
  
  public static int editStaffInfo(Staff staff) {
    sql = "update staff set Name=?, BirthYear=?, Country=?, " + 
        "Department=?, Position=?,WorkDays=?, " + 
        "Allowance=?,CoefficientSalary=?   where StaffId = "+staff.getStaffId();
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    int status = 0;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,staff.getName());
      ps.setString(2,Integer.toString(staff.getBirthYear()));
      ps.setString(3,staff.getCountry());
      ps.setString(4,staff.getDepartment());
      ps.setString(5,staff.getPosition());
      ps.setString(6,Integer.toString(staff.getWorkDays()));
      ps.setString(7,Integer.toString(staff.getAllowance()));
      ps.setString(8,Float.toString(staff.getCoefficientSalary()));
      status = ps.executeUpdate();
      return status;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return status;
  }
  
  public static int add(Staff staff) {
    sql = "insert into staff (StaffId,Name,BirthYear,Country,Department,Position,WorkDays,Allowance,CoefficientSalary) " + 
        "values(?,?,?,?,?,?,?,?,?)";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    int status = 0;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,Integer.toString(staff.getStaffId()));
      ps.setString(2,staff.getName());
      ps.setString(3,Integer.toString(staff.getBirthYear()));
      ps.setString(4,staff.getCountry());
      ps.setString(5,staff.getDepartment());
      ps.setString(6,staff.getPosition());
      ps.setString(7,Integer.toString(staff.getWorkDays()));
      ps.setString(8,Integer.toString(staff.getAllowance()));
      ps.setString(9,Float.toString(staff.getCoefficientSalary()));
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
  
  public static int delete(int id) {
    sql = "delete from staff where StaffId = ?";
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
  
  public static boolean isValid(int id) {
    sql = "select * from staff where StaffId=?";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,Integer.toString(id));
      rs = ps.executeQuery();
      if(rs != null && rs.next()){
        return true;  
      }else return false;  
        
      
    }catch(SQLException ex) {
      System.out.println(ex);
      ex.printStackTrace();
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return false;
  }
  
  public static List<Staff> searchBy(String field,String keyword){
    sql = "select * from staff where "+field+" like '%"+ keyword +"%'";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    List<Staff> list = new ArrayList<Staff>();
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
        int staffId = rs.getInt("StaffId");
        String name = rs.getString("Name");
        int birthYear = rs.getInt("BirthYear");
        String country = rs.getString("Country");
        String department = rs.getString("Department");
        String position = rs.getString("Position");
        int workDays = rs.getInt("WorkDays");
        int allowance = rs.getInt("Allowance");
        float coefficientSalary = rs.getFloat("CoefficientSalary");
        Staff staff = new Staff(staffId, name, birthYear, country, department, position, workDays, allowance, coefficientSalary);
        list.add(staff);
      }
      return list;
    }catch(SQLException ex) {
      System.out.println(ex);
      ex.printStackTrace();
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return null;
  }
}
