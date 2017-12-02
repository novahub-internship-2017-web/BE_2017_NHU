package week3;

import java.util.Scanner;

public class Person {

  Scanner input = new Scanner(System.in);
  private String name;
  private int year;
  private String address;
  private String career;
  
  
  public Person() {
    
  }

  public Person(String name, int year, String address, String career) {
    this.name = name;
    this.year = year;
    this.address = address;
    this.career = career;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCareer(){
    return career;
  }
  
  public void setCareer(String career) {
    this.career = career;
  }

  public double getSalary() {
	  return 0;
  }
  
  
  
  public void printInfor() {
	  System.out.printf("%-15s %-8s %-10s %-4s ",
			  this.getName(), this.getYear(),this.getAddress(),this.getCareer());
  }
  
  public void inputInfor(){
	  	System.out.print("Nhap ten : ");
	    setName(input.nextLine());
	    System.out.print("Nhap nam sinh : ");
	    setYear(input.nextInt());
	    input.nextLine();
	    System.out.print("Nhap que quan : ");
	    setAddress(input.nextLine());
  }
  
}
