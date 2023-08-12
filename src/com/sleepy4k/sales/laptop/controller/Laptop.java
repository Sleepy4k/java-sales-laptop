package com.sleepy4k.sales.laptop.controller;

import java.util.Scanner;
import com.sleepy4k.sales.laptop.utils.Helper;
import com.sleepy4k.sales.laptop.utils.HandleFile;
import com.sleepy4k.sales.laptop.handler.LaptopHandler;

public class Laptop {
  private static final String FILE_PATH = "src\\com\\sleepy4k\\sales\\laptop\\data\\laptop.txt";

  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in)) {
      while (true) {
        Helper.print("--------------------");
        Helper.print("1. Read Laptop");
        Helper.print("2. Add Laptop");
        Helper.print("3. Find Laptop");
        Helper.print("4. Update Laptop");
        Helper.print("5. Delete Laptop");
        Helper.print("6. Back");
        Helper.print("Choose: ");

        int choose = keyboard.nextInt();
        keyboard.nextLine();

        switch (choose) {
          case 1:
            Laptop.readLaptop();
            break;
          case 2:
            Laptop.addLaptop();
            break;
          case 3:
            Laptop.findLaptop();
            break;
          case 4:
            Laptop.updateLaptop();
            break;
          case 5:
            Laptop.deleteLaptop();
            break;
          case 6:
            return;
          default:
            Helper.print("Choose 1-6");
            break;
        }
      }
    } catch (Exception e) {
      Helper.printError(e.getMessage());
    }
  }

  public static void readLaptop() {
    String data = HandleFile.readDataFile(FILE_PATH);

    if (data == null) {
      Helper.printError("Data is empty");
      return;
    }

    String[] dataSplit = data.split("\n");

    for (String item : dataSplit) {
      String[] itemSplit = item.split(",");

      Helper.print("");
      Helper.print("ID: " + itemSplit[0]);
      Helper.print("Brand: " + itemSplit[1]);
      Helper.print("Model: " + itemSplit[2]);
      Helper.print("Processor: " + itemSplit[3]);
      Helper.print("RAM: " + itemSplit[4]);
      Helper.print("Price: " + itemSplit[5]);
      Helper.print("");
    }
  }

  public static void addLaptop() {
    try (Scanner scanner = new Scanner(System.in)) {
      Helper.print("Brand: ");
      String brand = scanner.nextLine();

      Helper.print("Model: ");
      String model = scanner.nextLine();

      Helper.print("Processor: ");
      String processor = scanner.nextLine();

      Helper.print("RAM: ");
      String ram = scanner.nextLine();

      Helper.print("Price: ");
      String price = scanner.nextLine();

      LaptopHandler laptop = new LaptopHandler(brand, model, processor, ram, price);
      String data = laptop.toString();

      HandleFile.addDataFile(FILE_PATH, data);
    } catch (Exception e) {
      Helper.printError(e.getMessage());
    }
  }

  public static void findLaptop() {
    try (Scanner scanner = new Scanner(System.in)) {
      Helper.print("Model: ");
      String model = scanner.nextLine();

      String data = HandleFile.findDataFile(FILE_PATH, model);

      if (data == null) {
        Helper.printError("Data not found");
        scanner.close();
        return;
      }

      String[] itemSplit = data.split(",");

      Helper.print("");
      Helper.print("ID: " + itemSplit[0]);
      Helper.print("Brand: " + itemSplit[1]);
      Helper.print("Model: " + itemSplit[2]);
      Helper.print("Processor: " + itemSplit[3]);
      Helper.print("RAM: " + itemSplit[4]);
      Helper.print("Price: " + itemSplit[5]);
      Helper.print("");
    } catch (Exception e) {
      Helper.printError(e.getMessage());
    }
  }

  public static void updateLaptop() {
    try (Scanner scanner = new Scanner(System.in)) {
      Helper.print("Old Model: ");
      String oldModel = scanner.nextLine();

      Helper.print("Brand: ");
      String brand = scanner.nextLine();

      Helper.print("Model: ");
      String model = scanner.nextLine();

      Helper.print("Processor: ");
      String processor = scanner.nextLine();

      Helper.print("RAM: ");
      String ram = scanner.nextLine();

      Helper.print("Price: ");
      String price = scanner.nextLine();

      LaptopHandler laptop = new LaptopHandler(brand, model, processor, ram, price);
      String data = laptop.toString();

      HandleFile.updateDataFile(FILE_PATH, oldModel, data);
    } catch (Exception e) {
      Helper.printError(e.getMessage());
    }
  }

  public static void deleteLaptop() {
    try (Scanner scanner = new Scanner(System.in)) {
      Helper.print("Model: ");
      String model = scanner.nextLine();

      HandleFile.deleteDataFile(FILE_PATH, model);
    } catch (Exception e) {
      Helper.printError(e.getMessage());
    }
  }
}
