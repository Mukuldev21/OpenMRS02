package steps;

import hooks.CucumberHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.StepErrorTracker;
import utils.StepTracker;

public class LoginSteps {

    private WebDriver driver = hooks.CucumberHooks.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);

    @Given("The User is on the Login page")
    public void the_user_is_on_the_login_page() {
        StepTracker.setLastStepText("Given The User is on the Login page");
        try {
            CucumberHooks.getScenarioTest().info("Navigating to Login page");
            driver.get(CucumberHooks.config.getProperty("baseUrl"));
            loginPage.verifyLoginPageIsDisplayed();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        StepTracker.setLastStepText("When The User enters a valid username and password");
        try {
            CucumberHooks.getScenarioTest().info("Entering valid username and password");
            String username = CucumberHooks.loginDetails.get("username").getAsString();
            String password = CucumberHooks.loginDetails.get("password").getAsString();
            String location = CucumberHooks.loginDetails.get("location").getAsString();
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.selectSessionLocation(location);
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User clicks the login button")
    public void the_user_clicks_the_login_button() {
        StepTracker.setLastStepText("When The User clicks the login button");
        try {
            CucumberHooks.getScenarioTest().info("Clicking login button");
            loginPage.clickLoginButton();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @Then("The User should be redirected to the Homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        StepTracker.setLastStepText("Then The User should be redirected to the Homepage");
        try {
            CucumberHooks.getScenarioTest().info("Verifying homepage redirection");
            homePage.verifyLogoIsDisplayed();
            homePage.verifyLoggedInUser(CucumberHooks.loginDetails.get("username").getAsString());
            homePage.verifyLocationWard(CucumberHooks.loginDetails.get("location").getAsString());
            homePage.verifyIdentifierMenuItemIsDisplayed();
            homePage.verifyChangeLocationButtonIsDisplayed();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        StepTracker.setLastStepText("When The User enters \"" + username + "\" and \"" + password + "\"");
        try {
            CucumberHooks.getScenarioTest().info("Entering username: " + username + " and password: " + password);
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.selectSessionLocation(CucumberHooks.loginDetails.get("location").getAsString());
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        StepTracker.setLastStepText("Then An error message should be displayed");
        try {
            CucumberHooks.getScenarioTest().info("Verifying error message is displayed");
            loginPage.verifyErrorMessageIsDisplayed();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User leaves the username and password fields empty")
    public void theUserLeavesTheUsernameAndPasswordFieldsEmpty() {
        StepTracker.setLastStepText("When The User leaves the username and password fields empty");
        try {
            CucumberHooks.getScenarioTest().info("Leaving username and password fields empty");
            System.out.println("Leaving username and password fields empty");
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @Then("An session error message should be displayed")
    public void anSessionErrorMessageShouldBeDisplayed() {
        StepTracker.setLastStepText("Then An session error message should be displayed");
        try {
            CucumberHooks.getScenarioTest().info("Verifying session error message is displayed");
            loginPage.verifySessionLocationErrorMessageIsDisplayed();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @When("The User clicks the logout button")
    public void theUserClicksTheLogoutButton() {
        StepTracker.setLastStepText("When The User clicks the logout button");
        try {
            CucumberHooks.getScenarioTest().info("Clicking logout button");
            homePage.clickLogoutMenuItem();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }

    @Then("The User should be redirected to the Login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        StepTracker.setLastStepText("Then The User should be redirected to the Login page");
        try {
            CucumberHooks.getScenarioTest().info("Verifying redirection to Login page");
            loginPage.verifyLoginPageIsDisplayed();
            loginPage.verifyOpenMRSLogoIsDisplayed();
        } catch (Exception e) {
            StepErrorTracker.setLastError(e.getMessage());
            throw e;
        }
    }


}