package app.home.tests;

import com.example.tests.BaseTest;
import com.example.tests.PortalInstance;

import app.home.objects.HomePageObjects;
import app.home.objects.MastersAndProgramsObjects;
import app.home.objects.SearchResultsPageObjects;

import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class DownloadTracks extends BaseTest {

  public DownloadTracks() {
    super();
  }

  HomePageObjects homePage = new HomePageObjects(driver);

  @Test(dataProvider = "getParams")
  public void BTPW_1582(@Optional("chrome,desktop") String browser, String platform) {
    configureDriver(browser, platform);
    PortalInstance.getInstance().setUrl("home");
    driver.get(PortalInstance.getInstance().getUrl());
    homePage.AcceptCookies(driver);
    
  }
}
