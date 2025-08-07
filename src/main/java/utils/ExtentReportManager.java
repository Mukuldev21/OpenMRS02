package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
            // In ExtentReportManager.java, after extent.attachReporter(spark);
            try {
                Files.copy(Paths.get("src/test/resources/extent-custom.css"),
                           Paths.get(reportPath).getParent().resolve("extent-custom.css"),
                           StandardCopyOption.REPLACE_EXISTING);
                Files.copy(Paths.get("src/test/resources/extent-custom.js"),
                           Paths.get(reportPath).getParent().resolve("extent-custom.js"),
                           StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return extent;
    }
}