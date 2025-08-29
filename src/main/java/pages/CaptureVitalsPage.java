package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CaptureVitalsPage extends BasePage {

    //locators
    @FindBy(id = "patient-search")
    private WebElement patientSearchInput;

    @FindBy(xpath = "//h2[contains(text(),'Capture Vitals')]")
    private WebElement captureVitalsHeader;

    public CaptureVitalsPage(WebDriver driver) {
        super(driver);
    }

    public void searchPatient(String patientName) {
        patientSearchInput.clear();
        patientSearchInput.sendKeys(patientName);
    }

    public void enterPatientId(String patientId) {
        patientSearchInput.clear();
        patientSearchInput.sendKeys(patientId);
        Actions actions = new Actions(driver);
        actions.moveToElement(captureVitalsHeader).perform();

    }

    public void clickOnPatientRecord(String patientName) {
        WebElement patientRecord = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '" + patientName + "')]")));
        patientRecord.click();

    }
    public void verifyPatientRecordDisplayed(String patientId) {
        WebElement patientRecord = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//td[contains(text(), '" + patientId + "')]")));
        if (!patientRecord.isDisplayed()) {
            throw new AssertionError("Patient record for " + patientId + " is not displayed.");
        }
    }

    public void verifyErrorMessageOnCaptureVitals(){

        WebElement errorMessage = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//td[contains(text(), 'No matching records found')]")));
        if (!errorMessage.isDisplayed()) {
            throw new AssertionError("Error message is not displayed for invalid patient ID.");
        }

    }





}
