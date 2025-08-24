package steps;

import hooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPatientPage;
import utils.StepErrorTracker;
import utils.StepTracker;

public class RegisterPatientSteps {

    HomePage homePage = new HomePage(hooks.CucumberHooks.getDriver());
    RegisterPatientPage registerPatientPage = new RegisterPatientPage(hooks.CucumberHooks.getDriver());
    String GivenName = CucumberHooks.registerPatientDetails.get("GivenName").getAsString();
    String MiddleName = CucumberHooks.registerPatientDetails.get("MiddleName").getAsString();
    String FamilyName = CucumberHooks.registerPatientDetails.get("FamilyName").getAsString();
    String Gender = CucumberHooks.registerPatientDetails.get("Gender").getAsString();
    String birthdateDay = CucumberHooks.registerPatientDetails.get("birthdateDay").getAsString();
    String birthdateMonth = CucumberHooks.registerPatientDetails.get("birthdateMonth").getAsString();
    String birthdateYear = CucumberHooks.registerPatientDetails.get("birthdateYear").getAsString();
    String address1 = CucumberHooks.registerPatientDetails.get("address1").getAsString();
    String address2 = CucumberHooks.registerPatientDetails.get("address2").getAsString();
    String cityVillage = CucumberHooks.registerPatientDetails.get("cityVillage").getAsString();
    String stateProvince = CucumberHooks.registerPatientDetails.get("stateProvince").getAsString();
    String country = CucumberHooks.registerPatientDetails.get("country").getAsString();
    String postalCode = CucumberHooks.registerPatientDetails.get("postalCode").getAsString();
    String phoneNumber = CucumberHooks.registerPatientDetails.get("phoneNumber").getAsString();
    String relationship_type = CucumberHooks.registerPatientDetails.get("relationship_type").getAsString();
    String personName = CucumberHooks.registerPatientDetails.get("personName").getAsString();

    @And("The User should click on {string} option in the menu")
    public void theUserShouldClickOnRegisterPatientOptionInTheMenu(String option) {
        StepTracker.setLastStepText("The User should click on Register Patient option in the menu");
        try {
            CucumberHooks.getScenarioTest().info("Clicking on Register Patient option in the menu");
            homePage.clickOnRegisterPatientLink();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User enters a valid patient full name")
    public void theUserEntersAValidPatientFullName() {
        StepTracker.setLastStepText("The User enters a valid patient full name");
        try {
            CucumberHooks.getScenarioTest().info("Entering patient full name: " + GivenName + " " + MiddleName + " " + FamilyName);
            registerPatientPage.enterPatientName(GivenName, MiddleName, FamilyName);

        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("The User selects gender")
    public void theUserSelectsGender() {

        StepTracker.setLastStepText("The User selects gender");
        try{
            registerPatientPage.selectGender(Gender);
            CucumberHooks.getScenarioTest().info("The user selects Gender: " +Gender);

        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }

    }

    @And("The User enters date of birth")
    public void theUserEntersDateOfBirth() {
        StepTracker.setLastStepText("The User enters date of birth");
        try {
            CucumberHooks.getScenarioTest().info("Entering date of birth: " + birthdateDay + "/" + birthdateMonth + "/" + birthdateYear);
            registerPatientPage.enterDateOfBirth(birthdateDay, birthdateMonth, birthdateYear);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("The User enters contact info")
    public void theUserEntersContactInfo() {

        StepTracker.setLastStepText("The User enters contact info");
        try {
            CucumberHooks.getScenarioTest().info("Entering contact info: " + address1 + ", " + address2 + ", " + cityVillage + ", " + stateProvince + ", " + country + ", " + postalCode + ", " + phoneNumber);
            registerPatientPage.enterContactInfo(address1, address2, cityVillage, stateProvince, country, postalCode, phoneNumber);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("The User enters relationship info")
    public void theUserEntersRelationshipInfo() {
        StepTracker.setLastStepText("The User enters relationship info");
        try {
            CucumberHooks.getScenarioTest().info("Entering relationship info: " + relationship_type + ", " + personName);
            registerPatientPage.enterRelationshipInfo(relationship_type, personName);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("The User confirms registration")
    public void theUserConfirmsRegistration() {
        StepTracker.setLastStepText("The User confirms registration");
        try {
            CucumberHooks.getScenarioTest().info("Confirming patient registration");
            registerPatientPage.confirmRegistration();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }


    @Then("The patient name should be displayed on the Patient Details page")
    public void thePatientNameShouldBeDisplayedOnThePatientDetailsPage() {
        StepTracker.setLastStepText("The patient name should be displayed on the Patient Details page");
        try {
            CucumberHooks.getScenarioTest().info("Verifying patient name on the Patient Details page");
            registerPatientPage.isPatientNameDisplayed(GivenName, MiddleName, FamilyName);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @And("The User should click on Register a Patient option in the menu")
    public void theUserShouldClickOnRegisterAPatientOptionInTheMenu() {
        StepTracker.setLastStepText("The User should click on Register a Patient option in the menu");
        try {
            CucumberHooks.getScenarioTest().info("Clicking on Register a Patient option in the menu");
            homePage.clickOnRegisterPatientLink();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }
}
