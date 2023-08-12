package com.sleepy4k.sales.laptop.handler;

import com.sleepy4k.sales.laptop.utils.Helper;

public class LaptopHandler {
  private String brand;
  private String model;
  private String processor;
  private String ram;
  private String price;

  public LaptopHandler(String brand, String model, String processor, String ram, String price) {
    this.brand = brand;
    this.model = model;
    this.processor = processor;
    this.ram = ram;
    this.price = price;
  }

  @Override
  public String toString() {
    return Helper.generateUUID() + ',' + brand + ',' + model + ',' + processor + ',' + ram + ',' + price;
  }
}
