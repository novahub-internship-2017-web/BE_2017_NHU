package Tuan3;

public class Person {
  private String name;
  private int year;
  private String address;
  
  

  public Person(String name, int year, String address) {
    this.name = name;
    this.year = year;
    this.address = address;
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

 

}
