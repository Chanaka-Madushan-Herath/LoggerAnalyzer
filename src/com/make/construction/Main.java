package com.make.construction;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int i=0;

    while (i != -1) {
      System.out.println("1.Error found");
      System.out.println("2.Correct sentence");
      i = scan.nextInt();

      switch (i){
        case 1:
          System.out.println("Sending emails to......");
          DatabaseConnection dbcon = new DatabaseConnection();
          dbcon.getEmails();
          System.out.println("\n\n");
          break;
        case 2:
          System.out.println("continue....");
          break;
        default:
          break;
      }
    }

    DatabaseConnection db = new DatabaseConnection();
    db.getEmails();
  }

}
