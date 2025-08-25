Feature: Find Patient Record Functionality

  Background:
    Given The User is on the Login page
    When The User enters a valid username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage
    And The User should click on "Find Patient Record option" in the menu

  @smoke @findPatientRecord @regression
  Scenario: Successfully find a patient record by ID
    When The User enters a valid patient ID from jsondata file
    Then The patient record for patient ID should be displayed

  @smoke @findPatientRecord @regression
  Scenario Outline: Unsuccessful search for a patient record with invalid ID
    When The User enters an invalid patient ID "<patientID>"
    Then An error message should be displayed "No matching records found"

    Examples:
      | patientID   |
      | invalidID   |
      | 99999       |

    @regression @findPatientRecord
  Scenario: Successfully find a patient record by name and match all details from jsondata file
    When The User enters a valid patient name from jsondata file
    Then The patient record for patient ID should be displayed
    And Clicks on the patient record to view details
    Then The patient record for the name should be displayed on the Patient Details page
    And The patient details should match the details from jsondata file

  @startVisit
  Scenario: Start visit for the patient from record found by ID and admit to inpatient
    When The User enters a valid patient ID from jsondata file
    Then The patient record for the name should be displayed
    And Clicks on the patient record to view details
    Then The patient record for the name should be displayed on the Patient Details page
    When The User clicks on Start Visit button
    And The User clicks on the Confirm Start Visit button
    Then The visit should be started successfully
    And The user clicks on the admit to inpatient button
    And The User selects a location from the dropdown
    And The User clicks on the Save button to admit the patient
    Then The patient should be admitted successfully
    And The user clicks on End Visit button
    And The User clicks on the Yes button to End Visit
    Then The visit should be ended successfully