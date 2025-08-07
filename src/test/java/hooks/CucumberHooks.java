package hooks;

  import com.aventstack.extentreports.ExtentReports;
  import com.aventstack.extentreports.ExtentTest;
  import io.cucumber.java.*;
  import org.openqa.selenium.OutputType;
  import org.openqa.selenium.TakesScreenshot;
  import org.openqa.selenium.WebDriver;
  import utils.*;
  import com.google.gson.JsonObject;

  import java.util.Map;
  import java.util.Properties;
  import java.util.concurrent.ConcurrentHashMap;

  import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String;

  public class CucumberHooks {

      private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
      private static final ThreadLocal<Integer> stepCounter = ThreadLocal.withInitial(() -> 0);
      public static Properties config;
      public static JsonObject loginDetails;
      public static JsonObject patientSearchDetails;

      private static final ExtentReports extent = ExtentReportManager.getInstance();
      private static final Map<String, ExtentTest> featureTestMap = new ConcurrentHashMap<>();
      private static final ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

      @Before
      public void setUp(Scenario scenario) {
          try {
              config = ConfigReader.loadProperties("src/test/resources/config/config.properties");
              loginDetails = ConfigReader.loadJsonConfig("src/test/resources/test_data/loginDetails.json");
              patientSearchDetails = ConfigReader.loadJsonConfig("src/test/resources/test_data/patientRecordForSearch.json");
                // Initialize WebDriver based on the configuration
              driver.set(DriverManager.getDriver(config));
          } catch (Exception e) {
              throw new RuntimeException("Failed to initialize WebDriver or load config", e);
          }
          getDriver().manage().window().maximize();

          String featureName = scenario.getUri().toString()
                  .substring(scenario.getUri().toString().lastIndexOf('/') + 1)
                  .replace(".feature", "");

          stepCounter.set(0);
          ExtentTest featureTest = featureTestMap.computeIfAbsent(featureName, k -> extent.createTest(featureName));
          String highlightedName = "<span style='color:#fff; font-weight:bold;'>" + scenario.getName() + "</span>";
          ExtentTest scenarioNode = featureTest.createNode(highlightedName);
          scenarioTest.set(scenarioNode);
      }

      @AfterStep
      public void afterStep(Scenario scenario) {
          stepCounter.set(stepCounter.get() + 1);
          String currentStepNumber = "Step " + stepCounter.get();
          String stepInfo = StepTracker.getLastStepText();
          if (stepInfo == null || stepInfo.isEmpty()) {
              stepInfo = "Step execution in progress .... ";
          }

          ExtentTest scenarioNode = scenarioTest.get();
          if (scenarioNode == null) return;

          try {
              String base64Screenshot = captureScreenshotAsBase64();
              if (scenario.isFailed()) {
                  String error = StepErrorTracker.getLastError();
                  if (base64Screenshot != null) {
                      scenarioNode.fail(currentStepNumber + ": " + stepInfo,
                              createScreenCaptureFromBase64String(base64Screenshot).build());
                  } else {
                      scenarioNode.fail(currentStepNumber + ": " + stepInfo);
                  }
                  if (error != null) {
                      scenarioNode.fail("<br><pre style='color:#ff5252; background:#212121;'>" + error + "</pre>");
                  }
              } else {
                  if (base64Screenshot != null) {
                      scenarioNode.pass(currentStepNumber + ": " + stepInfo,
                              createScreenCaptureFromBase64String(base64Screenshot).build());
                  } else {
                      scenarioNode.pass(currentStepNumber + ": " + stepInfo);
                  }
              }
          } catch (Exception e) {
              scenarioNode.warning("Could not attach screenshot or log step: " + e.getMessage());
          }
      }

      @After
      public void tearDown(Scenario scenario) {
          ExtentTest scenarioNode = scenarioTest.get();
          if (scenarioNode != null) {
              if (scenario.isFailed()) {
                  scenarioNode.fail("<span style='color:#F44336;'>❌ Scenario failed: " + scenario.getName() + "</span>");
              } else {
                  scenarioNode.pass("<span style='color:#4CAF50;'>✅ Scenario passed: " + scenario.getName() + "</span>");
              }
          }
          WebDriver webDriver = getDriver();
          if (webDriver != null) {
              DriverManager.quitDriver(webDriver);
              driver.remove();
          }
          extent.flush();
          scenarioTest.remove();
          stepCounter.remove();
      }

      public static WebDriver getDriver() {
          return driver.get();
      }

      private String captureScreenshotAsBase64() {
          try {
              WebDriver webDriver = getDriver();
              if (webDriver instanceof TakesScreenshot) {
                  return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
              }
          } catch (Exception ignored) {}
          return null;
      }

      public static ExtentTest getScenarioTest() {
          return scenarioTest.get();
      }
  }