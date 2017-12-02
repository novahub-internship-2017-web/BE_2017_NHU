package week3;

import java.util.Scanner;

public class Teacher extends Person {

  Scanner input = new Scanner(System.in);
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
    this.setAllowance(degree);
  }
  
  public void setAllowance(String degree) {
    if(degree.equals("Cu nhan")) {
      this.allowance = 300;
    }
    if(degree.equals("Thac si")) {
      this.allowance = 900;
    }
    if(degree.equals("Tien si")) {
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
	  System.out.printf("%-10s %-15s %-7s %-7s %-7s",this.getFaculty(),this.getDegree(),
	            this.getAllowance(),this.getClassHours(),this.getCoefficientSalary());
  }
  
  @Override
  public void inputInfor() {
	  super.inputInfor();
	  System.out.print("Nhap khoa : ");
	  this.setFaculty(input.nextLine());
	  System.out.println("Chon trinh do : ");
	  System.out.println("\t1.Cu nhan 2.Thac si 3.Tien si");
	  int choose = input.nextInt();
    if(choose == 1) {
	    this.setDegree("Cu nhan");
	  }
	  else if(choose == 2) {
      this.setDegree("Thac si");
    }
	  else if(choose == 3) {
      this.setDegree("Tien si");
    }
	  System.out.print("Nhap so tiet day/thang : ");
	  this.setClassHours(input.nextInt());
	  System.out.print("Nhap he so luong : ");
	  this.setCoefficientSalary(input.nextFloat());
	  input.nextLine();
	  this.setAllowance(this.degree);
  }
  
  @Override
  public double getSalary() {
    double salary = this.coefficientSalary*730 + this.allowance + this.classHours*45;
    return salary;
  }
  
}

