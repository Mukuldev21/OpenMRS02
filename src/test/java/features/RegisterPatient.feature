Feature: Register Patient Functionality

  Background:
    Given The User is on the Login page
    When The User enters a valid username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage
    And The User should click on "Register a Patient" option in the menu

  @smoke1
  Scenario: Successfully register a new patient
    When The User enters a valid patient full name
    And The User selects gender
    And The User enters date of birth
    And The User enters contact info
    And The User enters relationship info
    And The User confirms registration
    Then The patient name should be displayed on the Patient Details page