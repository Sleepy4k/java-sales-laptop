package com.sleepy4k.sales.laptop.controller;

import java.util.Scanner;
import com.sleepy4k.sales.laptop.utils.Helper;
import com.sleepy4k.sales.laptop.utils.HandleFile;
import com.sleepy4k.sales.laptop.handler.UserHandler;

public class User {
  private static boolean isLogin = false;
  private static final String FILE_PATH = "src\\com\\sleepy4k\\sales\\laptop\\data\\user.txt";

  public static void login(Scanner scanner) {
    Helper.print("Username: ");
    String username = scanner.nextLine();

    Helper.print("Password: ");
    String password = scanner.nextLine();

    String data = HandleFile.readDataFile(FILE_PATH);

    if (data == null) {
      Helper.printError("Data is empty");
      return;
    }

    String[] dataSplit = data.split("\n");

    for (String item : dataSplit) {
      String[] itemSplit = item.split(",");

      if (itemSplit[1].equals(username) && itemSplit[2].equals(password)) {
        Helper.print("Login success");
        return;
      }
    }

    Helper.printError("Login failed");
  }

  public static void register(Scanner scanner) {
    Helper.print("Username: ");
    String username = scanner.nextLine();

    Helper.print("Password: ");
    String password = scanner.nextLine();

    Helper.print("Confirm password: ");
    String confirmPassword = scanner.nextLine();

    if (!password.equals(confirmPassword)) {
      Helper.printError("Password and confirm password not match");
      return;
    }

    UserHandler user = new UserHandler(username, password);
    isLogin = true;
    String data = user.toString();

    HandleFile.addDataFile(FILE_PATH, data);
  }

  public static boolean getIsLogin() {
    return isLogin;
  }
}
