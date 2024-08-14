package app.common.methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods {

  //WEB ELEMENTS
  static String acceptCoockieId = "onetrust-accept-btn-handler";
  static String rejectCoockieId = "onetrust-reject-all-handler";
  static String cookiesBannerText = "onetrust-policy-text";

  //ASSERTION METHODS
  public void validateNavigateUrl(WebDriver driver, String urlEsperada) {
    // Valida si la navegación fue exitosa comparando la URL actual con la esperada
    sleep();
    String urlActual = driver.getCurrentUrl();
    Assert.assertEquals(urlActual, urlEsperada, "La URL no coincide!");
  }

  public static void validateCookiesBannerText(WebDriver driver) {
    CommonMethods.sleep();
    // Encuentra el elemento que contiene el texto
    WebElement elementoTexto = driver.findElement(By.id(cookiesBannerText));

    // Obtiene el texto del elemento
    String textoEncontrado = elementoTexto.getText();

    // Cadena buscada
    String textoBuscado =
      "Utilizamos cookies propias y de terceros para fines analíticos y para mostrarte publicidad personalizada en base a un perfil elaborado a partir de tus hábitos de navegación (por ejemplo, páginas visitadas). Puedes aceptar o rechazar todas las cookies pulsando el botón correspondiente o configurarlas mediante el enlace Configuración de cookies. Para más información clica AQUÍ.";
    Assert.assertEquals(
      formatTextForComparing(textoEncontrado),
      formatTextForComparing(textoBuscado)
    );
  }

  public static void checkBoxClick(WebDriver driver, String cssSelector) {
    sleep();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript(
      "const checkbox = document.querySelector('" + cssSelector + "');checkbox.click();"
    );
  }

  public static void validateButtonsCookies(WebDriver driver) {
    CommonMethods.sleep();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (
      CommonMethods.waitForElementToBeClickable(
        driver,
        driver.findElement(By.id(acceptCoockieId))
      ) !=
      null
    ) {
      driver.findElement(By.id(acceptCoockieId)).isDisplayed();
      driver.findElement(By.id(rejectCoockieId)).isDisplayed();
    } else {}
  }

  public void assertText(WebDriver driver, String locator, String expectedText) {
    WebElement element = driver.findElement(By.id(locator));
    String actualText = element.getText();
    Assert.assertEquals(
      formatTextForComparing(actualText),
      formatTextForComparing(expectedText),
      "El texto no coincide!"
    );
  }

  public Boolean assertElementIsPresent(WebDriver driver, WebElement element) {
    Assert.assertTrue(element.isDisplayed(), "El elemento no está presente!");
    return null;
  }

  public void assertElementIsEnabled(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.id(locator)); // Only catch the element by id
    Assert.assertTrue(element.isEnabled(), "El elemento no está presente!");
  }

  // WAIT METHODS
  public static WebElement waitForElementToBeClickable(
    WebDriver driver,
    WebElement element
  ) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    return wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public static WebElement waitForElementToBeVisible(
    WebDriver driver,
    WebElement element
  ) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static boolean webElementExists(WebDriver driver, String cssSelector) {
    try {
      driver.findElement(By.cssSelector(cssSelector));
      return true;
    } catch (NoSuchElementException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean webElementExistsInContainer(
    WebElement webElement,
    String cssSelector
  ) {
    try {
      webElement.findElement(By.cssSelector(cssSelector));
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public static WebElement getWebElementIfExistsInContainer(
    WebElement webElement,
    String cssSelector
  ) {
    try {
      WebElement element = webElement.findElement(By.cssSelector(cssSelector));
      return element;
    } catch (Exception e) {
      return null;
    }
  }

  public static WebElement getWebElementIfExists(WebDriver driver, String cssSelector) {
    try {
      WebElement element = driver.findElement(By.cssSelector(cssSelector));
      return element;
    } catch (Exception e) {
      return null;
    }
  }

  public static void waitSecs(int secs) {
    try {
      Thread.sleep(secs * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  //click methods
  public void AcceptCookies(WebDriver driver) {
    CommonMethods.sleep();
    if (
      waitForElementToBeClickable(driver, driver.findElement(By.id(acceptCoockieId))) !=
      null
    ) {
      driver.findElement(By.id(acceptCoockieId)).click();
    } else {}
  }

  public static void rejectCookies(WebDriver driver) {
    CommonMethods.sleep();
    if (
      waitForElementToBeClickable(driver, driver.findElement(By.id(rejectCoockieId))) !=
      null
    ) {
      driver.findElement(By.id(rejectCoockieId)).click();
    } else {}
  }

  public void actionClick(WebDriver driver, WebElement element) {
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().build().perform();
  }

  public void jsClick(WebDriver driver, WebElement element) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", element);
  }

  public static void scrollInToView(WebDriver driver, WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
  }

  public void scrollUpInToView(WebDriver driver, WebElement element) {
    // Hacer scroll hasta el elemento
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView(true);",
        element
      );
  }

  //Random text
  private static final String ALPHABET =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  private static final SecureRandom RANDOM = new SecureRandom();

  public static String generateRandomText(int length) {
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomIndex = RANDOM.nextInt(ALPHABET.length());
      sb.append(ALPHABET.charAt(randomIndex));
    }
    return sb.toString();
  }

  public static String generateRandomNameLastname(int length) {
    StringBuilder name = new StringBuilder(length);
    StringBuilder lastname = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomIndex = RANDOM.nextInt(ALPHABET.length());
      name.append(ALPHABET.charAt(randomIndex));
    }

    for (int i = 0; i < length; i++) {
      int randomIndex = RANDOM.nextInt(ALPHABET.length());
      lastname.append(ALPHABET.charAt(randomIndex));
    }
    return name + " " + lastname;
  }

  private static String generateRandomString(int length) {
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomIndex = RANDOM.nextInt(ALPHABET.length());
      sb.append(ALPHABET.charAt(randomIndex));
    }
    return sb.toString();
  }

  public static String generateRandomId() {
    // Use a common email format with a random username and domain
    UUID randomUID = UUID.randomUUID();
    String id = randomUID.toString().replace("-", "_");
    return id;
  }

  public static String generateRandomEmail() {
    // Use a common email format with a random username and domain
    String username = generateRandomString(8);
    String domain = "example.com"; // You can replace this with your desired domain

    return username + "@" + domain;
  }

  public static String generateRandomPhoneNumber() {
    // Use a common phone number format with a random area code and digits
    String areaCode = generateRandomDigits(3);
    String phoneNumber = generateRandomDigits(7);

    return "(" + areaCode + ") " + phoneNumber;
  }

  private static String generateRandomDigits(int length) {
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomDigit = RANDOM.nextInt(10);
      sb.append(randomDigit);
    }
    return sb.toString();
  }

  // Formularios
  public static void cleanTextBox(WebElement elemento) {
    boolean charactersTextBox = true;
    String textBox = "";
    do {
      try {
        textBox = elemento.getAttribute("value");
      } catch (Exception e) {
        charactersTextBox = false;
      }
      if (textBox.length() > 0) {
        elemento.sendKeys(Keys.BACK_SPACE);
        elemento.sendKeys(Keys.DELETE);
      } else {
        charactersTextBox = false;
      }
    } while (charactersTextBox);
  }

  public static void checkContainsInfo(WebElement element, String[] texts) {
    for (String text : texts) {
      Assert.assertTrue(
        element.getText().contains(text),
        "El formulario no contiene la palabra:" + text
      );
    }
  }

  public static boolean compararHostYPath(String urlString1, String url2sString2) {
    try {
      return (
        new URL(urlString1).getHost().equals(new URL(url2sString2).getHost()) &&
        new URL(urlString1).getPath().equals(new URL(url2sString2).getPath())
      );
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static void sleep() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void sleep(int duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void breakpoint() {
    try {
      Thread.sleep(120000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static Boolean findElement(WebDriver driver, String locator, String type) {
    Boolean found = false;
    List<WebElement> elements = new ArrayList<WebElement>();
    switch (type) {
      case "id":
        elements = driver.findElements(By.id(locator));
        break;
      case "name":
        elements = driver.findElements(By.name(locator));
        break;
      case "className":
        elements = driver.findElements(By.className(locator));
        break;
      case "tagName":
        elements = driver.findElements(By.tagName(locator));
        break;
      case "xpath":
        elements = driver.findElements(By.xpath(locator));
        break;
      case "cssSelector":
        elements = driver.findElements(By.cssSelector("locatorValue"));
        break;
      default:
        break;
    }
    for (WebElement element : elements) {
      if (element.isDisplayed()) {
        found = true;
      }
    }
    return found;
  }

  public static int randomIntNoZero(int bits) {
    Random random = new Random();
    while (true) {
      int value = random.nextInt(bits);
      if (value != 0 && value < bits) {
        return value;
      }
    }
  }

  public static boolean isSelect(WebDriver driver, WebElement element) {
    // Check if the element's tag name is "select" (case-insensitive)
    return element.getTagName().toLowerCase().equals("select");
  }

  public static void validateCurrentPath(WebDriver driver, String expectedPath) {
    String urlActual = driver.getCurrentUrl();
    sleep(6000);
    if (expectedPath.contains("https:")) {
      Assert.assertEquals(
        urlActual,
        expectedPath,
        "La URL no coincide!:" + urlActual + ":" + expectedPath
      );
    } else {
      // Valida si la navegación fue exitosa comparando la URL actual con la esperada
      URL url;
      try {
        url = new URL(urlActual);
        String currentPath = url.getPath();
        Assert.assertEquals(
          currentPath,
          expectedPath,
          "La URL no coincide!:" + currentPath + ":" + expectedPath
        );
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void waitForElementToBeVisible(
    WebDriver driver,
    WebElement element,
    int seconds
  ) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static String formatTextForComparing(String text) {
    return text.replace("\n", "").replace(" ", "").toLowerCase();
  }
}
