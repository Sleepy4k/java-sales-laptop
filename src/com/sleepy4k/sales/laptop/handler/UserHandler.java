package com.sleepy4k.sales.laptop.handler;

import com.sleepy4k.sales.laptop.utils.Helper;

public class UserHandler {
  private String username;
  private String password;

  public UserHandler(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String toString() {
    return Helper.generateUUID() + ',' + username + ',' + password;
  }
}
