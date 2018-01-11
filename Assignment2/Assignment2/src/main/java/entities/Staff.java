package entities;

public class Staff {
  private int staffId;
  private String name;
  private int birthYear;
  private String country;
  private String department;
  private String position;
  private int workDays;
  private int allowance;
  private float coefficientSalary;
  private String career = "NV";
  
  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }

  public Staff(int staffId,String name,int birthYear,String country,String department,
      String position,int workDays,int allowance,float coefficientSalary) {
    this.staffId = staffId;
    this.name = name;
    this.birthYear = birthYear;
    this.country = country;
    this.department = department;
    this.position = position;
    this.workDays = workDays;
    this.allowance = allowance;
    this.coefficientSalary = coefficientSalary;
    
  }
  
  public int getStaffId() {
    return staffId;
  }
  public void setStaffId(int staffId) {
    this.staffId = staffId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getBirthYear() {
    return birthYear;
  }
  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
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
  public int getAllowance() {
    return allowance;
  }
  public void setAllowance(int allowance) {
    this.allowance = allowance;
  }
  public float getCoefficientSalary() {
    return coefficientSalary;
  }
  public void setCoefficientSalary(float coefficientSalary) {
    this.coefficientSalary = coefficientSalary;
  }
  
  
}
