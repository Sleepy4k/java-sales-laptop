package com.sleepy4k.sales.laptop.controller;

import java.util.Scanner;
import com.sleepy4k.sales.laptop.utils.Helper;
import com.sleepy4k.sales.laptop.utils.HandleFile;
import com.sleepy4k.sales.laptop.handler.LaptopHandler;

public class Laptop {
  private static final String FILE_PATH = "src\\com\\sleepy4k\\sales\\laptop\\data\\laptop.txt";

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

  public static void addLaptop(Scanner scanner) {
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
  }

  public static void findLaptop(Scanner scanner) {
    Helper.print("Model: ");
    String model = scanner.nextLine();

    String data = HandleFile.findDataFile(FILE_PATH, model);

    if (data == null) {
      Helper.printError("Data not found");
    } else {
      String[] itemSplit = data.split(",");

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

  public static void updateLaptop(Scanner scanner) {
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
  }

  public static void deleteLaptop(Scanner scanner) {
    Helper.print("Model: ");
    String model = scanner.nextLine();

    HandleFile.deleteDataFile(FILE_PATH, model);
  }
}
