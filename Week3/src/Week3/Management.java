package Week3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Management {
  public static List<Person> list=new ArrayList<Person>();
  public static Scanner input = new Scanner(System.in);
  
  public Teacher addTeacher() {
    Teacher obj=new Teacher();
    System.out.print("Nhap ten : ");
    obj.setName(input.nextLine());
    System.out.print("Nhap nam sinh : ");
    obj.setYear(input.nextInt());
    input.nextLine();
    System.out.print("Nhap que quan : ");
    obj.setAddress(input.nextLine());
    System.out.print("Nhap khoa : ");
    obj.setFaculty(input.nextLine());
    System.out.print("Nhap trinh do : ");
    obj.setDegree(input.nextLine());
    System.out.print("Nhap so tiet day/thang : ");
    obj.setClassHours(input.nextInt());
    System.out.print("Nhap he so luong : ");
    obj.setCoefficientSalary(input.nextFloat());
    input.nextLine();
    obj.setAllowance();
    return obj;
  }
  
  public Employee addEmployee() {
    Employee obj=new Employee();
    System.out.print("Nhap ten : ");
    obj.setName(input.nextLine());
    System.out.print("Nhap nam sinh : ");
    obj.setYear(input.nextInt());
    input.nextLine();
    System.out.print("Nhap que quan : ");
    obj.setAddress(input.nextLine());
    System.out.print("Nhap phong ban : ");
    obj.setDepartment(input.nextLine());
    System.out.print("Nhap so ngay cong : ");
    obj.setWorkDays(input.nextInt());
    System.out.print("Nhap he so luong : ");
    obj.setCoefficientSalary(input.nextFloat());
    input.nextLine();
    System.out.print("Nhap chuc vu : ");
    obj.setPosition(input.nextLine());
    obj.setAllowance();
    return obj;
  }
  public void addPersonToList(int choose1) {
    System.out.println("Chon loai can bo muon them ");
    System.out.println("1.Giang vien \t\t\t 2.Nhan vien");
    System.out.print("Chon : "); 
    int kind = input.nextInt();
    input.nextLine();
    Person obj = new Person();
    if(kind==1) {
      obj=new Teacher();
      obj=addTeacher();
     /* if(choose1==1) {
        list.add(obj);
      }
      if(choose1==2) {
        list.add(0,obj);
      }
      if(choose1==3) {
        System.out.print("Vi tri muon them vao : ");
        list.add(input.nextInt(),obj);
      }*/
    }
    if(kind==2) {
      obj=new Employee();
      obj=addEmployee();
      
    }
    if(choose1==1) {
        list.add(obj);
      }
      if(choose1==2) {
        list.add(0,obj);
      }
      if(choose1==3) {
        System.out.print("Vi tri muon them vao : ");
        list.add(input.nextInt(),obj);
      }
  }
   
  public void editPerson() {
	Person obj = new Person();  
    System.out.print("Nhap so thu tu can bo muon sua : ");
    int stt = input.nextInt();
    if(stt < list.size() && stt >= 0) {
      if(list.get(stt).getCareer() == "GV") {
        obj = new Teacher();
        obj = addTeacher();
      }
      if(list.get(stt).getCareer() == "NV") {
          obj = new Employee();
          obj = addEmployee();
        }
      list.add(stt, obj);
      list.remove(stt+1);
    }
    else {
      System.out.println("Khong co can bo tai stt "+stt);
    }
  }
  
  public void displayList(List<Person> listPerson) {
    System.out.printf("%3s\t %15s\t %8s\t %10s\t %4s\t %4s\t %15s\t %5s\t %5s\t %5s\t",
    		"STT","Ten","Nam sinh","Que quan","Loai","C1","C2","C3","C4","C5");
    for(int i=0;i<listPerson.size();i++) {
      System.out.print("\n");
      System.out.printf("%3s\t ",i);
      
      if(list.get(i).getCareer() == "GV") {
        Teacher obj1= (Teacher)listPerson.get(i);
        obj1.printInfor();
      }
      
      if(list.get(i).getCareer() == "NV") {
        Employee obj1= (Employee)listPerson.get(i);
        obj1.printInfor();
        
      }
    }
  }
  
  public void sortBySalary() {
	  List<Person> listSortBySalary=new ArrayList<Person>();
	  listSortBySalary = list;
	  Collections.sort(listSortBySalary, new PersonComparator());
	 /* for(Person emp : listSortBySalary){
		  System.out.println(emp.getName()+","+emp.getSalary());
	  }*/
	 displayList(listSortBySalary);
  }
  
  public void show() {
    int choose,choose1,choose2,choose3,choose4;
    choose = 0 ;
    do {
      System.out.println("\nQuan ly thong tin");
      System.out.println("1. Them moi can bo.");
      System.out.println("2. Chinh sua thong tin can bo.");
      System.out.println("3. Xoa can bo.");
      System.out.println("4. Hien thi danh sach can bo.");
      System.out.println("5. Thoat chuong trinh.");
      System.out.print(" Nhap viec muon lam : ");
      choose = input.nextInt();
      switch(choose) {
      case 1 :
        System.out.println("1.1 Them can bo vao cuoi danh sach.");
        System.out.println("1.2 Them can bo vao dau danh sach.");
        System.out.println("1.3 Them can bo vao sau vi tri thu k.");
        System.out.println("1.4 Quay lai thu muc truoc.");
        System.out.print(" Nhap viec muon lam : ");
        choose1 = input.nextInt();
        switch(choose1) {
        case 1 :
          do {
          addPersonToList(1);
          System.out.print("Ban co muon nhap them can bo (y/n) : ");
          } while(input.next().equals("y"));
          break;
        case 2 :
          do {
            addPersonToList(2);
            System.out.print("Ban co muon nhap them can bo (y/n) : ");
            } while(input.next().equals("y"));
          break;
        case 3 :
          do {
            addPersonToList(3);
            System.out.print("Ban co muon nhap them can bo (y/n) : ");
            } while(input.next().equals("y"));
          break;
        case 4:
          show();
        }
        break;
      case 2 :
        editPerson();
        break;
      case 3 :
        System.out.print("Nhap so thu can bo can xoa : ");
        choose3 = input.nextInt();
        list.remove(choose3);
        break;
      case 4 :
        System.out.println("4.1 Hien thi danh sach hien tai.");
        System.out.println("4.2 Hien thi danh sach sau khi da sap xep tang dan theo luong.");
        System.out.println("4.3 Hien thi danh sach sau khi da sap xep ten theo thu tu chu cai.");
        System.out.println("4.4 Tim kiem can bo theo ten.");
        System.out.println("4.5 Tim kiem can bo theo nam sinh.");
        System.out.print(" Nhap viec muon lam : ");
        choose4 = input.nextInt();
        switch(choose4) {
        case 1 :
          displayList(list);
          break;
        case 2 :
        	sortBySalary();
        	break;
        }
        break;
      case 5 :
        System.exit(0);
      }
    }while(choose!=5);
  }
  
  public static void main(String[] args) {
    Management management = new Management();
    management.show();
    
  }

}
