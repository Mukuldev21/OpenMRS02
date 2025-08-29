package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActiveVisitsPage extends BasePage {

    //Locators
    @FindBy(xpath = "//ul[@id='breadcrumbs']/li[2][contains(., 'Active Visits')]")
    public WebElement activeVisitsPageBreadcrumbs;

    @FindBy(xpath = "//h3[contains(text(), 'Active Visits')]")
    public WebElement activeVisitsHeader;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchPatientInput;


    public ActiveVisitsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyActiveVisitsPageIsDisplayed() {
        if (!activeVisitsPageBreadcrumbs.isDisplayed()) {
            throw new AssertionError("Active Visits page is not displayed correctly.");
        } else {
            System.out.println("Active Visits page is displayed correctly.");
        }
        if(!activeVisitsHeader.isDisplayed()){
            throw new AssertionError("Active Visits header is not displayed correctly.");
        } else {
            System.out.println("Active Visits header is displayed correctly.");
        }
    }

    public void enterPatientNameInSearch(String patientName) {
        searchPatientInput.clear();
        searchPatientInput.sendKeys(patientName);
        System.out.println("Entered patient name in search: " + patientName);
    }

    public void enterPatientIDInSearch(String patientID) {
        searchPatientInput.clear();
        searchPatientInput.sendKeys(patientID);
        System.out.println("Entered patient ID in search: " + patientID);
    }

    public void clickOnPatientFromSearchResults(String patientName) {
        WebElement patientLink = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[contains(text(), '"+ patientName +"')]")));
        patientLink.click();
        System.out.println("Clicked on patient from search results: " + patientName);
    }

    public void noPatientFoundMessageIsDisplayed() {
        WebElement noPatientMessage = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//td[contains(text(), 'No entries to display')]")));
        if (!noPatientMessage.isDisplayed()) {
            throw new AssertionError("No patient found message is not displayed.");
        } else {
            System.out.println("No patient found message is displayed correctly.");
        }
    }


    public void verifyPatientInActiveVisitsPage(String patientName) {
        WebElement patientLink = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//ul[@id='breadcrumbs']/li[2][contains(., '"+ patientName +"')]")));
        if (!patientLink.isDisplayed()) {
            throw new AssertionError("Patient " + patientName + " is not displayed in Active Visits page.");
        } else {
            System.out.println("Patient " + patientName + " is displayed in Active Visits page.");
        }
    }



}
