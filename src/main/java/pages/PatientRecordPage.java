package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PatientRecordPage extends BasePage {


    @FindBy(id = "patient-search")
    public WebElement patientSearchInput;

    @FindBy(xpath ="//h2[contains(text(),'Find Patient ')]")
    public WebElement findPatientHeader;


    public PatientRecordPage(WebDriver driver) {
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
        actions.moveToElement(findPatientHeader).perform();

    }

    public void clickOnPatientRecord(String patientName) {
        WebElement patientRecord = driver.findElement(By.xpath("//td[contains(text(), '" + patientName + "')]"));
        patientRecord.click();

    }

    public void verifyPatientRecordDisplayed(String patientId) {
        WebElement patientRecord = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '" + patientId + "')]")));
        if (!patientRecord.isDisplayed()) {
            throw new AssertionError("Patient record for " + patientId + " is not displayed.");
        }
    }

    public void verifyErrorMessage(String arg0) {
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'No matching records found')]")));
        if (!errorMessage.isDisplayed() || !errorMessage.getText().contains(arg0)) {
            throw new AssertionError("Expected error message not displayed: " + arg0);
        }
    }
}
