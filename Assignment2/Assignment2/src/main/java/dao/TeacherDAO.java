package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entities.Teacher;

public class TeacherDAO {
  static Connection currentCon = null;
  static ResultSet rs = null;
  static String sql = "";
  
  public static List<Teacher> getAll(){
    sql = "select * from teacher";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    List<Teacher> list = new ArrayList<Teacher>();
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
        int teacherId = rs.getInt("TeacherId");
        String name = rs.getString("Name");
        int birthYear = rs.getInt("BirthYear");
        String country = rs.getString("Country");
        String faculty = rs.getString("Faculty");
        String degree = rs.getString("Degree");
        int classHours = rs.getInt("ClassHours");
        int allowance = rs.getInt("Allowance");
        float coefficientSalary = rs.getFloat("CoefficientSalary");
        Teacher teacher = new Teacher(teacherId, name, birthYear, country, 
            faculty, degree, classHours, allowance, coefficientSalary);
        list.add(teacher);
      }
      return list;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static int add(Teacher teacher) {
    sql = "insert into teacher "+
        "(TeacherId,Name,BirthYear,Country,Faculty,Degree,ClassHours,Allowance,CoefficientSalary) " + 
        "values(?,?,?,?,?,?,?,?,?)";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    int status = 0;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,Integer.toString(teacher.getTeacherId()));
      ps.setString(2,teacher.getName());
      ps.setString(3,Integer.toString(teacher.getBirthYear()));
      ps.setString(4,teacher.getCountry());
      ps.setString(5,teacher.getFaculty());
      ps.setString(6,teacher.getDegree());
      ps.setString(7,Integer.toString(teacher.getClassHours()));
      ps.setString(8,Integer.toString(teacher.getAllowance()));
      ps.setString(9,Float.toString(teacher.getCoefficientSalary()));
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
  
  public static Teacher getTeacher(int id) {
    sql = "select * from teacher where TeacherId="+id;
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    Teacher teacher = null;
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
        int teacherId = rs.getInt("TeacherId");
        String name = rs.getString("Name");
        int birthYear = rs.getInt("BirthYear");
        String country = rs.getString("Country");
        String faculty = rs.getString("Faculty");
        String degree = rs.getString("Degree");
        int classHours = rs.getInt("ClassHours");
        int allowance = rs.getInt("Allowance");
        float coefficientSalary = rs.getFloat("CoefficientSalary");
        teacher = new Teacher(teacherId, name, birthYear, country, faculty, degree, classHours, allowance, coefficientSalary);
      }
      return teacher;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
  }
  return null;
  }
  
  public static int editStaffInfo(Teacher teacher) {
    sql = "update teacher set Name=?, BirthYear=?, Country=?, " + 
        "Faculty=?, Degree=?,ClassHours=?, " + 
        "Allowance=?,CoefficientSalary=?   where TeacherId = "+teacher.getTeacherId();
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    PreparedStatement ps = null;
    int status = 0;
    try {
      currentCon = connectionManager.getConnection();
      ps = currentCon.prepareStatement(sql);
      ps.setString(1,teacher.getName());
      ps.setString(2,Integer.toString(teacher.getBirthYear()));
      ps.setString(3,teacher.getCountry());
      ps.setString(4,teacher.getFaculty());
      ps.setString(5,teacher.getDegree());
      ps.setString(6,Integer.toString(teacher.getClassHours()));
      ps.setString(7,Integer.toString(teacher.getAllowance()));
      ps.setString(8,Float.toString(teacher.getCoefficientSalary()));
      status = ps.executeUpdate();
      return status;
    }catch(SQLException ex) {
      System.out.println(ex);
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return status;
  }
  
  public static boolean isValid(int id) {
    sql = "select * from teacher where TeacherId=?";
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
  
  public static int delete(int id) {
    sql = "delete from teacher where TeacherId = ?";
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
  
  public static List<Teacher> searchBy(String field,String keyword){
    sql = "select * from teacher where "+field+" like '%"+ keyword +"%'";
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Statement stmt = null;
    List<Teacher> listTeacher = new ArrayList<Teacher>();
    try {
      currentCon = connectionManager.getConnection();
      stmt = currentCon.createStatement( );
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
        int teacherId = rs.getInt("TeacherId");
        String name = rs.getString("Name");
        int birthYear = rs.getInt("BirthYear");
        String country = rs.getString("Country");
        String faculty = rs.getString("Faculty");
        String degree = rs.getString("Degree");
        int classHours = rs.getInt("ClassHours");
        int allowance = rs.getInt("Allowance");
        float coefficientSalary = rs.getFloat("CoefficientSalary");
        Teacher teacher = new Teacher(teacherId, name, birthYear, country, 
            faculty, degree, classHours, allowance, coefficientSalary);
        listTeacher.add(teacher);
      }
      return listTeacher;
    }catch(SQLException ex) {
      System.out.println(ex);
      ex.printStackTrace();
    }catch(NullPointerException e) {
      e.printStackTrace();
    }
    return null;
  }
}
