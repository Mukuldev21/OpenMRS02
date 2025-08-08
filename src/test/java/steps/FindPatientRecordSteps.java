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

    @When("The User enters a valid patient name from jsondata file")
    public void theUserEntersAValidPatientNameFromJsondataFile() {
        StepTracker.setLastStepText("The User enters a valid patient name from jsondata file");
        String patientName = CucumberHooks.patientSearchDetails.get("patient-name").getAsString();
        try {
            CucumberHooks.getScenarioTest().info("Entering patient name: " + patientName);
            patientRecordPage.searchPatient(patientName);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
        
    }

    @Then("The patient record for the name should be displayed")
    public void thePatientRecordForTheNameShouldBeDisplayed() {
        StepTracker.setLastStepText("The patient record for the name should be displayed");
        String patientName = CucumberHooks.patientSearchDetails.get("patient-name").getAsString();
        try {
            CucumberHooks.getScenarioTest().info("Verifying patient record for name: " + patientName);
            patientRecordPage.verifyPatientRecordDisplayed(patientName);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
        
    }

    @And("Clicks on the patient record to view details")
    public void clicksOnThePatientRecordToViewDetails() {
        StepTracker.setLastStepText("Clicks on the patient record to view details");
        String patientName = CucumberHooks.patientSearchDetails.get("patient-name").getAsString();
        try {
            CucumberHooks.getScenarioTest().info("Clicking on patient record for: " + patientName);
            patientRecordPage.verifyPatientNameDisplayed(patientName);
            patientRecordPage.clickOnPatientRecord(patientName);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
        
    }

    @Then("The patient record for the name should be displayed on the Patient Details page")
    public void thePatientRecordForTheNameShouldBeDisplayedOnThePatientDetailsPage() {
        StepTracker.setLastStepText("The patient record for the name should be displayed on the Patient Details page");
        //String patientName = CucumberHooks.patientSearchDetails.get("patient-name").getAsString();
        String patientId = CucumberHooks.patientSearchDetails.get("patient-id").getAsString();
        try {
            CucumberHooks.getScenarioTest().info("Verifying patient details for: " + patientId);
            patientRecordPage.verifyPatientIdDisplayedOnRecordPage(patientId);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
        
    }

    @And("The patient details should match the details from jsondata file")
    public void thePatientDetailsShouldMatchTheDetailsFromJsondataFile() {
        StepTracker.setLastStepText("The patient details should match the details from jsondata file");
        String patientId = CucumberHooks.patientSearchDetails.get("patient-id").getAsString();
        String weight = CucumberHooks.patientSearchDetails.get("weight").getAsString();
        String height = CucumberHooks.patientSearchDetails.get("height").getAsString();
        String temperature = CucumberHooks.patientSearchDetails.get("temperature").getAsString();
        String systolicBloodPressure = CucumberHooks.patientSearchDetails.get("systolic-blood-pressure").getAsString();
        String diastolicBloodPressure = CucumberHooks.patientSearchDetails.get("diastolic-blood-pressure").getAsString();
        String conditions = CucumberHooks.patientSearchDetails.get("conditions").getAsString();

        try {
            CucumberHooks.getScenarioTest().info("Verifying patient details for ID: " + patientId);
            patientRecordPage.verifyDetailsOnPatientRecordPage(patientId, weight, height, temperature, systolicBloodPressure, diastolicBloodPressure, conditions);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }
}
