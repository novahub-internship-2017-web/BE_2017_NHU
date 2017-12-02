package week3;

import java.util.Scanner;

public class Employee extends Person{

  Scanner input = new Scanner(System.in);
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
    this.setAllowance(position);
  }

  public void setAllowance(String position) {
    if(position.equals("Truong phong")) {
      this.allowance = 1000;
    }
    if(position.equals("Pho phong")) {
      this.allowance = 600;
    }
    if(position.equals("Nhan vien")) {
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
	  System.out.printf("%-10s %-15s %-7s %-7s %-7s",this.getDepartment(),this.getPosition(),
	            this.getAllowance(),this.getWorkDays(),this.getCoefficientSalary());
  }
  @Override
  public void inputInfor() {
	  super.inputInfor();
	  System.out.print("Nhap phong ban : ");
	  this.setDepartment(input.nextLine());
	  System.out.println("Chon chuc vu : ");
    System.out.println("\t1.Nhan vien  2.Pho phong  3.Truong phong");
    int choose = input.nextInt();
    if(choose == 1) {
      this.setPosition("Nhan vien");
    }
    else if(choose == 2) {
      this.setPosition("Pho phong");
    }
    else if(choose == 3) {
      this.setPosition("Truong phong");
    }
	  System.out.print("Nhap so ngay cong : ");
	  this.setWorkDays(input.nextInt());
	  System.out.print("Nhap he so luong : ");
	  this.setCoefficientSalary(input.nextFloat());
	  
	  this.setAllowance(this.position);
  }
  @Override
  public double getSalary() {
    double salary = this.coefficientSalary*730.0 + this.allowance + this.workDays*30.0;
    return salary;
  }
  
}
