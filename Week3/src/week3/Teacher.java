package week3;

import java.util.Scanner;

public class Teacher extends Person {
  
  private String faculty;
  private String degree;
  private int classHours;
  private double allowance;  
  private float coefficientSalary;
  
  public Teacher() {
    super();
    super.setCareer("GV");
  }
  
  public Teacher(String name, int year, String address, float coefficientSalary, 
      String faculty, String degree, int classHours) {
    super(name, year, address,"GV");
    this.coefficientSalary=coefficientSalary;
    this.faculty = faculty;
    this.degree = degree;
    this.classHours = classHours; 
    this.setAllowance();
  }
  
  public void setAllowance() {
    if(this.getDegree().equals("Cu nhan")) {
      this.allowance = 300;
    }
    if(this.getDegree().equals("Thac si")) {
      this.allowance = 900;
    }
    if(this.getDegree() == "Tien si") this.allowance = 2000.0;
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


  public int getClassHours() {
    return classHours;
  }


  public void setClassHours(int classHours) {
    this.classHours = classHours;
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
	  System.out.printf("%4s\t %15s\t %7s\t %5s\t %5s\t",this.getFaculty(),this.getDegree(),
	            this.getAllowance(),this.getClassHours(),this.getCoefficientSalary());
  }
  
  @Override
  public void inputInfor() {
	  Scanner input = new Scanner(System.in);
	  super.inputInfor();
	  System.out.print("Nhap khoa : ");
	  this.setFaculty(input.nextLine());
	  System.out.print("Nhap trinh do : ");
	  this.setDegree(input.nextLine());
	  System.out.print("Nhap so tiet day/thang : ");
	  this.setClassHours(input.nextInt());
	  System.out.print("Nhap he so luong : ");
	  this.setCoefficientSalary(input.nextFloat());
	  input.nextLine();
	  this.setAllowance();
  }
  @Override
  public double getSalary() {
    double salary = this.coefficientSalary*730 + this.allowance + this.classHours*45;
    return salary;
  }
  
}

