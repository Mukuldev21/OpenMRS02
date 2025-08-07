Feature: Find Patient Record Functionality

  Background:
    Given The User is on the Login page
    When The User enters a valid username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage
    And The User should click on "Find Patient Record option" in the menu

  @smoke1
  Scenario: Successfully find a patient record by ID
    When The User enters a valid patient ID from jsondata file
    Then The patient record for patient ID should be displayed

  @smoke1
  Scenario Outline: Unsuccessful search for a patient record with invalid ID
    When The User enters an invalid patient ID "<patientID>"
    Then An error message should be displayed "No matching records found"

    Examples:
      | patientID   |
      | invalidID   |
      | 99999       |
