package com.sleepy4k.sales.laptop.utils;

import java.util.UUID;

public class Helper {
  public static void print(String message) {
    System.out.println(message);
  }

  public static void printError(String message) {
    System.out.println();
    System.err.println(message);
    System.out.println();
  }

  public static String generateUUID() {
    return UUID.randomUUID().toString();
  }
}
