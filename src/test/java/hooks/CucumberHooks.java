package hooks;

import com.google.gson.JsonObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverManager;

import java.util.Properties;

public class CucumberHooks {


    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static Properties config;
    public static JsonObject loginDetails;

    @Before
    public void setUp(){

        try {
            config = ConfigReader.loadProperties("src/test/resources/config/config.properties");
            loginDetails = ConfigReader.loadJsonConfig("src/test/resources/test_data/loginDetails.json");
            driver.set(DriverManager.getDriver(config));
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver or load config", e);
        }

        getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (getDriver() != null) {
            DriverManager.quitDriver(getDriver());
        }
    }
}
