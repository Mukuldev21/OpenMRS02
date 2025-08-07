package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    //Locators

    @FindBy(css = "div.logo a")
    public WebElement openMRSLogo;

    @FindBy(xpath = "//h4[contains(text(),'Logged')]")
    public WebElement loggedInUserText;

    @FindBy(css = "li.nav-item.identifier")
    public WebElement identifierMenuItem;

    @FindBy(css = "li.change-location")
    public WebElement changeLocationButton;

    @FindBy(css = "li.nav-item.logout")
    public WebElement logoutMenuItem;

    @FindBy(xpath = "//a[contains(@href,'coreapps.findPatient')]")
    public WebElement findPatientLink;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyLogoIsDisplayed() {
        if (!openMRSLogo.isDisplayed()) {
            throw new AssertionError("Home page is not displayed correctly.");
        }
        else
        {
            System.out.println("Home page is displayed correctly.");
        }
    }
    public void verifyLoggedInUser(String username) {
        String loggedInText = loggedInUserText.getText();
        if (!loggedInText.contains(username)) {
            throw new AssertionError("Logged in user does not match expected username: " + username);
        } else {
            System.out.println("Logged in user matches expected username: " + username);
        }
    }
    public void verifyLocationWard(String location){
        String loggedInText = loggedInUserText.getText();
        if (!loggedInText.contains(location)) {
            throw new AssertionError("Logged in user does not match expected location: " + location);
        } else {
            System.out.println("Logged in user matches expected location: " + location);
        }
    }

    public void verifyIdentifierMenuItemIsDisplayed() {
        if (!identifierMenuItem.isDisplayed()) {
            throw new AssertionError("Identifier menu item is not displayed.");
        } else {
            System.out.println("Identifier menu item is displayed.");
        }
    }

    public void verifyChangeLocationButtonIsDisplayed() {
        if (!changeLocationButton.isDisplayed()) {
            throw new AssertionError("Change location button is not displayed.");
        } else {
            System.out.println("Change location button is displayed.");
        }
    }

    public void clickLogoutMenuItem() {
        if (logoutMenuItem.isDisplayed()) {
            logoutMenuItem.click();
            System.out.println("Clicked on Logout menu item.");
        } else {
            throw new AssertionError("Logout menu item is not displayed.");
        }
    }

    public void waitTillPageIsLoaded() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.logo a")));
    }
    public void clickFindPatientLink() {
        findPatientLink.click();
    }


}
