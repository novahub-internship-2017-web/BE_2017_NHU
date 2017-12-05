package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Management {
  public static List<Person> list=new ArrayList<Person>();
  public static Scanner input = new Scanner(System.in); 
  
  public static final int FIRST_CHOICE_MENU = 1;
  public static final int SECOND_CHOICE_MENU = 2;
  public static final int THIRD_CHOICE_MENU = 3;
  public static final int FOURTH_CHOICE_MENU = 4;
  public static final int EXIT_PROGRAM = 5;
  
  public static final int ADD_TO_END_OF_LIST = 1;
  public static final int ADD_TO_FIRST_OF_LIST = 2;
  public static final int ADD_TO_POSITION_K_OF_LIST = 3;
  public static final int RETURN_MAIN_MENU = 4;
  public static final int ADD_AVAILABLE_LIST = 5;
  
  public static final int DISPLAY_LIST = 1;
  public static final int DISPLAY_LIST_SORT_BY_SALARY = 2;
  public static final int DISPLAY_LIST_SORT_BY_NAME = 3;
  public static final int SEARCH_BY_NAME = 4;
  public static final int SEARCH_BY_YEAR = 5;
  
  public void showMainMenu() {
    int choose;
    do {
      System.out.println("\n-----------------------------");
      System.out.println("1. Them moi can bo.");
      System.out.println("2. Chinh sua thong tin can bo.");
      System.out.println("3. Xoa can bo.");
      System.out.println("4. Hien thi danh sach can bo.");
      System.out.println("5. Thoat chuong trinh.");
      System.out.print(" Nhap viec muon lam (1->5) : ");
      choose = nhapSo();
      switch(choose) {
        case FIRST_CHOICE_MENU:
          firstMenu();
          break;
        case SECOND_CHOICE_MENU:
          editPerson();
          break;
        case THIRD_CHOICE_MENU:
          removePerson();
          break;
        case FOURTH_CHOICE_MENU:
          fourthMenu();
          break;
        case EXIT_PROGRAM:
          break;
        default:
          System.out.println("So ban nhap khong hop le");
          showMainMenu();
      }
    }while(choose>0 && choose <6);
  }
  
  public void firstMenu() {
    int choose;
    do {
      System.out.println("-----------------------------");
      System.out.println("1.1 Them can bo vao cuoi danh sach.");
      System.out.println("1.2 Them can bo vao dau danh sach.");
      System.out.println("1.3 Them can bo vao sau vi tri thu k.");
      System.out.println("1.4 Quay lai thu muc truoc.");
      System.out.println("1.5 Them danh sach san co.");
      System.out.print(" Nhap viec muon lam (1->5) : ");
      choose = nhapSo();
      switch(choose) {
        case ADD_TO_END_OF_LIST:
          addPersonToList(ADD_TO_END_OF_LIST,0);
          break;
        case ADD_TO_FIRST_OF_LIST:
          addPersonToList(ADD_TO_FIRST_OF_LIST,0);
          break;
        case ADD_TO_POSITION_K_OF_LIST:
          System.out.print("Vi tri muon them vao : ");
          int stt = nhapSo();
          if(stt < 0 || stt>list.size()) {
            System.out.print("Khong co can bo vi tri thu "+stt);
          }
          else {
            addPersonToList(ADD_TO_POSITION_K_OF_LIST,stt);
          }
          break;
        case RETURN_MAIN_MENU:
          showMainMenu();
          break; 
        case ADD_AVAILABLE_LIST:
          addAvailableList();
          break;
      }
    }while(choose != 4);
  }
  
  public void fourthMenu() {
    int choose;
    System.out.println("-----------------------------");
    System.out.println("4.1 Hien thi danh sach hien tai.");
    System.out.println("4.2 Hien thi danh sach sau khi da sap xep tang dan theo luong.");
    System.out.println("4.3 Hien thi danh sach sau khi da sap xep ten theo thu tu chu cai.");
    System.out.println("4.4 Tim kiem can bo theo ten.");
    System.out.println("4.5 Tim kiem can bo theo nam sinh.");
    System.out.print(" Nhap viec muon lam (1->5) : ");
    choose = nhapSo();
    switch(choose) {
      case DISPLAY_LIST:
        displayList(list);
        break;
      case DISPLAY_LIST_SORT_BY_SALARY:
        sortBySalary();
        break;
      case DISPLAY_LIST_SORT_BY_NAME:
        sortByName();
        break;
      case SEARCH_BY_NAME:
        searchByName();
        break; 
      case SEARCH_BY_YEAR:
        searchByYear();
        break;
      }
  }
  
  public void addPersonToList(int choose,int stt) {
    if(!list.isEmpty()) {
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
      switch(choose) {
        case 1: 
          list.add(obj);
          break;
        case 2:
          list.add(0,obj);
          break;
        case 3:
            list.add(stt,obj);
          break;
        default:
          break;
      }
    }else {
      System.out.print("Danh sach rong");
    }
    
  }
  
  public void addAvailableList() {
    Employee obj1 = new Employee("Nguyen Nhu", 1996, "DN", 3.2f, "Ke toan", "Truong phong", 25);
    Teacher obj2 = new Teacher("Nguyen Van B", 1990, "QN", 2.0f, "CNSH", "Thac si", 21);
    Employee obj3 = new Employee("Tran C", 1987, "DN", 3.2f, "QLy", "Pho phong", 25);
    Employee obj4 = new Employee("Le B", 1988, "Hue", 3.1f, "Dao tao", "Nhan vien", 23);
    Teacher obj5 = new Teacher("Nguyen Van A", 1989, "QN", 2.0f, "DTVT", "Tien si", 21);
    Teacher obj6 = new Teacher("Nguyen Van C", 1988, "QN", 2.0f, "CNSH", "Tien si", 20);
    list.add(obj1);
    list.add(obj2);
    list.add(obj3);
    list.add(obj4);
    list.add(obj5);
    list.add(obj6);
  }
  
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
  
  
   
  public void editPerson() {
    System.out.print("Nhap so thu tu can bo muon sua : ");
    int stt = nhapSo();
    if(stt < list.size() && stt >= 0) {
      if(list.get(stt).getCareer() == "GV") {
        list.get(stt).editInfor();
      }
      if(list.get(stt).getCareer() == "NV") {
        list.get(stt).editInfor();
        }
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
    if(!list.isEmpty()) {
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
    }else {
      System.out.println("\nDanh sach rong!!!");
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
  
  public void removePerson() {
    System.out.print("Nhap so thu tu can bo can xoa : ");
    int choose = nhapSo();
    if(choose < 0 || choose>list.size()) {
      System.out.print("Khong co can bo vi tri thu "+choose);
    }
    else {
      list.remove(choose);
    }
  }

}
