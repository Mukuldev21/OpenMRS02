package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.IOException;


public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport/index.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            // Load custom Spark config
            String configPath = System.getProperty("user.dir") + "/src/test/resources/spark-config.html";
            try {
                spark.loadXMLConfig(configPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser", System.getProperty("browser", "chrome"));
            extent.setSystemInfo("Environment", System.getProperty("env", "test"));
        }
        return extent;
    }
}