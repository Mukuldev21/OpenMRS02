package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.id;

public class LoginPage extends BasePage {

    //Locators

    @FindBy(css = "div.logo a")
    public WebElement openMRSLogo;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void verifyOpenMRSLogoIsDisplayed() {
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("openmrs")));
        if (!openMRSLogo.isDisplayed()) {
            throw new AssertionError("OpenMRS logo is not displayed.");
        } else {
            System.out.println("OpenMRS logo is displayed correctly.");
        }
    }


    public void verifyLoginPageIsDisplayed() {
        if (!usernameInput.isDisplayed() || !passwordInput.isDisplayed() || !loginButton.isDisplayed()) {
            throw new AssertionError("Login page is not displayed correctly.");
        } else {
            System.out.println("Login page is displayed correctly.");
        }
    }

    public void selectSessionLocation(String location) {
        List<WebElement> sessionLocations = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#sessionLocation li")));
        for (WebElement locationElement : sessionLocations) {
            if (locationElement.getText().equals(location)) {
                wait.until(ExpectedConditions.elementToBeClickable(locationElement)).click();
                System.out.println("Selected session location: " + location);
                break;
            }
        }
    }

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void verifyErrorMessageIsDisplayed() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-danger")));
        String actualMessage = errorMessageElement.getText().trim();
        Assert.assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed.");
        System.out.println("Error message is displayed: " + actualMessage);
    }

    public void verifySessionLocationErrorMessageIsDisplayed() {
        WebElement sessionLocationErrorElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sessionLocationError")));
        String actualMessage = sessionLocationErrorElement.getText().trim();
        Assert.assertTrue(sessionLocationErrorElement.isDisplayed(), "Session location error message is not displayed.");
        System.out.println("Session location error message is displayed: " + actualMessage);
    }

    public void verifySelectedLocationIsDisplayed(String location) {
        WebElement selectedLocationElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+ location +"')]"))
        );

        String actualLocation = selectedLocationElement.getText().trim();
        Assert.assertEquals(actualLocation, location, "Selected location does not match.");
        System.out.println("Selected location is displayed correctly: " + actualLocation);
    }

    public void clickHelpLink(){
        WebElement helpLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='cantLogin']")));
        helpLink.click();
    }

    public void verifyHelpLinkMessageIsDisplayed(){
        WebElement helpMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.dialog-instructions")));
        String actualMessage = helpMessageElement.getText().trim();
        Assert.assertTrue(helpMessageElement.isDisplayed(), "Please contact your System Administrator.");
        System.out.println("Help message is displayed: " + actualMessage);
    }

    public void clickHelpLinkOkayButton(){
        WebElement okayButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Okay']")));
        if(!okayButton.isDisplayed()){
            throw new AssertionError("Okay button not displayed.");
        }
        okayButton.click();

    }






}
