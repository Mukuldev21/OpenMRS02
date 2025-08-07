package tests;

import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties config;
    protected JsonObject loginDetails;


    @BeforeTest
    public void setup() {
        config = ConfigReader.loadProperties("src/test/resources/config/config.properties");
        loginDetails = ConfigReader.loadJsonConfig("src/test/resources/test_data/loginDetails.json");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseUrl"));
        LoginPage loginPage = new LoginPage(driver);

    }

    @Test
    public void initialTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        String username = loginDetails.get("username").getAsString();
        String password = loginDetails.get("password").getAsString();
        String location = loginDetails.get("location").getAsString();

        loginPage.verifyOpenMRSLogoIsDisplayed();
        loginPage.verifyLoginPageIsDisplayed();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.selectSessionLocation(location);



        loginPage.clickLoginButton();
        Thread.sleep(5000);

        homePage.verifyLogoIsDisplayed();
        homePage.verifyLoggedInUser(username);
        homePage.verifyLocationWard(location);
        homePage.verifyIdentifierMenuItemIsDisplayed();
        homePage.verifyChangeLocationButtonIsDisplayed();
        homePage.clickLogoutMenuItem();

        Thread.sleep(5000);

        loginPage.verifyLoginPageIsDisplayed();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
