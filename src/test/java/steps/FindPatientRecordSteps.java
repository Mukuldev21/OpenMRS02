package steps;

import hooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PatientRecordPage;
import utils.StepErrorTracker;
import utils.StepTracker;

public class FindPatientRecordSteps {

    private WebDriver driver = hooks.CucumberHooks.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);
    private PatientRecordPage patientRecordPage = new PatientRecordPage(driver);

    @When("The User enters a valid patient ID from jsondata file")
    public void the_user_enters_a_valid_patient_id_from_jsondata_file() {
        StepTracker.setLastStepText("The User enters a valid patient ID from jsondata file");
        String patientId = CucumberHooks.patientSearchDetails.get("patient-id").getAsString();
        try {
            CucumberHooks.getScenarioTest().info("Entering patient ID: " + patientId);
            patientRecordPage.enterPatientId(patientId);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }


    }
    @Then("The patient record for patient ID should be displayed")
    public void the_patient_record_for_patient_id_should_be_displayed() {
        StepTracker.setLastStepText("The patient record for patient ID should be displayed");
        String patientId = CucumberHooks.patientSearchDetails.get("patient-id").getAsString();
        try {
            CucumberHooks.getScenarioTest().info("Verifying patient record for ID: " + patientId);
            patientRecordPage.verifyPatientRecordDisplayed(patientId);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }

    }

    @And("The User should click on {string} in the menu")
    public void theUserShouldClickOnFindPatientRecordOptionInTheMenu(String arg0) {

        StepTracker.setLastStepText("The User should click on Find Patient Record option in the menu");
        try {
            homePage.clickFindPatientLink();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User enters an invalid patient ID {string}")
    public void theUserEntersAnInvalidPatientID(String arg0) {
        StepTracker.setLastStepText("The User enters an invalid patient ID");
        try {
            CucumberHooks.getScenarioTest().info("Entering invalid patient ID: " + arg0);
            patientRecordPage.enterPatientId(arg0);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }

    }

    @Then("An error message should be displayed {string}")
    public void anErrorMessageShouldBeDisplayed(String arg0) {
        StepTracker.setLastStepText("An error message should be displayed");
        try {
            CucumberHooks.getScenarioTest().info("Verifying error message: " + arg0);
            patientRecordPage.verifyErrorMessage(arg0);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }

    }
}
