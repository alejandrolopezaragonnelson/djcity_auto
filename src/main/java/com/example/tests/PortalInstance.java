package com.example.tests;

public class PortalInstance {

  // Private static instance of the class
  private static PortalInstance instance;
  private static String portalName;

  // Private constructor to prevent instantiation from outside
  private PortalInstance() {}

  // Public method to get the instance of the class
  public static PortalInstance getInstance() {
    if (instance == null) {
      instance = new PortalInstance();
    }
    return instance;
  }

  // URL variable
  private String url;

  // Getter for the URL
  public String getUrl() {
    return url;
  }

  public String getPortalName() {
    return portalName;
  }

  public static void setPortalName(String portalName) {
    PortalInstance.portalName = portalName;
  }

  // Setter for the URL
  public void setUrl(String portal) {
    String result;
    switch (portal) {
      case "home":
        result = "https://www.djcity.com/";
        break;
      default:
        result = "Unknown";
        break;
    }
    this.url = result;
    PortalInstance.portalName = portal;
  }
}
