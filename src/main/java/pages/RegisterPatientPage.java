package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage extends BasePage {



    public RegisterPatientPage(WebDriver driver) {
        super(driver);
    }

    public void enterPatientName(String Given, String Middle, String Family) {

        By GivenNameInput = By.name("givenName");
        By MiddleNameInput = By.name("middleName");
        By FamilyNameInput = By.name("familyName");
        By nextButton = By.id("next-button");

        wait.until(ExpectedConditions.presenceOfElementLocated(GivenNameInput)).sendKeys(Given);
        wait.until(ExpectedConditions.presenceOfElementLocated(MiddleNameInput)).sendKeys(Middle);
        wait.until(ExpectedConditions.presenceOfElementLocated(FamilyNameInput)).sendKeys(Family);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void selectGender(String Gender) {
        By genderDropdown = By.id("gender-field");
        By nextButton = By.id("next-button");

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(genderDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(Gender);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void enterDateOfBirth(String Day, String Month, String Year) {
        By birthdateDay = By.name("birthdateDay");
        By birthdateMonth = By.id("birthdateMonth-field");
        By birthdateYear = By.name("birthdateYear");
        By nextButton = By.id("next-button");

        wait.until(ExpectedConditions.presenceOfElementLocated(birthdateDay)).sendKeys(Day);

        WebElement monthDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(birthdateMonth));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(Month); // Month should be "1" to "12"

        wait.until(ExpectedConditions.presenceOfElementLocated(birthdateYear)).sendKeys(Year);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void enterContactInfo(String address1, String address2, String cityVillage, String stateProvince, String country, String postalCode, String phoneNumber) {
        By address1Input = By.id("address1");
        By address2Input = By.id("address2");
        By cityVillageInput = By.id("cityVillage");
        By stateProvinceInput = By.id("stateProvince");
        By countryInput = By.id("country");
        By postalCodeInput = By.id("postalCode");
       //
        By nextButton = By.id("next-button");

        wait.until(ExpectedConditions.presenceOfElementLocated(address1Input)).sendKeys(address1);
        wait.until(ExpectedConditions.presenceOfElementLocated(address2Input)).sendKeys(address2);
        wait.until(ExpectedConditions.presenceOfElementLocated(cityVillageInput)).sendKeys(cityVillage);
        wait.until(ExpectedConditions.presenceOfElementLocated(stateProvinceInput)).sendKeys(stateProvince);
        wait.until(ExpectedConditions.presenceOfElementLocated(countryInput)).sendKeys(country);
        wait.until(ExpectedConditions.presenceOfElementLocated(postalCodeInput)).sendKeys(postalCode);
        //wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberInput)).sendKeys(phoneNumber);

        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();

        By phoneNumberInput = By.name("phoneNumber");
        wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberInput)).sendKeys(phoneNumber);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void enterRelationshipInfo(String relationshipTypeValue, String personName) {
        By relationshipTypeDropdown = By.id("relationship_type");
        By personNameInput = By.cssSelector("input.person-typeahead");
        By nextButton = By.id("next-button");

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(relationshipTypeDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(relationshipTypeValue);

        wait.until(ExpectedConditions.presenceOfElementLocated(personNameInput)).sendKeys(personName);

        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void confirmRegistration() {
        By confirmButton = By.id("submit");
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    public boolean isPatientNameDisplayed(String Given, String Middle, String Family) {
        By patientNameLi = By.xpath("//li[contains(text(),'" + Given + " " + Middle + " " + Family + "')]");
        try {
            WebElement nameElement = wait.until(ExpectedConditions.presenceOfElementLocated(patientNameLi));
            String displayedName = nameElement.getText().trim();
            String expectedName = (Given + " " + Middle + " " + Family).trim();
            return displayedName.contains(expectedName);
        } catch (Exception e) {
            return false;
        }
    }








}
