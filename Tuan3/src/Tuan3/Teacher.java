package Tuan3;

public class Teacher extends Person {
  
  private String faculty;
  private String degree;
  private int lesson;
  private double allowance;  
  private double coefficientSalary;
  
  public Teacher(String name, int year, String address, double coefficientSalary, 
      String faculty, String degree, int lesson) {
    super(name, year, address);
    this.coefficientSalary=coefficientSalary;
    this.faculty = faculty;
    this.degree = degree;
    this.lesson = lesson; 
  }
  
  public void setAllowance() {
    if(this.getDegree().equals("Cu nhan")) {
      this.allowance = 300;
    }
    if(this.getDegree().equals("Thac si")) {
      this.allowance = 900;
    }
    if(this.getDegree().equals("Tien si")) {
      this.allowance = 2000;
    }
  }
  
  public double getAllowance(){
    return allowance;
  }
  public String getFaculty() {
    return faculty;
  }


  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }


  public String getDegree() {
    return degree;
  }


  public void setDegree(String degree) {
    this.degree = degree;
  }


  public int getLesson() {
    return lesson;
  }


  public void setLesson(int lesson) {
    this.lesson = lesson;
  }
  public double getCoefficientSalary() {
    return coefficientSalary;
  }

  public void setCoefficientSalary(double coefficientSalary) {
    this.coefficientSalary = coefficientSalary;
  }
  public double getSalary() {
    double salary = this.coefficientSalary*730 + this.allowance + this.lesson*45;
    return salary;
  }
  
}
