package Tuan3;

public class Employee extends Person{
  private String department;
  private String position;
  private int workDay;
  private double allowance;  
  private double coefficientSalary;
  
  public Employee(String name, int year, String address, double coefficientSalary, 
      String department, String position, int workDay) {
    super(name,year,address);
    this.coefficientSalary=coefficientSalary;
    this.position = position;
    this.workDay = workDay;
    this.department = department;
    this.setAllowance();
  }

  public void setAllowance() {
    if(this.getDepartment().equals("Truong phong")) {
      this.allowance = 1000;
    }
    if(this.getDepartment().equals("Pho phong")) {
      this.allowance = 600;
    }
    if(this.getDepartment().equals("Nhan vien")) {
      this.allowance = 400;
    }
  }
  
  public double getAllowance(){
    return allowance;
  }
  
  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getWorkDay() {
    return workDay;
  }

  public void setWorkDay(int workDay) {
    this.workDay = workDay;
  }
  
  public double getCoefficientSalary() {
    return coefficientSalary;
  }

  public void setCoefficientSalary(double coefficientSalary) {
    this.coefficientSalary = coefficientSalary;
  }
  
  public double getSalary() {
    double salary = this.coefficientSalary*730 + this.allowance + this.workDay*30;
    return salary;
  }
  
}
