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

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getProcessor() {
    return processor;
  }

  public String getRam() {
    return ram;
  }

  public String getPrice() {
    return price;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public void setRam(String ram) {
    this.ram = ram;
  }

  @Override
  public String toString() {
    return Helper.generateUUID() + ',' + brand + ',' + model + ',' + processor + ',' + ram + ',' + price;
  }
}
