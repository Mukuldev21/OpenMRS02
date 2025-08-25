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
    private String patientId = CucumberHooks.patientSearchDetails.get("patient-id").getAsString();
    private String patientName = CucumberHooks.patientSearchDetails.get("patient-name").getAsString();
    private String weight = CucumberHooks.patientSearchDetails.get("weight").getAsString();
    private String height = CucumberHooks.patientSearchDetails.get("height").getAsString();
    private String temperature = CucumberHooks.patientSearchDetails.get("temperature").getAsString();
    private String systolicBloodPressure = CucumberHooks.patientSearchDetails.get("systolic-blood-pressure").getAsString();
    private String diastolicBloodPressure = CucumberHooks.patientSearchDetails.get("diastolic-blood-pressure").getAsString();
    private String conditions = CucumberHooks.patientSearchDetails.get("conditions").getAsString();
    private String location = CucumberHooks.patientSearchDetails.get("location").getAsString();

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


        try {
            CucumberHooks.getScenarioTest().info("Verifying patient details for ID: " + patientId);
            patientRecordPage.verifyDetailsOnPatientRecordPage(patientId, weight, height, temperature, systolicBloodPressure, diastolicBloodPressure, conditions);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User clicks on Start Visit button")
    public void theUserClicksOnStartVisitButton() {

        StepTracker.setLastStepText("The User clicks on Start Visit button");
        try {
            CucumberHooks.getScenarioTest().info("Clicking on Start Visit button");
            patientRecordPage.clickOnStartVisit();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }


    @Then("The User clicks on the Confirm Start Visit button")
    public void theUserClicksOnTheConfirmStartVisitButton() {
        StepTracker.setLastStepText("The User clicks on the Confirm Start Visit button");
        try {
            CucumberHooks.getScenarioTest().info("Verifying Confirm Start Visit popup is displayed");
            patientRecordPage.verifyStartAVisitMenu();
            CucumberHooks.getScenarioTest().info("Verifying Start A Visit message is displayed");
            patientRecordPage.verifyStartAVisitMessage(patientName);
            CucumberHooks.getScenarioTest().info("Clicking on Confirm Start Visit button");
            patientRecordPage.clickOnConfirmButton();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }

    }

    @Then("The visit should be started successfully")
    public void theVisitShouldBeStartedSuccessfully() {
        StepTracker.setLastStepText("The visit should be started successfully");
        try {
            CucumberHooks.getScenarioTest().info("Verifying visit is started successfully for patient ID: " + patientId);
            patientRecordPage.verifyVisitStarted(patientId);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }

    }

    @And("The user clicks on the admit to inpatient button")
    public void theUserClicksOnTheAdmitToInpatientButton() {
        StepTracker.setLastStepText("The user clicks on the admit to inpatient button");
        try {
            CucumberHooks.getScenarioTest().info("Clicking on Admit to Inpatient button");
            patientRecordPage.clickOnAdmitToInpatientWard();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }


    @And("The User selects a location from the dropdown")
    public void theUserSelectsALocationFromTheDropdown() {
        StepTracker.setLastStepText("The User selects a location from the dropdown");
        try {
            CucumberHooks.getScenarioTest().info("Selecting location: " + location);
            patientRecordPage.selectLocationWard(location);
         } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }


    @And("The User clicks on the Save button to admit the patient")
    public void theUserClicksOnTheSaveButtonToAdmitThePatient() {
        StepTracker.setLastStepText("The User clicks on the Save button to admit the patient");
        try {
            CucumberHooks.getScenarioTest().info("Clicking on Save button to admit the patient");
            patientRecordPage.clickOnSaveButtonToAdmitPatient();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @Then("The patient should be admitted successfully")
    public void thePatientShouldBeAdmittedSuccessfully() {
        StepTracker.setLastStepText("The patient should be admitted successfully");
        try {
            CucumberHooks.getScenarioTest().info("Verifying patient with patientID: " +patientId + " is admitted successfully to: " + location);
            patientRecordPage.verifyPatientAdmitted(patientId);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("The user clicks on End Visit button")
    public void theUserClicksOnEndVisitButton() {

        StepTracker.setLastStepText("The user clicks on End Visit button");
        try {
            CucumberHooks.getScenarioTest().info("Clicking on End Visit button");
            patientRecordPage.clickOnEndVisit();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("The User clicks on the Yes button to End Visit")
    public void theUserClicksOnTheYesButtonToEndVisit() {
        StepTracker.setLastStepText("The User clicks on the Yes button to End Visit");
        try {
            CucumberHooks.getScenarioTest().info("Verifying End Visit confirmation popup is displayed");
            patientRecordPage.verifyEndVisitMenu();
            CucumberHooks.getScenarioTest().info("Clicking on Yes button to End Visit");
            patientRecordPage.clickOnYesButtonToEndVisit();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @Then("The visit should be ended successfully")
    public void theVisitShouldBeEndedSuccessfully() {
        StepTracker.setLastStepText("The visit should be ended successfully");
        try {
            CucumberHooks.getScenarioTest().info("Verifying visit is ended successfully for patient ID: " + patientId);
            patientRecordPage.verifyVisitEnded(patientId);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }
}
