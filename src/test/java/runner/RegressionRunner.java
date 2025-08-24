package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/features/Login.feature",
                    "src/test/java/features/RegisterPatient.feature",
                    "src/test/java/features/FindPatientRecord.feature"},
        glue = {"steps", "hooks"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"},
        monochrome = true,
        tags = "@regression"
)
public class RegressionRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
