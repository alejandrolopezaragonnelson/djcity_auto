package com.example.tests;

public class Env_variables {

  // Private static instance of the class
  private static Env_variables instance;
  private String platform = "";

  // Private constructor to prevent instantiation from outside
  private Env_variables() {}

  // Public method to get the instance of the class
  public static Env_variables getInstance() {
    if (instance == null) {
      instance = new Env_variables();
    }
    return instance;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }
}
