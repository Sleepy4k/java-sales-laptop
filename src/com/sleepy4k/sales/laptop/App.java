package com.sleepy4k.sales.laptop;

import java.util.Scanner;
import java.util.InputMismatchException;
import com.sleepy4k.sales.laptop.controller.User;
import com.sleepy4k.sales.laptop.controller.Laptop;

public class App {
  public static void main(String[] args) {
    Scanner mainScanner = new Scanner(System.in);

    try {
      while (true) {
        System.out.println("1. Laptop");
        System.out.println("2. Auth");
        System.out.println("3. Exit");
        System.out.print("Choose: ");

        int choose = mainScanner.nextInt();
        mainScanner.nextLine();

        switch (choose) {
          case 1:
            laptopMenu(mainScanner);
            break;
          case 2:
            authMenu(mainScanner);
            break;
          case 3:
            System.exit(0);
            break;
          default:
            System.out.println("Choose 1-3");
            break;
        }
      }
    } catch (InputMismatchException e) {
      System.out.println(e.getMessage());
    } finally {
      mainScanner.close();
    }
  }

  public static void laptopMenu(Scanner scanner) {
    if (!User.getIsLogin()) {
      System.out.println("You must login first");
      return;
    }

    System.out.println("--------------------");
    System.out.println("1. Read Laptop");
    System.out.println("2. Add Laptop");
    System.out.println("3. Find Laptop");
    System.out.println("4. Update Laptop");
    System.out.println("5. Delete Laptop");
    System.out.println("6. Back");
    System.out.print("Choose: ");

    int laptopChoose = scanner.nextInt();
    scanner.nextLine();

    switch (laptopChoose) {
      case 1:
        Laptop.readLaptop();
        break;
      case 2:
        Laptop.addLaptop(scanner);
        break;
      case 3:
        Laptop.findLaptop(scanner);
        break;
      case 4:
        Laptop.updateLaptop(scanner);
        break;
      case 5:
        Laptop.deleteLaptop(scanner);
        break;
      case 6:
        break;
      default:
        System.out.println("Choose 1-6");
        break;
    }
  }

  public static void authMenu(Scanner scanner) {
    System.out.println("--------------------");
    System.out.println("1. Login");
    System.out.println("2. Register");
    System.out.println("3. Back");
    System.out.print("Choose: ");

    int authChoose = scanner.nextInt();
    scanner.nextLine();

    switch (authChoose) {
      case 1:
        User.login(scanner);
        break;
      case 2:
        User.register(scanner);
        break;
      case 3:
        break;
      default:
        System.out.println("Choose 1-3");
        break;
    }
  }
}
