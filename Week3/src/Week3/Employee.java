package Week3;

public class Employee extends Person{
  private String department;
  private String position;
  private int workDays;
  private double allowance;  
  private float coefficientSalary;
  
  public Employee(){
    super();
    super.setCareer("NV");
  }
  
  public Employee(String name, int year, String address, float coefficientSalary, 
      String department, String position, int workDays) {
    super(name,year,address,"NV");
    this.coefficientSalary=coefficientSalary;
    this.position = position;
    this.workDays = workDays;
    this.department = department;
    this.setAllowance();
  }

  public void setAllowance() {
    if(this.getPosition().equals("Truong phong")) {
      this.allowance = 1000;
    }
    if(this.getPosition().equals("Pho phong")) {
      this.allowance = 600;
    }
    if(this.getPosition().equals("Nhan vien")) {
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

  public int getWorkDays() {
    return workDays;
  }

  public void setWorkDays(int workDays) {
    this.workDays = workDays;
  }
  
  public float getCoefficientSalary() {
    return coefficientSalary;
  }

  public void setCoefficientSalary(float coefficientSalary) {
    this.coefficientSalary = coefficientSalary;
  }
  
  @Override
  public void printInfor() {
	  super.printInfor();
	  System.out.printf("%4s\t %15s\t %7s\t %5s\t %5s\t",this.getDepartment(),this.getPosition(),
	            this.getAllowance(),this.getWorkDays(),this.getCoefficientSalary());
  }
  
  @Override
  public double getSalary() {
    double salary = this.coefficientSalary*730.0 + this.allowance + this.workDays*30.0;
    return salary;
  }
  
}
