package app.home.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.common.methods.CommonMethods;

public class HomePageObjects {

  private WebDriver driver;


  public HomePageObjects(WebDriver driver) {
    CommonMethods.sleep();
    this.driver = driver;
    new CommonMethods();
  }

  public WebDriver getDriver(WebDriver driver) {
    CommonMethods.sleep();
    return driver;
  }

  public void setDriver(WebDriver driver) {
    CommonMethods.sleep();
    this.driver = driver;
  }

  public void AcceptCookies(WebDriver driver) {
    CommonMethods.sleep();
    if (
      driver
        .findElement(By.cssSelector("button#onetrust-accept-btn-handler"))
        .isDisplayed()
    ) {
      driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
    } else {}
    setDriver(driver);
  }

}
