Feature: Active Visits Functionality

  Background:
    Given The User is on the Login page
    When The User enters a valid username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage
    And The User should click on Active Visits option in the menu

  @smoke @activeVisits @regression
  Scenario: Successfully view active visits for a patient by ID
    When The User enters a valid patient ID from jsondata file in the Active Visits page
    And Clicks on the patient record to view details in the Active Visits page
    Then The active visit record for patient ID should be displayed

  @smoke @activeVisits @regression
  Scenario: Successfully view active visits for a patient by name
    When The User enters a valid patient name from jsondata file in the Active Visits page
    And Clicks on the patient record to view details in the Active Visits page
    Then The active visit record for patient name should be displayed

  @smoke @activeVisits @regression
  Scenario Outline: Unsuccessful search for active visits with invalid ID
    When The User enters an invalid patient ID "<patientID>" in the Active Visits page
    Then An error message should be displayed "No matching records found" in the Active Visits page

    Examples:
      | patientID   |
      | invalidID   |
      | 99999       |

