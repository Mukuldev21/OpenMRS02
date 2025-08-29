package steps;

import hooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CaptureVitalsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.StepErrorTracker;
import utils.StepTracker;

public class CaptureVitalsSteps {

    private WebDriver driver = hooks.CucumberHooks.getDriver();
    HomePage homePage = new HomePage(hooks.CucumberHooks.getDriver());
    private CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage(driver);
    String patientId = CucumberHooks.patientCaptureVitals.get("patient-id").getAsString();

    @When("The User enters a valid patient ID from jsondata file in the Capture Vitals page")
    public void theUserEntersAValidPatientIDFromJsondataFileInTheCaptureVitalsPage() {
        StepTracker.setLastStepText("The User enters a valid patient ID from jsondata file in the Capture Vitals page");
        try {
            CucumberHooks.getScenarioTest().info("Entering patient ID: " + patientId);
            captureVitalsPage.enterPatientId(patientId);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @Then("The patient record for patient ID should be displayed in the Capture Vitals page")
    public void thePatientRecordForPatientIDShouldBeDisplayedInTheCaptureVitalsPage() {
        StepTracker.setLastStepText("The patient record for patient ID should be displayed in the Capture Vitals page");
        try {
            CucumberHooks.getScenarioTest().info("Verifying patient record for ID: " + patientId);
            captureVitalsPage.verifyPatientRecordDisplayed(patientId);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("The User should click on the Capture Vitals option in the menu")
    public void theUserShouldClickOnTheCaptureVitalsOptionInTheMenu() {
        StepTracker.setLastStepText("The User should click on the Capture Vitals option in the menu");
        try {
            homePage.clickOnCaptureVitalsLink();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User enters an invalid patient ID {string} in the Capture Vitals page")
    public void theUserEntersAnInvalidPatientIDInTheCaptureVitalsPage(String arg0) {
        StepTracker.setLastStepText("The User enters an invalid patient ID in the Capture Vitals page");
        try {
            CucumberHooks.getScenarioTest().info("Entering invalid patient ID: " + arg0);
            captureVitalsPage.enterPatientId(arg0);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }

    }

    @Then("An error message should be displayed {string} in the Capture Vitals page")
    public void anErrorMessageShouldBeDisplayedInTheCaptureVitalsPage(String arg0) {
        StepTracker.setLastStepText("An error message should be displayed in the Capture Vitals page");
        try {
            CucumberHooks.getScenarioTest().info("Verifying error message: " + arg0);
            captureVitalsPage.verifyErrorMessageOnCaptureVitals();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }
}
