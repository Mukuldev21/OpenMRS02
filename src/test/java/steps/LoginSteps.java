package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    private WebDriver driver = hooks.CucumberHooks.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);

    @Given("The User is on the Login page")
    public void the_user_is_on_the_login_page() {
        driver.get(hooks.CucumberHooks.config.getProperty("baseUrl"));
        loginPage.verifyLoginPageIsDisplayed();
    }

    @When("The User enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        String username = hooks.CucumberHooks.loginDetails.get("username").getAsString();
        String password = hooks.CucumberHooks.loginDetails.get("password").getAsString();
        String location = hooks.CucumberHooks.loginDetails.get("location").getAsString();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.selectSessionLocation(location);
    }

    @When("The User clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
       // homePage.waitTillPageIsLoaded();
    }

    @Then("The User should be redirected to the Homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        homePage.verifyLogoIsDisplayed();
        homePage.verifyLoggedInUser(hooks.CucumberHooks.loginDetails.get("username").getAsString());
        homePage.verifyLocationWard(hooks.CucumberHooks.loginDetails.get("location").getAsString());
        homePage.verifyIdentifierMenuItemIsDisplayed();
        homePage.verifyChangeLocationButtonIsDisplayed();
    }

    @When("The User enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.selectSessionLocation(hooks.CucumberHooks.loginDetails.get("location").getAsString());
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        loginPage.verifyErrorMessageIsDisplayed();
    }

    @When("The User leaves the username and password fields empty")
    public void the_user_leaves_the_username_and_password_fields_empty() {
        System.out.println("Leaving username and password fields empty");
    }
    @Then("An session error message should be displayed")
    public void an_session_error_message_should_be_displayed() {
        loginPage.verifySessionLocationErrorMessageIsDisplayed();
    }

    @When("The User clicks the logout button")
    public void theUserClicksTheLogoutButton() {
        homePage.clickLogoutMenuItem();
    }

    @Then("The User should be redirected to the Login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        loginPage.verifyLoginPageIsDisplayed();
        loginPage.verifyOpenMRSLogoIsDisplayed();
    }
}