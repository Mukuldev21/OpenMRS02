Feature: Capture Vitals Functionality

  Background:
    Given The User is on the Login page
    When The User enters a valid username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage
    And The User should click on the Capture Vitals option in the menu

  @smoke @captureVitals @regression
  Scenario: Successfully capture vitals for a patient
    When The User enters a valid patient ID from jsondata file in the Capture Vitals page
    Then The patient record for patient ID should be displayed in the Capture Vitals page

   @smoke @captureVitals @regression
  Scenario Outline: Unsuccessful search for capture vitals with invalid ID
    When The User enters an invalid patient ID "<patientID>" in the Capture Vitals page
    Then An error message should be displayed "No matching records found" in the Capture Vitals page

    Examples:
      | patientID   |
      | invalidID   |
      | 99999       |