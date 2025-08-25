package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PatientRecordPage extends BasePage {


    @FindBy(id = "patient-search")
    private WebElement patientSearchInput;

    @FindBy(xpath = "//h2[contains(text(),'Find Patient ')]")
    private WebElement findPatientHeader;


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

    public void clickOnStartVisit() {
        WebElement startVisitButton = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[contains(text(),'Start Visit')]")));
        if (!startVisitButton.isDisplayed()) {
            throw new AssertionError("Start Visit button is not displayed.");
        }
        startVisitButton.click();
    }

    public void verifyStartAVisitMenu(){

        WebElement startAVisitMenu = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h3[contains(text(), 'Start a visit')]")));
        if (!startAVisitMenu.isDisplayed()) {
            throw new AssertionError("Start a visit menu is not displayed.");
        }
    }

    public void verifyStartAVisitMessage(String patientName){

        WebElement startAVisitMessage = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//p[contains(text(), 'start a visit')]")));
        if (!startAVisitMessage.isDisplayed()) {
            throw new AssertionError("Start a visit message is not displayed.");
        }
        Assert.assertTrue(startAVisitMessage.getText().contains(patientName), "Patient name in start a visit message does not match expected value.");
    }

    public void clickOnConfirmButton() {

        WebElement confirmButton = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//button[contains(@id,'visittype-confirm')]")));
        if (!confirmButton.isDisplayed()) {
            throw new AssertionError("Confirm button is not displayed.");
        }
        confirmButton.click();
    }

    public void clickOnCancelButton() {

        WebElement cancelButton = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//button[contains(@class,'cancel')]")));
        if (!cancelButton.isDisplayed()) {
            throw new AssertionError("Cancel button is not displayed.");
        }
        cancelButton.click();
    }

    //Verify that visit has started by checking for active visit message on Visits page
    public void verifyVisitStarted(String patientId) {

        /*
        WebElement visitStartedMessage = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='status-container']//span[@class='status active']")));
        if (!visitStartedMessage.isDisplayed() || !visitStartedMessage.getText().contains("Visit started")) {
            throw new AssertionError("Visit started message is not displayed.");
        }
            */
        WebElement admitToInpatientWardButton = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[contains(@id,'simpleAdmission')]")));
        if (!admitToInpatientWardButton.isDisplayed()) {
            throw new AssertionError("Admit to Inpatient Ward button is not displayed.");
        }

        WebElement patientRecord = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(), '" + patientId + "')]")));
        if (!patientRecord.isDisplayed()) {
            throw new AssertionError("Patient record for " + patientId + " is not displayed.");
        }
    }

   public void clickOnAdmitToInpatientWard(){
       WebElement admitToInpatientWardButton = wait.until(ExpectedConditions
               .presenceOfElementLocated(By.xpath("//a[contains(@id,'simpleAdmission')]")));
       if (!admitToInpatientWardButton.isDisplayed()) {
           throw new AssertionError("Admit to Inpatient Ward button is not displayed.");
       }
       admitToInpatientWardButton.click();
   }

   public void selectLocationWard(String locationWard){
       WebElement location = wait.until(ExpectedConditions
               .presenceOfElementLocated(By.xpath("//label[contains(text(),'Admitted to Ward/Service')]/following::select[@id='w5']")));
       if (!location.isDisplayed()) {
           throw new AssertionError("Location dropdown is not displayed.");
       }
       try {
           Select locationDropdown = new Select(location);
           locationDropdown.selectByVisibleText(locationWard);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }

   public void clickOnSaveButtonToAdmitPatient(){
       WebElement saveButton = wait.until(ExpectedConditions
               .presenceOfElementLocated(By.xpath("//input[contains(@value,'Save')]")));
       if (!saveButton.isDisplayed()) {
           throw new AssertionError("Save button is not displayed.");
       }
       saveButton.click();
   }

   public void verifyPatientAdmitted(String patientId) {

        /*
        WebElement admissionMessage = wait.until(ExpectedConditions
               .presenceOfElementLocated(By.xpath("//span[contains(text(),'Admission')]")));
       if (!admissionMessage.isDisplayed() || !admissionMessage.getText().contains("Admitted to Inpatient Ward")) {
           throw new AssertionError("Admission message is not displayed.");
       }
        */
       WebElement endVisitButton = wait.until(ExpectedConditions
               .presenceOfElementLocated(By.xpath("//a[contains(@href,'EndVisit')]")));
       if (!endVisitButton.isDisplayed()) {
           throw new AssertionError("End Visit button is not displayed.");
       }

       WebElement patientRecord = wait.until(ExpectedConditions
               .presenceOfElementLocated(By.xpath("//span[contains(text(), '" + patientId + "')]")));
       if (!patientRecord.isDisplayed()) {
           throw new AssertionError("Patient record for " + patientId + " is not displayed.");
       }
   }

    public void clickOnEndVisit() {
        WebElement endVisitButton = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[contains(@href,'EndVisit')]")));
        if (!endVisitButton.isDisplayed()) {
            throw new AssertionError("End Visit button is not displayed.");
        }
        endVisitButton.click();
    }

    public void verifyEndVisitMenu(){
        WebElement endVisitMenu = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h3[contains(text(), 'End Visit')]")));
        if (!endVisitMenu.isDisplayed()) {
            throw new AssertionError("End Visit menu is not displayed.");
        }
    }

    public void clickOnYesButtonToEndVisit(){
        WebElement yesButton = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("(//button[contains(@class, 'confirm right') and text()='Yes'])[3]")));
        if (!yesButton.isDisplayed()) {
            throw new AssertionError("Yes button is not displayed.");
        }
        yesButton.click();
    }


    public void verifyVisitEnded(String patientId) {

        WebElement visitEndedMessage = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h4[contains(text(), 'No active visit')]")));
        if (!visitEndedMessage.isDisplayed() || !visitEndedMessage.getText().contains("No active visit")) {
            throw new AssertionError("Visit ended message is not displayed.");
        }

        WebElement patientRecord = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(text(), '" + patientId + "')]")));
        if (!patientRecord.isDisplayed()) {
            throw new AssertionError("Patient record for " + patientId + " is not displayed.");
        }
    }
}
