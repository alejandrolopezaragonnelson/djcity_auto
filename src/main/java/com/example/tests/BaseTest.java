package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class BaseTest {

  protected WebDriver driver;

  public BaseTest() {
    // Constructor vacío
  }

  @DataProvider(name = "getParams")
  public Object[][] getParams() {
    String browser = System.getProperty("browser", "chrome");
    String platform = System.getProperty("platform", "desktop");

    return new Object[][] {
      { browser, platform },
      // Puedes agregar más conjuntos de datos si es necesario
    };
  }

  protected void configureDriver(String browser, String platform) {
    switch (platform.toLowerCase()) {
      case "desktop":
        configureDesktopDriver(browser);
        break;
      case "ios":
        configureIOSDriver(browser);
        break;
      case "android":
        configureAndroidDriver(browser);
        break;
      default:
        throw new IllegalArgumentException("Plataforma especificada no válida");
    }
  }

  private void configureDesktopDriver(String browser) {
    switch (browser.toLowerCase()) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        Env_variables.getInstance().setPlatform("chrome");
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-private");
        driver = new FirefoxDriver(firefoxOptions);
        break;
      case "edge":
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        driver = new EdgeDriver(edgeOptions);
        break;
      case "safari":
        // Safari no necesita configuración adicional
        driver = new SafariDriver();
        Env_variables.getInstance().setPlatform("safari");
        break;
      default:
        throw new IllegalArgumentException("El navegador especificado no es compatible");
    }
    // Maximizar la ventana del navegador
    driver.manage().window().maximize();
  }

  private void configureIOSDriver(String browser) {
    // Configurar el WebDriver para iOS
    // Implementar la configuración específica para iOS si es necesario
    // throw new UnsupportedOperationException("Configuración para iOS no
    // implementada");
    driver = new SafariDriver();
    driver.manage().window().setSize(new Dimension(430, 932));
    Env_variables.getInstance().setPlatform("ios");
  }

  private void configureAndroidDriver(String browser) {
    // Configurar el WebDriver para Android
    // Implementar la configuración específica para Android si es necesario
    // throw new UnsupportedOperationException("Configuración para Android no
    // implementada");
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--incognito");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().setSize(new Dimension(430, 932));
    Env_variables.getInstance().setPlatform("android");
  }

  @AfterMethod
  public void tearDown(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
      // Captura de pantalla en caso de fallo
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      try {
        // Guardar la captura de pantalla en un archivo
        FileUtils.copyFile(
          screenshot,
          new File("target/screenshots/" + result.getName() + ".png")
        );
        // Registrar la captura de pantalla en Allure
        Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
      } catch (IOException e) {
        e.printStackTrace();
      }
      Throwable cause = result.getThrowable();
    } else {}
    if (driver != null) {
      driver.quit();
    }
  }

  @BeforeSuite
  public void beforeSuite() {}

  @AfterSuite
  public void afterSuite() {}
}
