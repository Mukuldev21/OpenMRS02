package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PatientRecordPage extends BasePage {


    @FindBy(id = "patient-search")
    public WebElement patientSearchInput;

    @FindBy(xpath = "//h2[contains(text(),'Find Patient ')]")
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
        WebElement patientRecord = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '" + patientName + "')]")));
        patientRecord.click();

    }

    public void verifyPatientRecordDisplayed(String patientId) {
        WebElement patientRecord = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '" + patientId + "')]")));
        if (!patientRecord.isDisplayed()) {
            throw new AssertionError("Patient record for " + patientId + " is not displayed.");
        }
    }
    public void verifyPatientIdDisplayedOnRecordPage(String patientId) {
        WebElement patientRecord = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(), '" + patientId + "')]")));
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

    public void verifyDetailsOnPatientRecordPage(String patientId, String Weight,
                                                 String Height, String Temperature, String SystolicBloodPressure,
                                                 String DiastolicBloodPressure, String Conditions) {

        WebElement patientRecord = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(), '" + patientId + "')]")));
        if (!patientRecord.isDisplayed()) {
            throw new AssertionError("Patient record for " + patientId + " is not displayed.");
        }

        WebElement weight = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(),'Weight')]/following-sibling::span/strong")));
        WebElement height = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(),'Height')]/following-sibling::span/strong")));
        WebElement temperature = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(),'Temperature')]/following-sibling::span/strong")));
        WebElement systolicBloodPressure = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(),'Systolic blood pressure')]/following-sibling::span/strong")));
        WebElement diastolicBloodPressure = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(),'Diastolic blood pressure')]/following-sibling::span/strong")));
        WebElement conditions = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h3[contains(text(),'CONDITIONS')]/following::span[contains(text(),'" + Conditions + "')]")));
        Assert.assertEquals(weight.getText(), Weight, "Weight does not match expected value.");
        Assert.assertEquals(height.getText(), Height, "Height does not match expected value.");
        Assert.assertEquals(temperature.getText(), Temperature, "Temperature does not match expected value.");
        Assert.assertEquals(systolicBloodPressure.getText(), SystolicBloodPressure, "Systolic blood pressure does not match expected value.");
        Assert.assertEquals(diastolicBloodPressure.getText(), DiastolicBloodPressure, "Diastolic blood pressure does not match expected value.");
        Assert.assertTrue(conditions.getText().contains(Conditions), "Conditions do not match expected value.");
    }

    public void verifyPatientNameDisplayed(String patientName) {
        WebElement patientNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '" + patientName + "')]")));
        if (!patientNameElement.isDisplayed()) {
            throw new AssertionError("Patient name " + patientName + " is not displayed.");
        }
    }
}
