package steps;

import hooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ActiveVisitsPage;
import pages.CaptureVitalsPage;
import pages.HomePage;
import utils.StepErrorTracker;
import utils.StepTracker;

public class ActiveVisitsSteps {


    private WebDriver driver = hooks.CucumberHooks.getDriver();
    HomePage homePage = new HomePage(hooks.CucumberHooks.getDriver());
    private ActiveVisitsPage activeVisitsPage = new ActiveVisitsPage(driver);
    String patientId = CucumberHooks.activeVisitDetails.get("patient-id").getAsString();
    String patientName = CucumberHooks.activeVisitDetails.get("patient-name").getAsString();

    @And("The User should click on Active Visits option in the menu")
    public void theUserShouldClickOnActiveVisitsOptionInTheMenu() {
        StepTracker.setLastStepText("The User should click on Active Visits option in the menu");
        try{
            CucumberHooks.getScenarioTest().info("Clicking on Active Visits link in the menu");
            homePage.clickOnActiveVisitsLink();
            CucumberHooks.getScenarioTest().info("Verifying Active Visits page is displayed");
            activeVisitsPage.verifyActiveVisitsPageIsDisplayed();
        } catch (Exception e){
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User enters a valid patient ID from jsondata file in the Active Visits page")
    public void theUserEntersAValidPatientIDFromJsondataFileInTheActiveVisitsPage() {
        StepTracker.setLastStepText("The User enters a valid patient ID from jsondata file in the Active Visits page");
        try{
            CucumberHooks.getScenarioTest().info("Entering patient ID: " + patientId);
            activeVisitsPage.enterPatientIDInSearch(patientId);
        } catch (Exception e){
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }


    @Then("The active visit record for patient ID should be displayed")
    public void theActiveVisitRecordForPatientIDShouldBeDisplayed() {
        StepTracker.setLastStepText("The active visit record for patient Name should be displayed");
        try{
            CucumberHooks.getScenarioTest().info("Verifying patient record for Name: " + patientName);
            activeVisitsPage.verifyPatientInActiveVisitsPage(patientName);
        } catch (Exception e){
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("Clicks on the patient record to view details in the Active Visits page")
    public void clicksOnThePatientRecordToViewDetailsInTheActiveVisitsPage() {
        StepTracker.setLastStepText("Clicks on the patient record to view details in the Active Visits page");
        try{
            CucumberHooks.getScenarioTest().info("Clicking on patient from search results: " + patientName);
            activeVisitsPage.clickOnPatientFromSearchResults(patientName);
        } catch (Exception e){
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User enters an invalid patient ID {string} in the Active Visits page")
    public void theUserEntersAnInvalidPatientIDInTheActiveVisitsPage(String arg0) {

        StepTracker.setLastStepText("The User enters an invalid patient ID in the Active Visits page");
        try{
            CucumberHooks.getScenarioTest().info("Entering invalid patient ID: " + arg0);
            activeVisitsPage.enterPatientIDInSearch(arg0);
        } catch (Exception e){
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }

    }

    @Then("An error message should be displayed {string} in the Active Visits page")
    public void anErrorMessageShouldBeDisplayedInTheActiveVisitsPage(String arg0) {
        StepTracker.setLastStepText("An error message should be displayed in the Active Visits page");
        try{
            CucumberHooks.getScenarioTest().info("Verifying no patient found message is displayed");
            activeVisitsPage.noPatientFoundMessageIsDisplayed();
        } catch (Exception e){
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User enters a valid patient name from jsondata file in the Active Visits page")
    public void theUserEntersAValidPatientNameFromJsondataFileInTheActiveVisitsPage() {
        StepTracker.setLastStepText("The User enters a valid patient name from jsondata file in the Active Visits page");
        try{
            CucumberHooks.getScenarioTest().info("Entering patient Name: " + patientName);
            activeVisitsPage.enterPatientNameInSearch(patientName);
        } catch (Exception e){
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @Then("The active visit record for patient name should be displayed")
    public void theActiveVisitRecordForPatientNameShouldBeDisplayed() {
        StepTracker.setLastStepText("The active visit record for patient Name should be displayed");
        try{
            CucumberHooks.getScenarioTest().info("Verifying patient record for Name: " + patientName);
            activeVisitsPage.verifyPatientInActiveVisitsPage(patientName);
        } catch (Exception e){
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }
}
