package com.sleepy4k.sales.laptop;

import java.util.Scanner;
import com.sleepy4k.sales.laptop.controller.Laptop;

public class App {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        System.out.println("1. Laptop");
        System.out.println("2. Exit");
        System.out.print("Choose: ");

        int choose = scanner.nextInt();
        scanner.nextLine();

        switch (choose) {
          case 1:
            Laptop.main(args);
            break;
          case 2:
            System.exit(0);
            break;
          default:
            System.out.println("Choose 1-3");
            break;
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
