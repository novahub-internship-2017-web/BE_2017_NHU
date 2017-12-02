package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Management {
  public static List<Person> list=new ArrayList<Person>();
  public static Scanner input = new Scanner(System.in);
  
  public Teacher addTeacher() {
    Teacher obj=new Teacher();
    obj.inputInfor();
    return obj;
  }
  
  public Employee addEmployee() {
    Employee obj=new Employee();
    obj.inputInfor();
    return obj;
  }
  
  public static int nhapSo(){
        boolean check= false;
        int n=0;
        while(!check){
            try{
                n= input.nextInt();
                check= true;
                }
            catch(Exception e){
                System.out.println("Ban phai nhap so, moi nhap lai : ");
                input.nextLine();
                }
            }
        return (n);
    } 
  
  public void addPersonToList(int choose1) {
    System.out.println("Chon loai can bo muon them ");
    System.out.println(" 1.Giang vien \t\t 2.Nhan vien");
    System.out.print("Chon : ");
    int kind = nhapSo(); 
    Person obj = new Person();
    if(kind==1) {
      obj=new Teacher();
      obj=addTeacher();
    }
    else if(kind==2) {
      obj=new Employee();
      obj=addEmployee();
    }
    switch(choose1) {
      case 1: 
        list.add(obj);
        break;
      case 2:
        list.add(0,obj);
        break;
      case 3:
        System.out.print("Vi tri muon them vao : ");
        list.add(nhapSo(),obj);
        break;
      default:
        break;
    }
  }
   
  public void editPerson() {
	Person obj = new Person();  
    System.out.print("Nhap so thu tu can bo muon sua : ");
    int stt = nhapSo();
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

  public void colsNameDisplay() {
    System.out.printf("%-3s %-15s %-8s %-10s %-4s %-10s %-15s %-7s %-7s %-7s",
        "STT","Ten","Nam sinh","Que quan","Loai","C1","C2","C3","C4","C5");
  }
  
  public void displayList(List<Person> listPerson) {
    colsNameDisplay();
    for(int i=0;i<listPerson.size();i++) {
      System.out.print("\n");
      System.out.printf("%-3s ",i);
      
      if(listPerson.get(i).getCareer() == "GV") {
        Teacher obj1= (Teacher)listPerson.get(i);
        obj1.printInfor();
      }
      
      if(listPerson.get(i).getCareer() == "NV") {
        Employee obj1= (Employee)listPerson.get(i);
        obj1.printInfor();
        
      }
    }
  }

  public void sortBySalary() {
	  List<Person> listSortBySalary = new ArrayList<Person>();
	  listSortBySalary.addAll(list);
	  Collections.sort(listSortBySalary, new SalaryComparator());
	 /* for(Person p : listSortBySalary){
		  System.out.println(p.getName()+","+p.getSalary());
	  }*/
	 displayList(listSortBySalary);
  }
  
  public void sortByName() {
    List<Person> listSortByName = new ArrayList<Person>();
    listSortByName.addAll(list);
	  Collections.sort(listSortByName, new Comparator<Person>() {
          @Override
          public int compare(Person obj1, Person obj2) {
              return (obj1.getName().compareTo(obj2.getName()));
          }
      });
	  displayList(listSortByName);
  }
  
  public void searchByName() {
	  input.nextLine();
	  System.out.print("Nhap ten muon tim kiem : ");
	  String nameSearch = input.nextLine().toLowerCase();
	  String name = "";
	  int count = 0;
	  for(int i=0; i<list.size(); i++) {
		  name = list.get(i).getName().toLowerCase();
		  if(name.contains(nameSearch)) {
			  count++;
			  if(count == 1) {
			    colsNameDisplay();
			  }
			  System.out.println();
			  System.out.printf("%3s\t ",i);
			  list.get(i).printInfor();
		  }
	  }
	  if(count == 0) {
		  System.out.println("Khong tim thay.");
	  }
  }
  
  public void searchByYear() {
	  input.nextLine();
	  System.out.print("Nhap nam sinh muon tim kiem : ");
	  int yearSearch = nhapSo();
	  int count = 0;
	  for(int i=0; i<list.size(); i++) {
		  if(list.get(i).getYear() == yearSearch) {
			  count++;
			  if(count == 1) {
			    colsNameDisplay();
			  }
			  System.out.println();
			  System.out.printf("%3s\t ",i);
			  list.get(i).printInfor();
		  }
	  }
	  if(count == 0) {
		  System.out.println("Khong tim thay.");
	  }
  }
  
  public void show() {
    int choose,choose1,choose3,choose4;
    do {
      System.out.println("\nQuan ly thong tin");
      System.out.println("1. Them moi can bo.");
      System.out.println("2. Chinh sua thong tin can bo.");
      System.out.println("3. Xoa can bo.");
      System.out.println("4. Hien thi danh sach can bo.");
      System.out.println("5. Thoat chuong trinh.");
      System.out.print(" Nhap viec muon lam : ");
      choose = nhapSo();
      switch(choose) {
        case 1 :
          System.out.println("1.1 Them can bo vao cuoi danh sach.");
          System.out.println("1.2 Them can bo vao dau danh sach.");
          System.out.println("1.3 Them can bo vao sau vi tri thu k.");
          System.out.println("1.4 Quay lai thu muc truoc.");
          System.out.print(" Nhap viec muon lam : ");
          choose1 = nhapSo();
          switch(choose1) {
            case 1:
              do {
              addPersonToList(1);
              System.out.print("Ban co muon nhap them can bo (y/n) : ");
              } while(input.next().equals("y"));
              break;
            case 2:
              do {
                addPersonToList(2);
                System.out.print("Ban co muon nhap them can bo (y/n) : ");
                } while(input.next().equals("y"));
              break;
            case 3:
              do {
                addPersonToList(3);
                System.out.print("Ban co muon nhap them can bo (y/n) : ");
                } while(input.next().equals("y"));
              break;
            case 4:
              show();
          }
          break;
        case 2:
          editPerson();
          break;
        case 3:
          System.out.print("Nhap so thu can bo can xoa : ");
          choose3 = nhapSo();
          list.remove(choose3);
          break;
        case 4:
          System.out.println("4.1 Hien thi danh sach hien tai.");
          System.out.println("4.2 Hien thi danh sach sau khi da sap xep tang dan theo luong.");
          System.out.println("4.3 Hien thi danh sach sau khi da sap xep ten theo thu tu chu cai.");
          System.out.println("4.4 Tim kiem can bo theo ten.");
          System.out.println("4.5 Tim kiem can bo theo nam sinh.");
          System.out.print(" Nhap viec muon lam : ");
          choose4 = nhapSo();
          switch(choose4) {
            case 1:
              displayList(list);
              break;
            case 2:
            	sortBySalary();
            	break;
            case 3:
            	sortByName();
            	break;
            case 4:
            	searchByName();
            	break;
            default:
              break;
          }
          break;
        case 5:
          System.exit(0);
        default:
          System.exit(0);
        }
    }while(choose!=5);
  }
  
  public static void main(String[] args) {
    Management management = new Management();
    management.show();
    
  }

}
