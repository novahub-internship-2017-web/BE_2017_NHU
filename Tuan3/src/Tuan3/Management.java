package Tuan3;

import java.util.Scanner;

public class Management {
  
  
  public void show() {
    
    Scanner input = new Scanner(System.in);
    
    int choose,choose1,choose2,choose3,choose4;
    choose = 0 ;
    
    do {
      System.out.println("Quan ly thong tin");
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
        break;
      case 2 :
        System.out.print("Nhap so thu tu can bo muon chinh sua : ");
        choose2 = input.nextInt();
        break;
      case 3 :
        System.out.print("Nhap so thu can bo can xoa : ");
        choose3 = input.nextInt();
        break;
      case 4 :
        System.out.println("4.1 Hien thi danh sach hien tai.");
        System.out.println("4.2 Hien thi danh sach sau khi da sap xep tang dan theo luong.");
        System.out.println("4.3 Hien thi danh sach sau khi da sap xep ten theo thu tu chu cai.");
        System.out.println("4.4 Tim kiem can bo theo ten.");
        System.out.println("4.5 Tim kiem can bo theo nam sinh.");
        System.out.print("Nhap so thu can bo can xoa : ");
        choose4 = input.nextInt();
        break;
      case 5 :
        System.exit(0);
      }
    }while(choose!=5);
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
