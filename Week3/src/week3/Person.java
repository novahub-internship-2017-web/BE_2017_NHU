package week3;

import java.util.Calendar;
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
	    boolean check = false;
	    do {
      System.out.print("Nhap nam sinh : ");
      try {
        year = Integer.parseInt(input.nextLine());
        if(year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)-18) {
          System.out.println("Nam sinh khong hop le, moi nhap lai");
          check = false;
        }
        else {
          check = true;
        }
      }
      catch(Exception e) {
        System.out.println("Ban phai nhap so");
      }
	    }while(!check);
      System.out.print("Nhap que quan : ");
      setAddress(input.nextLine());
  }
  
  public void editInfor() {
    String string="";
    System.out.println("-----------------------------");
    System.out.println("Loai can bo : "+this.career);
    System.out.println("Ten hien tai: "+this.name);
    System.out.println("Sua ten (Khong sua -> enter) : ");
    string = input.nextLine();
    if(!string.equals("")) {
      setName(input.nextLine());
    }
    System.out.println("Nam sinh hien tai : "+this.year);
    System.out.println("Sua nam sinh (Khong sua -> enter) : ");
    boolean check = false;
    do {
      string = input.nextLine();
      if(!string.equals("")) {
        try {
          year = Integer.parseInt(string);
          if(year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)-18) {
            System.out.println("Nam sinh khong hop le, moi nhap lai : ");
            check = false;
          }
          else {
            check = true;
          }
        }
        catch(Exception e) {
          System.out.println("Ban phai nhap so, nhap lai : ");
        }
      }
      else {
        check=true;
      }
    }while(!check);
    System.out.println("Que quan hien tai : "+this.address);
    System.out.println("Sua que quan (Khong sua -> enter): ");
    string = input.nextLine();
    if(!string.equals("")) {
      setAddress(string);
    }
  }
  
}
